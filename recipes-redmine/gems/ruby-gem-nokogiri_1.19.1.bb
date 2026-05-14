inherit ruby-gem
GEM_NAME = "nokogiri"
SRC_URI[sha256sum] = "598b327f36df0b172abd57b68b18979a6e14219353bca87180c31a51a00d5ad3"
DEPENDS += "libxml2 libxslt zlib pkgconfig-native ruby-gem-mini-portile2"
RDEPENDS:${PN} += "libxml2 libxslt zlib ruby-gem-mini-portile2"
GEM_INSTALL_ARGS = "-- --use-system-libraries --with-xml2-include=${STAGING_INCDIR}/libxml2 --with-xml2-lib=${STAGING_LIBDIR} --with-xslt-include=${STAGING_INCDIR} --with-xslt-lib=${STAGING_LIBDIR}"

do_install:append() {
    rm -rf ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/ext/nokogiri/ports
}
