inherit ruby-gem
GEM_NAME = "roadie"
SRC_URI[sha256sum] = "e4a4f61ce792bd91b228b6844b4bad6b160cdc1b8df86c81a8b983082a5001d6"
RDEPENDS:${PN} += "ruby-gem-css-parser ruby-gem-nokogiri"
