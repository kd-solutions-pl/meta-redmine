inherit ruby-gem
GEM_NAME = "actionpack"
SRC_URI[sha256sum] = "974cb7154548e81f470b1b0f247b99cb38e87825899dca58610596e2817723d0"
RDEPENDS:${PN} += "ruby-gem-actionview ruby-gem-activesupport ruby-gem-nokogiri ruby-gem-rack ruby-gem-rack-session ruby-gem-rack-test ruby-gem-rails-dom-testing ruby-gem-rails-html-sanitizer ruby-gem-useragent"
