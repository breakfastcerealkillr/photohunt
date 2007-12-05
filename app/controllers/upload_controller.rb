class UploadController < ApplicationController
  
  layout "user"
  
  def index
    redirect_to(:action => 'upload')
  end
  
  def upload
    @picture = Picture.new
    @tags = [['Select a tag', nil]]
    taglist = Tag.find(:all, :select=>"short_description")
    for tag in taglist
      @tags << tag.short_description
    end
  end
  
  def save
    @picture = Picture.new(params[:picture]) do |p|
      p.status = "PENDING"
      p.score = 0
      p.date = Date.today
    end
    if @picture.save
      redirect_to(:controller => 'pictures', :action => 'list')
      flash[:notice] = "Your picture has been submitted and is pending approval."
    else
      render(:action => :upload)
    end
  end
end
