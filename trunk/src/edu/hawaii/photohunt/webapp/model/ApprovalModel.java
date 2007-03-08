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
  public static final String DEFAULT_PENDING = "sample-pictures/";

  /**Default directory for approved pictures.*/
  public static final String DEFAULT_APPROVED = "sample-pictures/approved/";

  /**Directory of the pictures pending approval.*/
  private final String pendingDirectory;

  /**Directory of the approved pictures.*/
  private final String approvedDirectory;

  /** List of the filenames for the pictures. */
  protected ArrayList<File> pendingPictures;

  /** List of the approved pictures. */
  protected ArrayList<File> approvedPictures;

  /**
   * Create a new ApprovalModel instance. Retrieves the files from the pictures folder and the
   * approved folder and puts them into a list.  Uses the default values.
   * @throws PictureFileException 
   */
  public ApprovalModel() {
    this.pendingDirectory = DEFAULT_PENDING;
    this.approvedDirectory = DEFAULT_APPROVED;

    File pendingDir = new File(this.pendingDirectory);
    File approvedDir = new File(this.approvedDirectory);

    //Assume that default directories work correctly.

    //Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    this.pendingPictures = new ArrayList<File>(Arrays.asList(pendingDir.listFiles(pictureFilter)));
    this.approvedPictures = 
      new ArrayList<File>(Arrays.asList(approvedDir.listFiles(pictureFilter)));
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
    this.pendingPictures = new ArrayList<File>(Arrays.asList(pendingDir.listFiles(pictureFilter)));
    this.approvedPictures = 
      new ArrayList<File>(Arrays.asList(approvedDir.listFiles(pictureFilter)));
  }

  /**
   * Get the list of approved pictures.
   * 
   * @return The approved picture files.
   */
  public List<File> getApproved() {
    return this.approvedPictures;
  }

  /**
   * Get the list of pending pictures.
   * 
   * @return The pending picture files.
   */
  public List<File> getPending() {
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

  /**
   * Add picture to the list of approved pictures.
   * 
   * @param filename The file path of the picture to be approved.
   */
  public void approvePicture(File filename) {
    //Files need to be moved.
    this.approvedPictures.add(filename);
  }

  /**
   * Deny picture and remove it from the list of available pictures and delete it from the disk.
   * 
   * @param filename The file path of the picture to remove.
   */
  public void denyPicture(File filename) {
    //To be implemented later.
  }
}
