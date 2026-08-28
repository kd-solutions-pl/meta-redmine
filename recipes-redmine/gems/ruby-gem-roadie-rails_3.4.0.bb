inherit ruby-gem
GEM_NAME = "roadie-rails"
SRC_URI[sha256sum] = "f7b02bd3b74051eaa51ebb636049c4c9fc54cf2a68234eafc5a5fb78ad1f9aa9"
RDEPENDS:${PN} += "ruby-gem-railties ruby-gem-roadie"
