inherit ruby-gem
GEM_NAME = "actionview"
SRC_URI[sha256sum] = "de19b86843391762ac24a6287c30fbba11cd475fa4d4b664924d5fb7a2f1ff7c"
RDEPENDS:${PN} += "ruby-gem-activesupport ruby-gem-builder ruby-gem-cgi ruby-gem-erubi ruby-gem-rails-dom-testing ruby-gem-rails-html-sanitizer"
