inherit ruby-gem
GEM_NAME = "actiontext"
SRC_URI[sha256sum] = "5da729d833d1a29cddb1eee938878e55e503d2613e00e735f5daf58c2ba98af2"
RDEPENDS:${PN} += "ruby-gem-action-text-trix ruby-gem-actionpack ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-globalid ruby-gem-nokogiri"
