inherit ruby-gem
GEM_NAME = "actiontext"
SRC_URI[sha256sum] = "5b1418f407ea347b98084a62b9b6caa1d3b1eb482d18dbbb69fad43f242843e3"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-globalid ruby-gem-nokogiri"

