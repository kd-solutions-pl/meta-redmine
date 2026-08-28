inherit ruby-gem
GEM_NAME = "redis-client"
SRC_URI[sha256sum] = "5151bc5c7bbfe48623732cdae3b900d8a22dc691cc7cdfacfb351ac55116522d"
RDEPENDS:${PN} += "ruby-gem-connection-pool"
