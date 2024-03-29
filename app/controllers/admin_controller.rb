class AdminController < ApplicationController
  layout "admin"
  
  before_filter :authorize
  
  def approve
    @all_pending = Picture.find(:all, :conditions => "status = 'PENDING'")
    if request.post?
      Picture.update(params[:picture].keys, params[:picture].values)
      redirect_to(:action => 'approve')
    else
      if @all_pending.empty?
        flash[:notice] = "There are no pictures pending approval."
        redirect_to(:action => 'error')
      end
    end
  end
  
  def manage
    @all_pictures = Picture.find(:all, :conditions => "status = 'APPROVED'")
    if request.post?
      Picture.update(params[:picture].keys, params[:picture].values)
      flash[:notice] = "Updated picture list."
      redirect_to(:action => 'manage')
    else
      if @all_pictures.empty?
        flash[:notice] = "There are no approved pictures."
        redirect_to(:action => 'error')
      end
    end
  end
  
  def create_tag
    @tag = Tag.new(params[:tag])
    if request.post? and @tag.save
      flash[:notice] = "Tag successfully created."
      redirect_to(:action => 'index')
    end
  end
end
