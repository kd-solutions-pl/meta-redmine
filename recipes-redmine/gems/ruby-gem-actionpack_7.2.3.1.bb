inherit ruby-gem
GEM_NAME = "actionpack"
SRC_URI[sha256sum] = "b66afe7f937273270cb63f03bde7af7ba850017867766e8848d06d3e12e1e4ca"
RDEPENDS:${PN} += "ruby-gem-actionview ruby-gem-activesupport ruby-gem-nokogiri ruby-gem-rack ruby-gem-rack-session ruby-gem-rack-test ruby-gem-rails-dom-testing ruby-gem-rails-html-sanitizer ruby-gem-useragent"

