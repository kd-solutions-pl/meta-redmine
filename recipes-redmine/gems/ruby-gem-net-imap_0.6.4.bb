inherit ruby-gem
GEM_NAME = "net-imap"
SRC_URI[sha256sum] = "9a5598c67a3022c284d98430ef1d4948e7dbdb62596f61081ea8ca933270a02b"
RDEPENDS:${PN} += "ruby-gem-date ruby-gem-net-protocol"
