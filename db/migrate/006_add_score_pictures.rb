class AddScorePictures < ActiveRecord::Migration
  def self.up
    Picture.update_all("score = 0")
  end

  def self.down
  end
end
