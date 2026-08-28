inherit ruby-gem
GEM_NAME = "rack-session"
SRC_URI[sha256sum] = "595434f8c0c3473ae7d7ac56ecda6cc6dfd9d37c0b2b5255330aa1576967ffe8"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-rack"
