inherit ruby-gem
GEM_NAME = "ffi"
SRC_URI[sha256sum] = "bcd1642e06f0d16fc9e09ac6d49c3a7298b9789bcb58127302f934e437d60acf"
DEPENDS += "libffi pkgconfig-native"
RDEPENDS:${PN} += "libffi"
GEM_INSTALL_ARGS = "-- --enable-system-libffi"

