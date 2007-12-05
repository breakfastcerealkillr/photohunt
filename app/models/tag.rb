class Tag < ActiveRecord::Base
  
  validates_presence_of :short_description
  
end
