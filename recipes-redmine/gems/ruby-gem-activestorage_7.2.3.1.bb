inherit ruby-gem
GEM_NAME = "activestorage"
SRC_URI[sha256sum] = "0b224ea42e6256d3e33768bdccad8e3c9110a5140fc9faf98bde8873dd5dffab"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activejob ruby-gem-activerecord ruby-gem-activesupport ruby-gem-marcel"

