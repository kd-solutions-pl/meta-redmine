inherit ruby-gem
GEM_NAME = "actioncable"
SRC_URI[sha256sum] = "cfcd72f8c861e01ccdc96d772ad8c5ad6ed0ea7c571aef81a794b6027eaa7f11"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activesupport ruby-gem-nio4r ruby-gem-websocket-driver ruby-gem-zeitwerk"
