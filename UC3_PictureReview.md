# Primary Actor #
  * Reviewer

# Preconditions #
  * Reviewer has a valid username and password to login to the web application.
  * Pictures have been received by the server and are ready for review.

# Postconditions #
  * The pictures are approved and ready to be shown on the web application.

# Basic Flow #
  1. Reviewer visits the Photo Hunt web application using their browser.
  1. System displays the welcome page.
  1. Reviewer clicks on the "Employees" link.
  1. System goes to the login screen.
  1. Reviewer enters their username and password.
  1. System authenticates the user.
![http://photohunt.googlecode.com/svn/trunk/use-cases/UC3_PictureReview_img1.jpg](http://photohunt.googlecode.com/svn/trunk/use-cases/UC3_PictureReview_img1.jpg)
  1. System displays a list of picture categories.
  1. Reviewer selects a picture category.
  1. System displays a unapproved picture from the selected category.
  1. Reviewer clicks on approve.
  1. System moves the picture to a list of pictures that were approved.
  1. System displays the next unapproved picture.
  1. Repeat steps 10-13 until no more pictures are available.
  1. System reports that there are no pictures left in the category.

# Alternate Flows #
  * 6a. System fails to authenticate the user.
    1. The system redirects the browser back to the login page.
  * 9a. There are no unapproved pictures.
    1. The system reports that there are no pictures in the category.
  * 10a. The reviewer selects deny.
    1. The system removes the picture from the list of unapproved pictures.
    1. The system displays the next unapproved picture (step 12).
  * 10b. The reviewer selects skip
    1. The system displays the next unapproved picture (step 12).

# Special Requirements #
  * None

# Frequency of Occurrence #
  * Very often.

# Open Issues #
  * Will Javascript be required?