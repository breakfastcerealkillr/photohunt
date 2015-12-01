# Primary Actor #
  * Reviewer

# Preconditions #
  * Reviewer has a valid username and password to login to the web application.

# Postconditions #
  * A new Photo Hunt game has been created.

# Basic Flow #
  1. Reviewer visits the Photo Hunt web application using their browser.
  1. System displays the welcome page.
  1. Reviewer clicks on the "Employees" link.
  1. System goes to the login screen.
  1. Reviewer enters their username and password.
  1. System authenticates the user.
![http://photohunt.googlecode.com/svn/trunk/use-cases/UC3_PictureReview_img1.jpg](http://photohunt.googlecode.com/svn/trunk/use-cases/UC3_PictureReview_img1.jpg)
  1. Reviewer clicks on "Manage Photo Hunt games"
  1. System displays a listing of current Photo Hunt games available
  1. Reviewer clicks on "Create new Photo Hunt game"
  1. System displays a form to enter in new game information.
  1. Reviewer enters in the name for the new Photo Hunt game.
  1. Reviewer enters in a description and keyword for a game item.
  1. Repeat steps 11-12 until all game items have been entered.
  1. Reviewer clicks on "Save game".
  1. System saves the game.
  1. System returns to the "Manage Photo Hunt games" page.

# Alternate Flows #
  * 6a. System fails to authenticate the user.
    1. The system redirects the browser back to the login page.
  * 14a. System reports null game name data.
  1. The system displays a warning to not leave the game name blank.
    * 14b. System reports empty game keyword data.
  1. The system displays a warning to not leave the game keyword blank.
    * 14c. System reports null game description data.
  1. The system displays a warning to not leave the game description blank.

# Special Requirements #
  * None

# Frequency of Occurrence #
  * When a new exhibit goes on display

# Open Issues #
  * May be best to use something like AJAX for this simple form data?