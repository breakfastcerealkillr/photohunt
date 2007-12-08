require "rexml/document"
require "open-uri"

class PhotoReceiver < ActionMailer::Base
    # email is a TMail::Mail
    def receive(email)
      puts email.from[0]
      # Iterate through parts of the email.
      email.parts.each_with_index do |part, index|
        if part.content_type =~ /^image/
          @picture = Picture.new(
            :user_email => email.from[0],
            :tag => email.subject,
            :content_type => part.content_type.chomp,
            :data => part.body,
            :status => 'PENDING',
            :date => Date.today
          )
         
        elsif part.content_type =~ /text\/html/
          # Check for Sprint Picture Mail.
          if email.from[0] =~ /@pm.sprint.com\Z/ 
            picture_uri = parse_sprint(part.body)
            open(picture_uri) do |p|
              @picture = Picture.new(
                :user_email => email.from[0],
                :tag => email.subject,
                :content_type => p.content_type.chomp,
                :data => p.read,
                :status => 'PENDING',
                :date => Date.today
              )
            end
          end
        end
        
      end
      
      if @picture.save
        # Create reply email.
      else
        raise "Could not save picture."
      end
    end
    
    private
    
    # Sprint Picture Mail picture URL pattern.  Matches "pictures.sprintpcs.com//".
    SPRINT_URL_PATTERN = /pictures.sprintpcs.com\/\//
    
    # Parse through Sprint Picture Mail and return the URI to the picture.
    def parse_sprint(message)
      doc = REXML::Document.new(message)
      doc.elements.each("//img") do |e|
        if e.attribute("src").to_s() =~ SPRINT_URL_PATTERN
          return e.attribute("src").to_s()
        end
      end
      
      return nil
    end
    
  end
