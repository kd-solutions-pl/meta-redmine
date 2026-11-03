inherit ruby-gem
GEM_NAME = "rails"
SRC_URI[sha256sum] = "5f3ecdf9a2a3b79b2e31b8fee3b64a00f7284d76e5631f87d0e58e665911a33b"
RDEPENDS:${PN} += "ruby-gem-actioncable ruby-gem-actionmailbox ruby-gem-actionmailer ruby-gem-actionpack ruby-gem-actiontext ruby-gem-actionview ruby-gem-activejob ruby-gem-activemodel ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-railties"
