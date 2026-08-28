inherit ruby-gem
GEM_NAME = "mail"
SRC_URI[sha256sum] = "06574eca475253d6c18145dd70af80d0eb970182d55053497c5f4d797ea160e8"
RDEPENDS:${PN} += "ruby-gem-logger ruby-gem-mini-mime ruby-gem-net-imap ruby-gem-net-pop ruby-gem-net-smtp"
