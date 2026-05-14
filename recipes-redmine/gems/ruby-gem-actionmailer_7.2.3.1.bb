inherit ruby-gem
GEM_NAME = "actionmailer"
SRC_URI[sha256sum] = "f578b6d5c5f81a20b6f6a796187698890c8348c041daa5e2e7cf7814ac520467"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-actionview ruby-gem-activejob ruby-gem-activesupport ruby-gem-mail ruby-gem-rails-dom-testing"

