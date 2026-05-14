inherit ruby-gem
GEM_NAME = "actioncable"
SRC_URI[sha256sum] = "d3bf40a3f4fc79a09709878f0e5c43a5e2d8e6607089f6b38f9472b8715eb33c"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activesupport ruby-gem-nio4r ruby-gem-websocket-driver ruby-gem-zeitwerk"

