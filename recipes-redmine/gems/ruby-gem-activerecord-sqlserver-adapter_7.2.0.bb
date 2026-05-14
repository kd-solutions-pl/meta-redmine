inherit ruby-gem
GEM_NAME = "activerecord-sqlserver-adapter"
SRC_URI[sha256sum] = "03334db008202e14965ebad7d8918fd8167807f2f1e0bc8c58775487d0d9c69d"
RDEPENDS:${PN} += "ruby-gem-activerecord ruby-gem-tiny-tds"

