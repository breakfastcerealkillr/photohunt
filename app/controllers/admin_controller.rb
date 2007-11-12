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
        redirect_to(:action => 'index')
      end
    end
  end
  
end
