inherit ruby-gem
GEM_NAME = "listen"
SRC_URI[sha256sum] = "c6e182db62143aeccc2e1960033bebe7445309c7272061979bb098d03760c9d2"
RDEPENDS:${PN} += "ruby-gem-logger ruby-gem-rb-fsevent ruby-gem-rb-inotify"

