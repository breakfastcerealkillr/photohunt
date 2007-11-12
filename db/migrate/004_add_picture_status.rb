class AddPictureStatus < ActiveRecord::Migration
  def self.up
    add_column :pictures, :status, :string
    Picture.update_all("status = 'APPROVED'")
  end

  def self.down
    remove_column :pictures, :status
  end
end
