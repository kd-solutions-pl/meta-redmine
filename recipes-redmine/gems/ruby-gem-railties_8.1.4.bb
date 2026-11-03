inherit ruby-gem
GEM_NAME = "railties"
SRC_URI[sha256sum] = "b5e7a8e8984e33114d68af62227971960aae1e6c02bd7c9d826ffad97fff583c"
RDEPENDS:${PN} += "bash ruby-gem-actionpack ruby-gem-activesupport ruby-gem-rackup ruby-gem-thor ruby-gem-tsort ruby-gem-zeitwerk"
