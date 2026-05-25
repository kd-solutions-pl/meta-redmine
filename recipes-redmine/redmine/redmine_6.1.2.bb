SUMMARY = "Redmine project management web application"
HOMEPAGE = "https://www.redmine.org/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://doc/COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://www.redmine.org/releases/redmine-${PV}.tar.gz \
           file://0001-Add-Ruby-4.0-to-supported-Ruby-versions-under-Yocto.patch \
           file://redmine.service \
           file://redmine-storage-prepare.service \
           file://redmine-storage-prepare \
           file://redmine-prepare \
           file://redmine.env \
           file://database.yml \
           file://configuration.yml \
           file://additional_environment.rb \
           file://strip-gemspec-native-extensions.rb \
           "
SRC_URI[sha256sum] = "938e975e808ccfb4b0dcbad8b42f02aacf0ca9ef15491c38c5af4756740ccf08"

inherit systemd useradd

REDMINE_HOME = "/opt/redmine"
REDMINE_DATA_DIR = "/data"
REDMINE_WRITABLE_DIR = "${REDMINE_DATA_DIR}/redmine"
REDMINE_LOG_DIR = "${REDMINE_DATA_DIR}/log/redmine"

DEPENDS += " \
    ruby-native \
    ruby \
    imagemagick \
    ruby-gem-actioncable \
    ruby-gem-actionmailbox \
    ruby-gem-actionmailer \
    ruby-gem-actionpack \
    ruby-gem-actionpack-xml-parser \
    ruby-gem-actiontext \
    ruby-gem-actionview \
    ruby-gem-activejob \
    ruby-gem-activemodel \
    ruby-gem-activerecord \
    ruby-gem-activestorage \
    ruby-gem-activesupport \
    ruby-gem-addressable \
    ruby-gem-base64 \
    ruby-gem-bcrypt \
    ruby-gem-benchmark \
    ruby-gem-bigdecimal \
    ruby-gem-builder \
    ruby-gem-cgi \
    ruby-gem-chunky-png \
    ruby-gem-commonmarker \
    ruby-gem-concurrent-ruby \
    ruby-gem-connection-pool \
    ruby-gem-crass \
    ruby-gem-css-parser \
    ruby-gem-csv \
    ruby-gem-date \
    ruby-gem-doorkeeper \
    ruby-gem-doorkeeper-i18n \
    ruby-gem-drb \
    ruby-gem-erubi \
    ruby-gem-globalid \
    ruby-gem-html-pipeline \
    ruby-gem-htmlentities \
    ruby-gem-i18n \
    ruby-gem-importmap-rails \
    ruby-gem-io-console \
    ruby-gem-irb \
    ruby-gem-logger \
    ruby-gem-loofah \
    ruby-gem-mail \
    ruby-gem-marcel \
    ruby-gem-mini-magick \
    ruby-gem-mini-mime \
    ruby-gem-mini-portile2 \
    ruby-gem-minitest \
    ruby-gem-net-imap \
    ruby-gem-net-ldap \
    ruby-gem-net-pop \
    ruby-gem-net-protocol \
    ruby-gem-net-smtp \
    ruby-gem-nio4r \
    ruby-gem-nokogiri \
    ruby-gem-ostruct \
    ruby-gem-propshaft \
    ruby-gem-public-suffix \
    ruby-gem-puma \
    ruby-gem-pg \
    ruby-gem-rack \
    ruby-gem-rack-session \
    ruby-gem-rack-test \
    ruby-gem-rackup \
    ruby-gem-rails \
    ruby-gem-rails-dom-testing \
    ruby-gem-rails-html-sanitizer \
    ruby-gem-railties \
    ruby-gem-rb-sys \
    ruby-gem-rbpdf \
    ruby-gem-rbpdf-font \
    ruby-gem-rdoc \
    ruby-gem-requestjs-rails \
    ruby-gem-roadie \
    ruby-gem-roadie-rails \
    ruby-gem-rotp \
    ruby-gem-rouge \
    ruby-gem-rqrcode \
    ruby-gem-rqrcode-core \
    ruby-gem-rubyzip \
    ruby-gem-sanitize \
    ruby-gem-securerandom \
    ruby-gem-sqlite3 \
    ruby-gem-stimulus-rails \
    ruby-gem-thor \
    ruby-gem-timeout \
    ruby-gem-tzinfo \
    ruby-gem-useragent \
    ruby-gem-websocket-driver \
    ruby-gem-websocket-extensions \
    ruby-gem-zeitwerk \
    ruby-gem-with-advisory-lock \
    ruby-gem-sqlite3 \
    ruby-gem-net-ldap \
    ruby-gem-mini-magick \
    ruby-gem-pg \
"

