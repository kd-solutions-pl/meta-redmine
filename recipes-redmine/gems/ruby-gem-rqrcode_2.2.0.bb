inherit ruby-gem
GEM_NAME = "rqrcode"
SRC_URI[sha256sum] = "23eea88bb44c7ee6d6cab9354d08c287f7ebcdc6112e1fe7bcc2d010d1ffefc1"
RDEPENDS:${PN} += "ruby-gem-chunky-png ruby-gem-rqrcode-core"

