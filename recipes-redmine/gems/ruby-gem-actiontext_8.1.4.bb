inherit ruby-gem
GEM_NAME = "actiontext"
SRC_URI[sha256sum] = "33ee99bea7da6af911fc7d98b17013a8e1ec62aa01b20b20e9a5366f40dbf644"
RDEPENDS:${PN} += "ruby-gem-action-text-trix ruby-gem-actionpack ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-globalid ruby-gem-nokogiri"