RDEPENDS:${PN} = " \
    coreutils \
    ruby \
    tzdata-core \
    imagemagick \
    ruby-gem-actionpack-xml-parser \
    ruby-gem-addressable \
    ruby-gem-bcrypt \
    ruby-gem-commonmarker \
    ruby-gem-csv \
    ruby-gem-doorkeeper \
    ruby-gem-doorkeeper-i18n \
    ruby-gem-html-pipeline \
    ruby-gem-i18n \
    ruby-gem-importmap-rails \
    ruby-gem-mail \
    ruby-gem-marcel \
    ruby-gem-mini-magick \
    ruby-gem-mini-mime \
    ruby-gem-nokogiri \
    ruby-gem-ostruct \
    ruby-gem-propshaft \
    ruby-gem-puma \
    ruby-gem-pg \
    ruby-gem-rack \
    ruby-gem-rails \
    ruby-gem-rbpdf \
    ruby-gem-requestjs-rails \
    ruby-gem-roadie-rails \
    ruby-gem-rotp \
    ruby-gem-rouge \
    ruby-gem-rqrcode \
    ruby-gem-rubyzip \
    ruby-gem-sanitize \
    ruby-gem-stimulus-rails \
    ruby-gem-net-imap \
    ruby-gem-net-pop \
    ruby-gem-net-smtp \
    ruby-gem-with-advisory-lock \
    ruby-gem-sqlite3 \
    ruby-gem-net-ldap \
    ruby-gem-mini-magick \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

