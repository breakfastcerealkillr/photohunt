class LoginController < ApplicationController

  layout "user"
  def index
    redirect_to(:action => "login")
  end
  
  def add_user
    @user = User.new(params[:user])
    if request.post? and @user.save
      flash.now[:notice] = "User #{@user.name} created."
      @user = User.new
      redirect_to({:action => "login"})
    end
  end
  
  def login
    session[:user_id] = nil
    if request.post?
      user = User.authenticate(params[:name], params[:password])
      if user
        session[:user_id] = user.id
        uri = session[:original_uri]
        session[:original_uri] = nil
        redirect_to(uri || { :action => "login" })
      else
        flash[:notice] = "Invalid user/password combination"
      end
    end
  end
  
  def logout
    session[:user_id] = nil
    flash[:notice] = "Logged out"
    redirect_to(:action => "login")
  end
  
end
