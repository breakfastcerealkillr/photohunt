package edu.hawaii.photohunt.webapp.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The PictureModel class performs the operations needed for the picture review process in Photo
 * Hunt.  Supports only .jpg and .gif file types for now.
 * 
 * @author George Lee
 * 
 */
public class ApprovalModel {
  /**Default directory for pictures pending approval.*/
  public static final String DEFAULT_PENDING = "pictures/pending/sample-pictures/";

  /**Default directory for approved pictures.*/
  public static final String DEFAULT_APPROVED = "pictures/sample-pictures/approved/";

  /**Directory of the pictures pending approval.*/
  private final String pendingDirectory;

  /**Directory of the approved pictures.*/
  private final String approvedDirectory;

  /** List of the filenames for the pictures. */
  protected ArrayList<PictureFile> pendingPictures = new ArrayList<PictureFile>();

  /**
   * Create a new ApprovalModel instance. Retrieves the files from the pictures folder and the
   * approved folder and puts them into a list.  Uses the default values.
   */
  public ApprovalModel() {
    this.pendingDirectory = DEFAULT_PENDING;
    this.approvedDirectory = DEFAULT_APPROVED;

    File pendingDir = new File(this.pendingDirectory);

    //Assume that default directories work correctly.

    //Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    for (File inFile : Arrays.asList(pendingDir.listFiles(pictureFilter))) {
      this.pendingPictures.add(new PictureFile(this.pendingDirectory, inFile));
    }
  }

  /**
   * Create a new ApprovalModel instance. Retrieves the files from the pictures folder and the
   * approved folder and puts them into a list.
   * 
   * @param pending The file path to the directory containing the pictures that are pending
   *        approval.
   * @param approved The file path to the directory containing the approved pictures.
   * @throws PictureFileException if there is an error opening the directory.
   */
  public ApprovalModel(String pending, String approved) throws PictureFileException {
    this.pendingDirectory = pending;
    this.approvedDirectory = approved;

    File pendingDir = new File(this.pendingDirectory);
    File approvedDir = new File(this.approvedDirectory);

    //If the file paths are not directories, throw exception.
    if ((!pendingDir.isDirectory()) || (!approvedDir.isDirectory())) {
      throw new PictureFileException("The file path does not point to a directory.");
    }

    //Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    for (File inFile : Arrays.asList(pendingDir.listFiles(pictureFilter))) {
      this.pendingPictures.add(new PictureFile(this.pendingDirectory, inFile));
    }
  }

  /**
   * Get the list of pending pictures.
   * 
   * @return The pending picture files.
   */
  public List<PictureFile> getPending() {
    return this.pendingPictures;
  }

  /**
   * Get the directory of the approved files.
   * 
   * @return The file path to the approved pictures.
   */
  public String getApprovedDirectory() {
    return this.approvedDirectory;
  }

  /**
   * Get the directory of the pending files.
   * 
   * @return The file path to the approved pictures.
   */
  public String getPendingDirectory() {
    return this.pendingDirectory;
  }
}
