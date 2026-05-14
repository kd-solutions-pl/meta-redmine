inherit ruby-gem
GEM_NAME = "mysql2"
SRC_URI[sha256sum] = "70f447d45d6b3cc16b00f7dd30366f708a81b4093a35d026ff7135d778d8da33"
DEPENDS += "virtual/mysql"
RDEPENDS:${PN} += "libmysqlclient"
