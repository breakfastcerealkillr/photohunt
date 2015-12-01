# Primary Actor #
  * Reviewer

# Preconditions #
  * Reviewer has a valid username and password to login to the web application.

# Postconditions #
  * Reviewer's account settings have been changed.

# Basic Flow #

  1. Reviewer visits the Photo Hunt web application using their browser.
  1. System displays the welcome page.
  1. Reviewer clicks on the "Employees" link.
  1. System goes to the login screen.
  1. Reviewer enters their username and password.
  1. System authenticates the user.
  1. ![http://photohunt.googlecode.com/svn/trunk/use-cases/UC3_PictureReview_img1.jpg](http://photohunt.googlecode.com/svn/trunk/use-cases/UC3_PictureReview_img1.jpg) Reviewer clicks on "Account Settings".
  1. System displays account settings.
  1. Reviewer enters existing password.
  1. Reviewer enters new password.
  1. Reviewer enters new password for confirmation.
  1. Reviewer saves new account settings.
  1. System saves the new account settings.
  1. System returns to the main staff page.

# Alternate Flows #
  * 6a. System fails to authenticate the user.
    1. The system redirects the browser back to the login page.

  * 9a. Reviewer entered the wrong existing password.
    1. The system displays a warning.

  * 9b. Reviewer's new password differs from confirmation password.
    1. The system displays a warning.

# Special Requirements #
  * None

# Frequency of Occurrence #
  * Depending on company policy of password frequency

# Open Issues #
  * May be best to use something like AJAX for this simple form data?
