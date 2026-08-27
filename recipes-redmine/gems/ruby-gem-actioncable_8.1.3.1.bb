inherit ruby-gem
GEM_NAME = "actioncable"
SRC_URI[sha256sum] = "e318528295c878a3efdfe25f0f2267c80cb7a76eba41bb5f64d44aa380a3d91b"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activesupport ruby-gem-nio4r ruby-gem-websocket-driver ruby-gem-zeitwerk"
