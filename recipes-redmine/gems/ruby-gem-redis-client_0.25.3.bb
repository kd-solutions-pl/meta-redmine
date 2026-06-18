inherit ruby-gem
GEM_NAME = "redis-client"
SRC_URI[sha256sum] = "bff579db68dd7c59be8f9575a5825d8fb2a23944438f6e5e7e57e7ffddd34e50"
RDEPENDS:${PN} += "ruby-gem-connection-pool"
