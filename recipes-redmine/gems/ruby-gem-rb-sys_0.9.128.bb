inherit ruby-gem
GEM_NAME = "rb_sys"
SRC_URI[sha256sum] = "9ab81f4d6d4e1895de18762232362d1264475aa7035756b50441e442130538fd"

DEPENDS += "ruby-gem-rake-compiler-dock"
RDEPENDS:${PN} += "ruby-gem-rake-compiler-dock"
