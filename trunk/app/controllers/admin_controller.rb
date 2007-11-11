class AdminController < ApplicationController
  layout "admin"
  
  before_filter :authorize
  
  def approve
    @all_pending = Picture.find(:all, :conditions => "status = 'PENDING'")
    if request.post?
      Picture.update(params[:picture].keys, params[:picture].values)
      redirect_to(:action => 'approve')
    end
  end
  
end
