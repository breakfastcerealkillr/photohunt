class CreateTagsTable < ActiveRecord::Migration
  def self.up
    create_table :tags do |t|
      t.column :short_description, :string
      t.column :long_description, :string
    end
  end

  def self.down
    drop_table :tags
  end
end
