inherit ruby-gem
GEM_NAME = "roadie"
SRC_URI[sha256sum] = "665a6a8df15fbc805583b341331cbd43b9717f014a8e46dac799266af62c1cc1"
RDEPENDS:${PN} += "ruby-gem-css-parser ruby-gem-nokogiri"
