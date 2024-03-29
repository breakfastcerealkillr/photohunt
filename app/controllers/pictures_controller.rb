class PicturesController < ApplicationController
  layout "user"
  
  def index
    redirect_to(:action => "list")
  end
  
  def list
    @all_pictures = Picture.find(:all, :conditions => "status='APPROVED'")
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
  
  def rate
    picture = Picture.find(params[:id])
    picture.score += 1
    picture.save
    flash[:notice] = "Score updated!"
    redirect_to(:action => 'list')
  end
end
