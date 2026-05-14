inherit ruby-gem
GEM_NAME = "rails-dom-testing"
SRC_URI[sha256sum] = "8acc7953a7b911ca44588bf08737bc16719f431a1cc3091a292bca7317925c1d"
RDEPENDS:${PN} += "ruby-gem-activesupport ruby-gem-minitest ruby-gem-nokogiri"

