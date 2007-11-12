class PicturesController < ApplicationController
  layout "user"
  
  def index
    redirect_to(:action => "list")
  end
  
  def list
    @all_pictures = Picture.find(:all, :conditions => "status='APPROVED'")
  end
  
  def upload
    @picture = Picture.new
  end
  
  def save
    @picture = Picture.new(params[:picture])
    @picture.status = "PENDING"
    if @picture.save
      flash[:notice] = "Your picture has been submitted."
      redirect_to(:action => 'list')
    else
      render(:action => :upload)
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
