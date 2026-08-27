inherit ruby-gem
GEM_NAME = "importmap-rails"
SRC_URI[sha256sum] = "7101be2a4dc97cf1558fb8f573a718404c5f6bcfe94f304bf1f39e444feeb16a"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activesupport ruby-gem-railties"
