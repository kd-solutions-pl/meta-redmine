inherit ruby-gem
GEM_NAME = "activestorage"
SRC_URI[sha256sum] = "f555254f387b1cffa499d2fd3115d12635eadc5b15206a8534316a67036163ef"
RDEPENDS:${PN} += "ruby-gem-actionpack ruby-gem-activejob ruby-gem-activerecord ruby-gem-activesupport ruby-gem-marcel"
