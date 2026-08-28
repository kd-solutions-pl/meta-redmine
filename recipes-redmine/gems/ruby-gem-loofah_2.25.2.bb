inherit ruby-gem
GEM_NAME = "loofah"
SRC_URI[sha256sum] = "2007f746959ac65552456e04b433e83deb22759ab38c838b4445c70e43425918"
RDEPENDS:${PN} += "ruby-gem-crass ruby-gem-nokogiri"
