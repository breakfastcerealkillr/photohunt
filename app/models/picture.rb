class Picture < ActiveRecord::Base
  
  validates_format_of :content_type,
    :with => /^image/,
    :message => " -- you can only upload pictures."
    
  def uploaded_picture=(picture_field)
    self.content_type = picture_field.content_type.chomp
    self.data = picture_field.read
  end
    
end
