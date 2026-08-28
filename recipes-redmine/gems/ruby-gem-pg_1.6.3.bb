inherit ruby-gem
GEM_NAME = "pg"
SRC_URI[sha256sum] = "1388d0563e13d2758c1089e35e973a3249e955c659592d10e5b77c468f628a99"
DEPENDS += "postgresql"
RDEPENDS:${PN} += "postgresql"
