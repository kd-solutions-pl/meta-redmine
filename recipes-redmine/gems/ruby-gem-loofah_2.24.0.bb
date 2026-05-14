inherit ruby-gem
GEM_NAME = "loofah"
SRC_URI[sha256sum] = "61e6a710883abb8210887f3dc868cf3ed66594c509d9ff6987621efa6651ee1e"
RDEPENDS:${PN} += "ruby-gem-crass ruby-gem-nokogiri"

