inherit ruby-gem
GEM_NAME = "rails-html-sanitizer"
SRC_URI[sha256sum] = "35fce2ca8242da8775c83b6ba9c1bcaad6751d9eb73c1abaa8403475ab89a560"
RDEPENDS:${PN} += "ruby-gem-loofah ruby-gem-nokogiri"

