inherit ruby-gem
GEM_NAME = "propshaft"
SRC_URI[sha256sum] = "1d56a3e56a92c21bfc29caf07406b5386b00d4c47ddf357cf989a5a234b1389e"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activesupport ruby-gem-rack"
