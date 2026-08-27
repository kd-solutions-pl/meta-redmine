inherit ruby-gem
GEM_NAME = "websocket-driver"
SRC_URI[sha256sum] = "97c556b019bf3410b4961002ac501621e9322d3f8a7bc02161a09301cc4c4146"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-websocket-extensions"
