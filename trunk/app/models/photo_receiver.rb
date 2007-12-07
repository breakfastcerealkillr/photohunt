class PhotoReceiver < ActionMailer::Base
    # email is a TMail::Mail
    def receive(email)
      #email.attachments are TMail::Attachment
      #but they ignore a text/mail parts.
      email.parts.each_with_index do |part, index|
        if part.content_type =~ /^image/
          @picture = Picture.new(
            :user_email => email.from,
            :tag => email.subject,
            :content_type => part.content_type.chomp,
            :data => part.body,
            :status => 'PENDING',
            :date => Date.today
          )
          @picture.save
        #Else, check for HTML formatted email.
        elsif part.content_type =~ /text\/html/
        end
      end
    end
  end
