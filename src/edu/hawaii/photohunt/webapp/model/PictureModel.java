package edu.hawaii.photohunt.webapp.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * The PictureModel class performs the operations needed for the picture review process in Photo
 * Hunt. Supports only .jpg and .gif file types for now.
 * 
 * @author George Lee
 * 
 */
public class PictureModel {

  /** The context of the web application. */
  private final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
      .getExternalContext().getContext();
  
  /** The relative directory location of the approved pictures. */
  private final String approvedDirectory;

  /** The list of pictures to be viewed. */
  protected List<PictureFile> pictures = new ArrayList<PictureFile>();

  /** The list of tags currently available in Photo Hunt. */
  private final List<SelectItem> tagList = new ArrayList<SelectItem>();
   
  /**
   * Create a new PictureModel instance. Takes the pictures from the approved directory and places
   * them into a list. Uses the default values.
   */
  public PictureModel() {
    this.approvedDirectory = ApprovalModel.DEFAULT_APPROVED;

    File pendingDir = new File(servletContext.getRealPath(this.approvedDirectory));

    // Assume that default directories work correctly.

    // Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    for (File inFile : Arrays.asList(pendingDir.listFiles(pictureFilter))) {
      this.pictures.add(new PictureFile(this.approvedDirectory, inFile));
    }
    
    //Populate the tag list.
    tagList.add(new SelectItem("sample-pictures", "Sample Pictures"));
  }

  /**
   * Gets the list of pictures to be viewed.
   * 
   * @return The list of pictures to view.
   */
  public List<PictureFile> getPictures() {
    return this.pictures;
  }

  /**
   * Gets the directory of the pictures.
   * 
   * @return The path to the directory containing the pictures.
   */
  public String getApprovedDirectory() {
    return this.approvedDirectory;
  }
  
  /**
   * Get the list of available tags.
   * 
   * @return The list of tags available.
   */
  public List<SelectItem> getTagList() {
    return this.tagList;
  }
}
