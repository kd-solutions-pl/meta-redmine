inherit ruby-gem
GEM_NAME = "sqlite3"
SRC_URI[sha256sum] = "87fa0036e6369c3f3cfeca749865c2b2b63649d3b17b223d1939a8eed4841a6b"
DEPENDS += "sqlite3 ruby-gem-mini-portile2 pkgconfig-native"
RDEPENDS:${PN} += "sqlite3 ruby-gem-mini-portile2"
GEM_INSTALL_ARGS = "-- --enable-system-libraries --with-sqlite3-include=${STAGING_INCDIR} --with-sqlite3-lib=${STAGING_LIBDIR}"

do_install:append() {
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ports
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/sqlite3/tmp
}
