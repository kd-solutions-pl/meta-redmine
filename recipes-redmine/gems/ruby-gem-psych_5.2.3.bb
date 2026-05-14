inherit ruby-gem
GEM_NAME = "psych"
SRC_URI[sha256sum] = "84a54bb952d14604fea22d99938348814678782f58b12648fcdfa4d2fce859ee"
DEPENDS += "libyaml"
RDEPENDS:${PN} += "libyaml"

