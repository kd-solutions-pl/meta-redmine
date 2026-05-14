inherit ruby-gem
GEM_NAME = "propshaft"
SRC_URI[sha256sum] = "d389361faf66aeb17e8d204828962c1e506edd14a1a17adb3fa475435c070f6b"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activesupport ruby-gem-rack ruby-gem-railties"

