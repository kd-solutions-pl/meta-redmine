inherit ruby-gem
GEM_NAME = "websocket-driver"
SRC_URI[sha256sum] = "056d99f2cd545712cfb1291650fde7478e4f2661dc1db6a0fa3b966231a146b4"
RDEPENDS:${PN} += "ruby-gem-websocket-extensions"
