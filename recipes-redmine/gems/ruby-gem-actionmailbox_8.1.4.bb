inherit ruby-gem
GEM_NAME = "actionmailbox"
SRC_URI[sha256sum] = "9c4525e577ebb671ce558f3ea78b8a634f64e56a0e6e8d105b28b873793a06eb"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activejob ruby-gem-activerecord ruby-gem-activestorage ruby-gem-activesupport ruby-gem-mail"
