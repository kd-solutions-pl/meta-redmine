inherit ruby-gem
GEM_NAME = "rbpdf-font"
SRC_URI[sha256sum] = "3b3498ea4f9e71bea0f7a069408d50c3c4e85b1aa496e22f2ee8b84d28c8b45f"

do_install:append() {
    rm -f ${D}${libdir}/ruby/gems/gems/${GEM_NAME}-${PV}/lib/fonts/ttf2ufm/ttf2ufm
}
