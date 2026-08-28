inherit ruby-gem
GEM_NAME = "activejob"
SRC_URI[sha256sum] = "1c8dd275df930df40deecffec63d913a550a33fd94bd298f69721dd96939954a"
RDEPENDS:${PN} += "ruby-gem-activesupport ruby-gem-globalid"
