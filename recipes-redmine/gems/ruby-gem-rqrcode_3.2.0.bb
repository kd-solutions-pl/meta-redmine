inherit ruby-gem
GEM_NAME = "rqrcode"
SRC_URI[sha256sum] = "64c1494ca6bb67d731330f38b50e3fd09eeab4f5dcd04b608e21218d1d0b9542"
RDEPENDS:${PN} += "ruby-gem-chunky-png ruby-gem-rqrcode-core"
