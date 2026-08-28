inherit ruby-gem
GEM_NAME = "rb_sys"
SRC_URI[sha256sum] = "7d486d99c1da02635515deaf9860fc5aea90bb4ab2589b2deec7fdc7d3548615"

DEPENDS += "ruby-gem-rake-compiler-dock"
RDEPENDS:${PN} += "ruby-gem-rake-compiler-dock"
