inherit ruby-gem cargo_common
GEM_NAME = "commonmarker"
SRC_URI[sha256sum] = "711abde5015289f657b28a4edadd77d14f2c898d824595be6cd7018664cc8d7a"

require ruby-gem-commonmarker-crates.inc

SRC_URI += "file://0001-bindgen-match-ruby-header-directories.patch;patchdir=${CARGO_HOME}/bitbake/rb-sys-build-0.9.128"

# ruby-gem skips configure, but Cargo needs its local source configuration.
python __anonymous() {
    d.delVarFlag("do_configure", "noexec")
}
do_configure() {
    cargo_common_do_configure
}

# Native extensions are built by gem install; never fetch crates in that task.
export CARGO_NET_OFFLINE = "true"

DEPENDS += "ruby-gem-rb-sys ruby-gem-rake-compiler-dock cargo-native rust-native clang-native libstd-rs"
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
    eval "export CARGO_TARGET_${build_triple}_LINKER='${RUST_BUILD_CCLD}'"
    eval "export CARGO_TARGET_${host_triple}_LINKER='${RUST_TARGET_CCLD}'"
    export HOST_CC="${RUST_BUILD_CC}"
    export HOST_CXX="${RUST_BUILD_CXX}"
}

do_install:append() {
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/commonmarker/target
}
RDEPENDS:${PN} += "ruby-gem-rake-compiler-dock ruby-gem-rb-sys"
