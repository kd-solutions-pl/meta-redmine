inherit ruby-gem
GEM_NAME = "railties"
SRC_URI[sha256sum] = "2388a232579a00cefea4487de66c8553c3408c1300abdc6cf1799d86ffb04487"
RDEPENDS:${PN} += "bash ruby-gem-actionpack ruby-gem-activesupport ruby-gem-irb ruby-gem-rackup ruby-gem-thor ruby-gem-tsort ruby-gem-zeitwerk"
