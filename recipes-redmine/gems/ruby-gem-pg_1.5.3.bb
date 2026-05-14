inherit ruby-gem
GEM_NAME = "pg"
SRC_URI[sha256sum] = "6b9ee5e2d5aee975588232c41f8203e766157cf71dba54ee85b343a45ced9bfd"
DEPENDS += "postgresql"
RDEPENDS:${PN} += "postgresql"

