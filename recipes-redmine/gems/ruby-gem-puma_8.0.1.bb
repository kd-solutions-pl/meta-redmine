inherit ruby-gem
GEM_NAME = "puma"
SRC_URI[sha256sum] = "7b94e50c07655718c1fb8ae41a11fc06c7d61293208b3aa608ff71a46d3ad37c"
DEPENDS += "openssl"
RDEPENDS:${PN} += "openssl ruby-gem-nio4r"

