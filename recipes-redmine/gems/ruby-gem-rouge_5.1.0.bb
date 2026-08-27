inherit ruby-gem
GEM_NAME = "rouge"
SRC_URI[sha256sum] = "b77c632842ab7f5147940212f0345808cccfbce864fd5b631d7d12a35ac85452"
RDEPENDS:${PN} += "ruby-gem-strscan"
