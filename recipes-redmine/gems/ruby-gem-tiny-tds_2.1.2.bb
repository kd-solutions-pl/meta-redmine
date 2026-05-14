inherit ruby-gem
GEM_NAME = "tiny_tds"
SRC_URI[sha256sum] = "51b08c14da7b099fde2dda40937b7022ac9f7dddf48025701e6d0e402ffa13fe"
DEPENDS += "freetds"
RDEPENDS:${PN} += "freetds"

