inherit ruby-gem
GEM_NAME = "actionmailer"
SRC_URI[sha256sum] = "88ea441b28ff02a0c6c006468892642a3d9942affce9d294e81a74504aa5c43c"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-actionview ruby-gem-activejob ruby-gem-activesupport ruby-gem-mail ruby-gem-rails-dom-testing"
