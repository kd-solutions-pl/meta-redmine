inherit ruby-gem
GEM_NAME = "net-ldap"
SRC_URI[sha256sum] = "b2080b350753a9ac4930869ded8e61a1d2151c01e03b0bf07b4675cbd9ce5372"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-ostruct"
