inherit ruby-gem
GEM_NAME = "sidekiq"
SRC_URI[sha256sum] = "91ad48c7e6c32e1846bf1d5b74c27948758049b93fed0cb539f8d586c7de3415"
RDEPENDS:${PN} += "ruby-gem-connection-pool ruby-gem-json ruby-gem-logger ruby-gem-rack ruby-gem-redis-client"
