inherit ruby-gem
GEM_NAME = "actionmailbox"
SRC_URI[sha256sum] = "a4e73480c97ab2fff5a416f92c54b065b1a6564ea4a807d42e0b83a94d4ec541"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activejob ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-mail"

