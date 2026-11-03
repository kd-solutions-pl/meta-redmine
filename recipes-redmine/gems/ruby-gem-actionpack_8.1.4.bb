inherit ruby-gem
GEM_NAME = "actionpack"
SRC_URI[sha256sum] = "245493cc51be195a7645e6fc184880fa7e5b32ff1a08e053ee31f58c76e30ea4"
RDEPENDS:${PN} += "ruby-gem-actionview ruby-gem-activesupport ruby-gem-nokogiri ruby-gem-rack ruby-gem-rack-session ruby-gem-rack-test ruby-gem-rails-dom-testing ruby-gem-rails-html-sanitizer ruby-gem-useragent"
