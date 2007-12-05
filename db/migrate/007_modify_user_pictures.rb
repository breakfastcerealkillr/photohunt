class ModifyUserPictures < ActiveRecord::Migration
  def self.up
    rename_column :pictures, :user, :user_email
    Picture.update_all('user_email = "temp@photohunt.org"')
  end

  def self.down
    rename_column :pictures, :user_email, :user
  end
end
