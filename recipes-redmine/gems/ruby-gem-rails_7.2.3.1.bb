inherit ruby-gem
GEM_NAME = "rails"
SRC_URI[sha256sum] = "96c0a0160081ef3f1e407438880f6194c6ec94cdf40c8f83fc7bb22c279eba94"
RDEPENDS:${PN} += "ruby-gem-actioncable ruby-gem-actionmailbox ruby-gem-actionmailer ruby-gem-actionpack ruby-gem-actiontext ruby-gem-actionview ruby-gem-activejob ruby-gem-activemodel ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-railties"
