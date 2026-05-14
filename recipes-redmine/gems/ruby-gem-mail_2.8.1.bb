inherit ruby-gem
GEM_NAME = "mail"
SRC_URI[sha256sum] = "ec3b9fadcf2b3755c78785cb17bc9a0ca9ee9857108a64b6f5cfc9c0b5bfc9ad"
RDEPENDS:${PN} += "ruby-gem-mini-mime ruby-gem-net-imap ruby-gem-net-pop ruby-gem-net-smtp"

