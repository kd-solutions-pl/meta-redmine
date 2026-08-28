inherit ruby-gem
GEM_NAME = "rails"
SRC_URI[sha256sum] = "ccd11a36bfc171bf9c66d585d14c0ece91c0c9dde840aae60c0118d6f5c9c52a"
RDEPENDS:${PN} += "ruby-gem-actioncable ruby-gem-actionmailbox ruby-gem-actionmailer ruby-gem-actionpack ruby-gem-actiontext ruby-gem-actionview ruby-gem-activejob ruby-gem-activemodel ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-railties"
