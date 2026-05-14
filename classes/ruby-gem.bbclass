SUMMARY ?= "Ruby gem ${GEM_NAME}"
HOMEPAGE ?= "https://rubygems.org/gems/${GEM_NAME}"
SECTION = "ruby/gems"
LICENSE ?= "CLOSED"

GEM_NAME ?= "${BPN}"
GEM_INSTALL_ARGS ?= ""

SRC_URI = "https://rubygems.org/downloads/${GEM_NAME}-${PV}.gem;unpack=0"
S = "${UNPACKDIR}"

DEPENDS += "ruby ruby-native chrpath-native"
RDEPENDS:${PN} += "ruby"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    export GEM_HOME="${D}${libdir}/ruby/gems"
    export GEM_PATH="${D}${libdir}/ruby/gems:${STAGING_LIBDIR}/ruby/gems"
    export PKG_CONFIG_SYSROOT_DIR="${STAGING_DIR_HOST}"
    export PKG_CONFIG_LIBDIR="${STAGING_LIBDIR}/pkgconfig:${STAGING_DATADIR}/pkgconfig"
    export PKG_CONFIG_PATH="${PKG_CONFIG_LIBDIR}"

    target_rbconfig="$(find ${STAGING_LIBDIR}/ruby -name rbconfig.rb -print -quit)"
    if [ -n "${target_rbconfig}" ]; then
        install -d ${B}/ruby-cross-config
        {
            echo "load '${target_rbconfig}'"
            echo "RbConfig::CONFIG['bindir'] = '${STAGING_BINDIR_NATIVE}'"
            echo "RbConfig::MAKEFILE_CONFIG['bindir'] = '${STAGING_BINDIR_NATIVE}'"
            echo "def oe_set_config(key, value)"
            echo "  RbConfig::CONFIG[key] = value"
            echo "  RbConfig::MAKEFILE_CONFIG[key] = value"
            echo "end"
            echo "oe_set_config('CC', %q[${CC}])"
            echo "oe_set_config('CXX', %q[${CXX}])"
            echo "oe_set_config('CPP', %q[${CPP}])"
            echo "oe_set_config('LD', %q[${LD}])"
            echo "oe_set_config('LDSHARED', %q[${CC} -shared])"
            echo "oe_set_config('LDSHAREDXX', %q[${CXX} -shared])"
            echo "oe_set_config('CFLAGS', %q[${CFLAGS}])"
            echo "oe_set_config('CXXFLAGS', %q[${CXXFLAGS}])"
            echo "oe_set_config('CPPFLAGS', %q[${CPPFLAGS}])"
            echo "oe_set_config('LDFLAGS', %q[${LDFLAGS}])"
            echo "RbConfig::CONFIG['includedir'] = '${STAGING_INCDIR}'"
            echo "RbConfig::MAKEFILE_CONFIG['includedir'] = '${STAGING_INCDIR}'"
            echo "RbConfig::CONFIG['libdir'] = '${STAGING_LIBDIR}'"
            echo "RbConfig::MAKEFILE_CONFIG['libdir'] = '${STAGING_LIBDIR}'"
            echo "ruby_version = RbConfig::CONFIG['ruby_version']"
            echo "arch = RbConfig::CONFIG['arch']"
            echo "RbConfig::CONFIG['rubyhdrdir'] = '${STAGING_INCDIR}/ruby-' + ruby_version"
            echo "RbConfig::MAKEFILE_CONFIG['rubyhdrdir'] = RbConfig::CONFIG['rubyhdrdir']"
            echo "RbConfig::CONFIG['rubyarchhdrdir'] = RbConfig::CONFIG['rubyhdrdir'] + '/' + arch"
            echo "RbConfig::MAKEFILE_CONFIG['rubyarchhdrdir'] = RbConfig::CONFIG['rubyarchhdrdir']"
        } > ${B}/ruby-cross-config/rbconfig.rb
        export RUBYLIB="${B}/ruby-cross-config${RUBYLIB:+:${RUBYLIB}}"
        export RUBYOPT="-r${B}/ruby-cross-config/rbconfig${RUBYOPT:+ ${RUBYOPT}}"
    fi

    install -d ${D}${libdir}/ruby/gems
    install -d ${D}${bindir}

    gem install --local ${UNPACKDIR}/${GEM_NAME}-${PV}.gem \
        --install-dir ${D}${libdir}/ruby/gems \
        --bindir ${D}${bindir} \
        --no-document \
        --env-shebang \
        --ignore-dependencies \
        ${GEM_INSTALL_ARGS}

    find ${D}${libdir}/ruby/gems -type f \( -name Makefile -o -name mkmf.log -o -name gem_make.out \) -delete
    find ${D}${libdir}/ruby/gems -type f -name "*.so" -exec chrpath -d {} \; 2>/dev/null || true
    chown -R root:root ${D}
    rm -rf ${D}${libdir}/ruby/gems/build_info
    rm -rf ${D}${libdir}/ruby/gems/cache
}

FILES:${PN} += "${libdir}/ruby/gems ${bindir}"
