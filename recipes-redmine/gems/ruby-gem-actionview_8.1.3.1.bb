inherit ruby-gem
GEM_NAME = "actionview"
SRC_URI[sha256sum] = "2da68b8414c47b43bfbed1ce69c5afe1c04f78c267aacb5660a4cab5ca12cfb6"
RDEPENDS:${PN} += "ruby-gem-activesupport ruby-gem-builder ruby-gem-erubi ruby-gem-rails-dom-testing ruby-gem-rails-html-sanitizer"
