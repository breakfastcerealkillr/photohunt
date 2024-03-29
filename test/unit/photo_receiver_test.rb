require File.dirname(__FILE__) + '/../test_helper'
require 'photo_receiver'

class PhotoReceiverTest < Test::Unit::TestCase
  FIXTURES_PATH = File.dirname(__FILE__) + '/../fixtures'
  CHARSET = "utf-8"

  include ActionMailer::Quoting

  def setup
    ActionMailer::Base.delivery_method = :test
    ActionMailer::Base.perform_deliveries = true
    ActionMailer::Base.deliveries = []

    @expected = TMail::Mail.new
    @expected.set_content_type "text", "plain", { "charset" => CHARSET }
    @expected.mime_version = '1.0'
  end

  def test_photo_receiver
    puts "Testing message with attachment."
    email_text = read_fixture('hello-world.mail').join
    PhotoReceiver.receive(email_text)
    puts "Testing Sprint Picture Mail."
    email_text2 = read_fixture('sprint_picturemail.mail').join
    PhotoReceiver.receive(email_text2)
  end
  
  private
    def read_fixture(action)
      IO.readlines("#{FIXTURES_PATH}/photo_receiver/#{action}")
    end

    def encode(subject)
      quoted_printable(subject, CHARSET)
    end
end
