class Notifier < ActionMailer::Base
  
  def received_picture(email)
    recipients email
    from "photohunt07@gmail.com"
    subject "Your picture has been received!"
  end
  
end