generate_redmine_gemfile_lock() {
    # Generate a Redmine Gemfile.lock from gems already staged by Yocto.
    #
    # Redmine's upstream Gemfile is resolved with Bundler, but this recipe
    # must not download gems or rebuild native extensions. Runtime gems are
    # built by separate ruby-gem-* recipes and are available in
    # RECIPE_SYSROOT. We copy only their gemspecs into a temporary RubyGems
    # repository, strip native extension declarations from those temporary
    # gemspec copies, and run `bundle lock --local` against that repository.
    #
    # The resulting lockfile contains the dependency graph provided by the
    # Yocto-built gems. The real sysroot gemspecs and packaged gems are not
    # modified.
    lockdir=${B}/gemfile-lock
    lock_gems=${lockdir}/gems

    rm -rf ${lockdir}
    install -d ${lockdir}/app/config ${lock_gems}
    install -m 0644 ${D}${REDMINE_HOME}/Gemfile ${lockdir}/app/Gemfile
    install -m 0644 ${D}${sysconfdir}/redmine/database.yml ${lockdir}/app/config/database.yml

    find ${RECIPE_SYSROOT}${libdir}/ruby/gems -path '*/specifications/*.gemspec' -type f | while read spec; do
        rel=${spec#${RECIPE_SYSROOT}${libdir}/ruby/gems/}
        install -D -m 0644 "$spec" "${lock_gems}/$rel"
    done

    ${STAGING_BINDIR_NATIVE}/ruby ${UNPACKDIR}/strip-gemspec-native-extensions.rb ${lock_gems}

    gem_path=${lock_gems}
    for path in ${lock_gems}/*; do
        if [ -d "$path/specifications" ]; then
            gem_path="${gem_path}:$path"
        fi
    done

    (
        cd ${lockdir}/app
        export REDMINE_SKIP_DEVELOPMENT_TEST_GEMS=1
        export BUNDLE_GEMFILE="${lockdir}/app/Gemfile"
        export GEM_HOME="${lock_gems}"
        export GEM_PATH="${gem_path}"
        ${STAGING_BINDIR_NATIVE}/bundle lock --local --add-platform ruby
    )

    install -m 0644 ${B}/gemfile-lock/app/Gemfile.lock ${D}${REDMINE_HOME}/Gemfile.lock
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-r --user-group -u 2000 -d ${REDMINE_HOME} --no-create-home --shell /usr/sbin/nologin redmine"
SYSTEMD_SERVICE:${PN} = "redmine-storage-prepare.service redmine.service"

do_install() {
    install -d ${D}${REDMINE_HOME}
    cp -R ${S}/. ${D}${REDMINE_HOME}/
    rm -rf ${D}${REDMINE_HOME}/.git

    install -d ${D}${sysconfdir}/default
    install -m 0644 ${UNPACKDIR}/redmine.env ${D}${sysconfdir}/default/redmine

    install -d ${D}${sysconfdir}/redmine
    install -m 0640 ${UNPACKDIR}/database.yml ${D}${sysconfdir}/redmine/database.yml
    install -m 0640 ${UNPACKDIR}/configuration.yml ${D}${sysconfdir}/redmine/configuration.yml
    install -m 0644 ${UNPACKDIR}/additional_environment.rb ${D}${REDMINE_HOME}/config/additional_environment.rb
    ln -snf ${REDMINE_WRITABLE_DIR}/config/database.yml ${D}${REDMINE_HOME}/config/database.yml
    ln -snf ${sysconfdir}/redmine/configuration.yml ${D}${REDMINE_HOME}/config/configuration.yml

    for file in ${sysconfdir}/default/redmine ${sysconfdir}/redmine/database.yml ${sysconfdir}/redmine/configuration.yml ${REDMINE_HOME}/config/additional_environment.rb
    do
        sed -i \
            -e 's|@REDMINE_HOME@|${REDMINE_HOME}|g' \
            -e 's|@REDMINE_WRITABLE_DIR@|${REDMINE_WRITABLE_DIR}|g' \
            -e 's|@REDMINE_LOG_DIR@|${REDMINE_LOG_DIR}|g' \
            ${D}${file}
    done

    # Move runtime-mutated Redmine state out of /opt/redmine into writable/persistent storage.
    generate_redmine_gemfile_lock
    ln -snf ${REDMINE_WRITABLE_DIR}/public/assets ${D}${REDMINE_HOME}/public/assets
    mv ${D}${REDMINE_HOME}/Gemfile.lock ${D}${REDMINE_HOME}/Gemfile.lock.dist
    ln -snf ${REDMINE_WRITABLE_DIR}/Gemfile.lock ${D}${REDMINE_HOME}/Gemfile.lock

    rm -rf ${D}${REDMINE_HOME}/files ${D}${REDMINE_HOME}/log ${D}${REDMINE_HOME}/tmp ${D}${REDMINE_HOME}/config/initializers/secret_token.rb
    ln -snf ${REDMINE_WRITABLE_DIR}/files ${D}${REDMINE_HOME}/files
    ln -snf ${REDMINE_LOG_DIR} ${D}${REDMINE_HOME}/log
    ln -snf ${REDMINE_WRITABLE_DIR}/tmp ${D}${REDMINE_HOME}/tmp
    ln -snf ${REDMINE_WRITABLE_DIR}/config/initializers/secret_token.rb ${D}${REDMINE_HOME}/config/initializers/secret_token.rb

    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/redmine-prepare ${D}${bindir}/redmine-prepare
    install -m 0755 ${UNPACKDIR}/redmine-storage-prepare ${D}${bindir}/redmine-storage-prepare
    install -d ${D}${datadir}/redmine
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/redmine.service ${D}${systemd_system_unitdir}/redmine.service
    install -m 0644 ${UNPACKDIR}/redmine-storage-prepare.service ${D}${systemd_system_unitdir}/redmine-storage-prepare.service
    chown -R redmine:redmine "${D}${sysconfdir}/redmine" "${D}/${REDMINE_HOME}"

}

FILES:${PN} += "${REDMINE_HOME} ${sysconfdir}/redmine ${sysconfdir}/default/redmine ${bindir}/redmine-prepare ${bindir}/redmine-storage-prepare"
CONFFILES:${PN} += "${sysconfdir}/redmine/database.yml ${sysconfdir}/redmine/configuration.yml ${sysconfdir}/default/redmine"
