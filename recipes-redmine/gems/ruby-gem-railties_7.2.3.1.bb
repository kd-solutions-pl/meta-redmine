inherit ruby-gem
GEM_NAME = "railties"
SRC_URI[sha256sum] = "aea3393ee10243ceedcbeccb45458a0d58b524b6d21bf32eff8b93853baae15a"
RDEPENDS:${PN} += "bash ruby-gem-actionpack ruby-gem-activesupport ruby-gem-rackup ruby-gem-thor ruby-gem-zeitwerk"
