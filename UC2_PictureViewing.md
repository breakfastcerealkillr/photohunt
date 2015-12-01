# Primary Actor #
  * Visitor

# Preconditions #
  * Visitor knows the address of the web application.

# Postconditions #
  * Visitor can browse through the approved pictures.

# Basic Flow #
  1. Visitor uses their web browser to visit the Photohunt web application.
  1. System displays the welcome page.
  1. Visitor clicks on the "Visitor" link.
![http://photohunt.googlecode.com/svn/trunk/use-cases/UC2_PictureViewing_img1.jpg](http://photohunt.googlecode.com/svn/trunk/use-cases/UC2_PictureViewing_img1.jpg)
![http://photohunt.googlecode.com/svn/trunk/use-cases/UC2_PictureViewing_img2.jpg](http://photohunt.googlecode.com/svn/trunk/use-cases/UC2_PictureViewing_img2.jpg)
  1. System displays the available categories.
  1. Visitor selects a picture category.
![http://photohunt.googlecode.com/svn/trunk/use-cases/UC2_PictureViewing_img3.jpg](http://photohunt.googlecode.com/svn/trunk/use-cases/UC2_PictureViewing_img3.jpg)
  1. System displays a picture from the selected category.
  1. Visitor clicks on "next" to view another picture.
  1. System displays another picture from the selected category.
  1. Repeat steps 7-8 until there are no pictures left.
  1. System reports that there are no more pictures to display.

# Alternate Flows #
  * 6a. There are no pictures in the category.
    1. System reports that there are no pictures in the category.
  * 7a. Visitor chooses to view previous picture by clicking on the "previous" link.
    1. System displays the previously shown picture.
  * 7b. Visitor selects a different category.
    1. System displays a picture from the new category.

# Special Requirements #
  * None

# Frequency of Occurrence #
  * Very often.

# Open Issues #
  * Will Javascript be required?

