inherit ruby-gem
GEM_NAME = "sidekiq"
SRC_URI[sha256sum] = "1108712e1def89002b28e3545d5ae15d4a57ffd4d2c25d97bb1360988826b5a7"
RDEPENDS:${PN} += "ruby-gem-base64 ruby-gem-connection-pool ruby-gem-logger ruby-gem-rack ruby-gem-redis-client"
