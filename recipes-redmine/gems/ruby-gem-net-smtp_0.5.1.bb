inherit ruby-gem
GEM_NAME = "net-smtp"
SRC_URI[sha256sum] = "ed96a0af63c524fceb4b29b0d352195c30d82dd916a42f03c62a3a70e5b70736"
RDEPENDS:${PN} += "ruby-gem-net-protocol"
