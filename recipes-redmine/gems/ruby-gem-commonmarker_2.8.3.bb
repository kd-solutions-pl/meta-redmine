inherit ruby-gem rust-common
GEM_NAME = "commonmarker"
SRC_URI[sha256sum] = "711abde5015289f657b28a4edadd77d14f2c898d824595be6cd7018664cc8d7a"

DEPENDS += "ruby-gem-rb-sys ruby-gem-rake-compiler-dock cargo-native rust-native clang-native perl-native libstd-rs"
GEM_INSTALL_ARGS += "--force"
CFLAGS:append = " -std=gnu17 -Wno-error=incompatible-pointer-types -Wno-incompatible-pointer-types"
INSANE_SKIP:${PN} += "already-stripped"

export CARGO = "${STAGING_BINDIR_NATIVE}/cargo"
export RUSTC = "${STAGING_BINDIR_NATIVE}/rustc"

do_install:prepend() {
    build_triple="$(echo ${RUST_BUILD_SYS} | tr '[:lower:]-' '[:upper:]_')"
    host_triple="$(echo ${RUST_HOST_SYS} | tr '[:lower:]-' '[:upper:]_')"

    export RUSTFLAGS="${RUSTFLAGS}"
    export CARGO_BUILD_TARGET="${RUST_HOST_SYS}"
    export LIBCLANG_PATH="${STAGING_LIBDIR_NATIVE}"
    export BINDGEN_EXTRA_CLANG_ARGS="--sysroot=${STAGING_DIR_HOST} --target=${RUST_HOST_SYS} -std=gnu17 -I${STAGING_INCDIR}"
    cat > ${B}/rustc-wrapper <<'EOF'
#!/bin/sh
for base in "$PWD/target" "$OE_COMMONMARKER_TARGET_DIR"; do
    [ -d "$base" ] || continue
    for bindings in $(find "$base" -path '*/build/rb-sys-*/out/bindings-*.rs' -type f); do
        for name in \
            FP_INT_UPWARD FP_INT_DOWNWARD FP_INT_TOWARDZERO FP_INT_TONEARESTFROMZERO FP_INT_TONEAREST \
            FP_NAN FP_INFINITE FP_ZERO FP_SUBNORMAL FP_NORMAL
        do
            OE_RB_SYS_CONST="$name" perl -0pi -e 'my $name = $ENV{"OE_RB_SYS_CONST"}; my $count = 0; s/pub const \Q$name\E\s*:\s*[^;]+;\s*/++$count == 1 ? $& : ""/ge' "$bindings"
        done
    done
done
first_arg="$(basename -- "$1")"
if [ -n "$OE_REAL_RUSTC" ] && [ "$first_arg" = "rustc" ]; then
    shift
    exec "$OE_REAL_RUSTC" "$@"
fi
if [ -n "$OE_REAL_RUSTC" ]; then
    exec "$OE_REAL_RUSTC" "$@"
fi
exec "$@"
EOF
    chmod 0755 ${B}/rustc-wrapper
    export OE_REAL_RUSTC="${STAGING_BINDIR_NATIVE}/rustc"
    export OE_COMMONMARKER_TARGET_DIR="${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/commonmarker/target"
    export RUSTC="${B}/rustc-wrapper"
    unset RUSTC_WRAPPER
    eval "export CARGO_TARGET_${build_triple}_LINKER='${RUST_BUILD_CCLD}'"
    eval "export CARGO_TARGET_${host_triple}_LINKER='${RUST_TARGET_CCLD}'"
    export HOST_CC="${RUST_BUILD_CC}"
    export HOST_CXX="${RUST_BUILD_CXX}"
}

do_install:append() {
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/commonmarker/target
}
RDEPENDS:${PN} += "ruby-gem-rake-compiler-dock ruby-gem-rb-sys"
