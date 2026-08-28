inherit ruby-gem
GEM_NAME = "puma"
SRC_URI[sha256sum] = "c8ed871dfbbe66448ea9ffd46692342d9804d4071522b52b5331b7b6e7b686fb"
DEPENDS += "openssl"
RDEPENDS:${PN} += "openssl ruby-gem-nio4r"
