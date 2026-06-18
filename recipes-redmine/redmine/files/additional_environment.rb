# frozen_string_literal: true

writable_dir = ENV.fetch('REDMINE_WRITABLE_DIR', '@REDMINE_WRITABLE_DIR@')
log_dir = ENV.fetch('REDMINE_LOG_DIR', '@REDMINE_LOG_DIR@')

config.paths['log'] = File.join(log_dir, "#{Rails.env}.log")
config.cache_store = :file_store, File.join(writable_dir, 'tmp', 'cache')
config.active_record.dump_schema_after_migration = false
config.active_job.queue_adapter = :sidekiq
config.force_ssl = true
