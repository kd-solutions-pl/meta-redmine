inherit ruby-gem
GEM_NAME = "activesupport"
SRC_URI[sha256sum] = "11ebed516a43a0bb47346227a35ebae4d9427465a7c9eb197a03d5c8d283cb34"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-benchmark ruby-gem-bigdecimal ruby-gem-concurrent-ruby ruby-gem-connection-pool ruby-gem-drb ruby-gem-i18n ruby-gem-logger ruby-gem-minitest ruby-gem-securerandom ruby-gem-tzinfo"

