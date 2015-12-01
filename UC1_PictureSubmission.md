# Primary Actor #
  * Visitor

# Preconditions #
  * Visitor has a picture ready to send.
  * Visitor has the email address of the Photohunt server.
  * Mail server for Photohunt is up and running.

# Postconditions #
  * Visitor's picture will be available for the photo review process.
  * System will send a reply to the visitor confirming their submission.

# Basic Flow #

  1. Visitor sends an email to the Photohunt server with a tag in the subject line.
  1. System receives the email.
  1. System extracts the picture and sorts it according to their tag.
  1. System sends a response to the visitor confirming their submission.

# Alternate Paths #

  * 3a. System either fails to extract the picture.
    1. System sends a response to the visitor describing the error.
  * 3b. System does not recognize the tag.
    1. System sends a response to the visitor describing the error.

# Special Requirements #
  * None

# Frequency of Occurrence #
  * Very often.

# Open Issues #
  * Will email registration and validation be required?