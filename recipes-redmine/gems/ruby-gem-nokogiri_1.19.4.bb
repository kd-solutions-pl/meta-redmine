inherit ruby-gem
GEM_NAME = "nokogiri"
SRC_URI[sha256sum] = "50c951611c92bca05c51411aef45f1cbc50f2821c4802758c5c6d34696533ab5"
DEPENDS += "libxml2 libxslt zlib pkgconfig-native ruby-gem-mini-portile2"
GEM_INSTALL_ARGS = "-- --use-system-libraries --with-xml2-include=${STAGING_INCDIR}/libxml2 --with-xml2-lib=${STAGING_LIBDIR} --with-xslt-include=${STAGING_INCDIR} --with-xslt-lib=${STAGING_LIBDIR}"

do_install:append() {
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/nokogiri/ports
}
RDEPENDS:${PN} += "libxml2 libxslt ruby-gem-mini-portile2 zlib"
