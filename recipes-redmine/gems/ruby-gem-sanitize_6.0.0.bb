inherit ruby-gem
GEM_NAME = "sanitize"
SRC_URI[sha256sum] = "81795f985873f3bacee2eaaededeaafc3a29aafeaa9aff51e04b85a66bbf08ff"
RDEPENDS:${PN} += "ruby-gem-crass ruby-gem-nokogiri"

