class CreatePictures < ActiveRecord::Migration
    def self.up
      create_table :pictures do |t|
        t.column :user, :string
        t.column :tag, :string
        t.column :description, :string
        t.column :date, :string
        t.column :score, :int
        t.column :content_type, :string
        t.column :data, :binary, :limit => 1.megabyte
      end
    end

    def self.down
      drop_table :approved_pictures
    end
  end
