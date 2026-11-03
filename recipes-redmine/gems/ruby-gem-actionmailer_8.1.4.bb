inherit ruby-gem
GEM_NAME = "actionmailer"
SRC_URI[sha256sum] = "f82d95d6762ae46ea38f221d3363639266af4f8e56d50e2bd367558674baf093"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-actionview ruby-gem-activejob ruby-gem-activesupport ruby-gem-mail ruby-gem-rails-dom-testing"
