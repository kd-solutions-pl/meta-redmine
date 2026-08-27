inherit ruby-gem
GEM_NAME = "sqlite3"
SRC_URI[sha256sum] = "956fe606956420d04ac7157d3ace620c8caba2135b2e05c76e483493da24d08e"
DEPENDS += "sqlite3 ruby-gem-mini-portile2 pkgconfig-native"
GEM_INSTALL_ARGS = "-- --enable-system-libraries --with-sqlite3-include=${STAGING_INCDIR} --with-sqlite3-lib=${STAGING_LIBDIR}"

do_install:append() {
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ports
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/sqlite3/tmp
}
RDEPENDS:${PN} += "ruby-gem-mini-portile2 sqlite3"
