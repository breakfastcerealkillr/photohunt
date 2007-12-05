class Picture < ActiveRecord::Base
  
  validates_presence_of :tag, :user_email
  
  validates_format_of     :user_email,
                          :with       => /^([^@\s]+)@((?:[-a-z0-9]+\.)+[a-z]{2,})$/i,
                          :message    => ' must be valid'
                          
  validates_format_of :content_type,
    :with => /^image/,
    :message => " -- you can only upload pictures."
    
  def uploaded_picture=(picture_field)
    if (picture_field != "")
      self.content_type = picture_field.content_type.chomp
      self.data = picture_field.read
    end
  end
    
end
