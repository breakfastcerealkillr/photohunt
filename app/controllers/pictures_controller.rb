class PicturesController < ApplicationController
  def index
    redirect_to(:action => "list")
  end
  
  def list
    @all_pictures = Picture.find(:all)
  end
  
  def upload
    @picture = Picture.new
  end
  
  def save
    @picture = Picture.new(params[:picture])
    if @picture.save
      redirect_to(:action => 'list')
    else
      render(:action => :get)
    end
  end
  
  def picture
    @picture = Picture.find(params[:id])
    send_data(@picture.data,
      :filename => 'temp',
      :type => @picture.content_type,
      :disposition => "inline")
  end
  
  def show
    @picture = Picture.find(params[:id])
  end
end
