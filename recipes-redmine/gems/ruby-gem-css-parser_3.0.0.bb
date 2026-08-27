inherit ruby-gem
GEM_NAME = "css_parser"
SRC_URI[sha256sum] = "eaf0e9283fd581d06e815235ceef4f0910c0b394c606355dbc69f93e84443885"
RDEPENDS:${PN} += "ruby-gem-addressable ruby-gem-ssrf-filter"
