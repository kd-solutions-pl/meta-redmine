inherit ruby-gem
GEM_NAME = "activestorage"
SRC_URI[sha256sum] = "f4956f3ec9ee63e5e0b332b57c877cb627f82b56f4cc902279310d2aa285c7a8"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activejob ruby-gem-activerecord ruby-gem-activesupport ruby-gem-marcel"
