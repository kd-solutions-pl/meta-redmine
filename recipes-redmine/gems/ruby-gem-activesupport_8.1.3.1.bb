inherit ruby-gem
GEM_NAME = "activesupport"
SRC_URI[sha256sum] = "85458765f25ea48b9019c46b6bb3fa5683197bf4280d9f06710a6e8d7a831376"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-bigdecimal ruby-gem-concurrent-ruby ruby-gem-connection-pool ruby-gem-drb ruby-gem-i18n ruby-gem-json ruby-gem-logger ruby-gem-securerandom ruby-gem-tzinfo ruby-gem-uri"
