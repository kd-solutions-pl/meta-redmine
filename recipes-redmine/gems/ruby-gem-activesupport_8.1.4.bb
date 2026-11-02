inherit ruby-gem
GEM_NAME = "activesupport"
SRC_URI[sha256sum] = "891dd3fe43c4fc8391934b237b1189bb1f661c932a84a840043db9d46a4e80df"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-bigdecimal ruby-gem-concurrent-ruby ruby-gem-connection-pool ruby-gem-drb ruby-gem-i18n ruby-gem-json ruby-gem-logger ruby-gem-securerandom ruby-gem-tzinfo ruby-gem-uri"
