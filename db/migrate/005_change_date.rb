class ChangeDate < ActiveRecord::Migration
  def self.up
    change_column :pictures, :date, :date
  end

  def self.down
    change_column :pictures, :date, :string
  end
end
