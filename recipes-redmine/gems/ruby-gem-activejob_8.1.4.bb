inherit ruby-gem
GEM_NAME = "activejob"
SRC_URI[sha256sum] = "4ed5b2ed8d4cc5c8f5f09becfef8346f202a4884eee0c8c73cae5ac378824099"
RDEPENDS:${PN} += "ruby-gem-activesupport ruby-gem-globalid"
