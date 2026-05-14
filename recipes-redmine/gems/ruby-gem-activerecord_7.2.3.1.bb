inherit ruby-gem
GEM_NAME = "activerecord"
SRC_URI[sha256sum] = "b89513e275da5b34183c5f2a497c154b02dcc7c811d399ab557e67e36170a05d"
RDEPENDS:${PN} += "ruby-gem-activemodel ruby-gem-activesupport ruby-gem-timeout"

