# Primary Actor #
  * Reviewer

# Preconditions #
  * Reviewer has a valid username and password to login to the web application.

# Postconditions #
  * An existing Photo Hunt game has been edited.

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
  1. Reviewer clicks on the name of the Photo Hunt game to be edited.
  1. System displays a form with existing game information.
  1. Reviewer edits the name data of the game.
  1. Repeat step 11 until desired game information has been changed.
  1. Reviewer clicks on "Save game".
  1. System saves the game.
  1. System returns to the "Manage Photo Hunt games" page.

# Alternate Flows #
  * 6a. System fails to authenticate the user.
    1. The system redirects the browser back to the login page.

  * 11a. Reviewer edits the keyword of a game item.
    1. The system changes the keyword data successfully.

  * 11b. Reviewer edits the description of a game item.
    1. The system changes the description data successfully.

  * 11c. Reviewer adds a game item keyword and description.
    1. The system adds the new game item successfully.

  * 11d. Reviewer removes a game item.
    1. The system removes the game item successfully.

# Special Requirements #
  * None

# Frequency of Occurrence #
  * Often, especially when typos are found in a game listing, or a game needs to be revised.

# Open Issues #
  * May be best to use something like AJAX for this simple form data?