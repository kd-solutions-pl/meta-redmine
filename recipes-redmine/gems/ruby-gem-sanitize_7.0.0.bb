inherit ruby-gem
GEM_NAME = "sanitize"
SRC_URI[sha256sum] = "269d1b9d7326e69307723af5643ec032ff86ad616e72a3b36d301ac75a273984"
RDEPENDS:${PN} += "ruby-gem-crass ruby-gem-nokogiri"
