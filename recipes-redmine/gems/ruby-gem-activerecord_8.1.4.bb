inherit ruby-gem
GEM_NAME = "activerecord"
SRC_URI[sha256sum] = "3b4957ea7f246c9231bd7faa909312eac03a9101aaf87977b6c52733ff00b04f"
RDEPENDS:${PN} += "ruby-gem-activemodel ruby-gem-activesupport ruby-gem-timeout"
