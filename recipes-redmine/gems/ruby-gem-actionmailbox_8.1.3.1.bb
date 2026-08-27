inherit ruby-gem
GEM_NAME = "actionmailbox"
SRC_URI[sha256sum] = "5f704972097d843ade8e435e93694a1dac732b926df1717aceba1f3840082b1c"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activejob ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-mail"
