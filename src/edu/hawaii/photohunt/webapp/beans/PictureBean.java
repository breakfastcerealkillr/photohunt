package edu.hawaii.photohunt.webapp.beans;

import java.util.List;

import javax.faces.model.SelectItem;
import edu.hawaii.photohunt.webapp.model.PictureFile;
import edu.hawaii.photohunt.webapp.model.PictureModel;

/**
 * The PictureBean class is the bean that backs the display of approved pictures in the webapp.
 * 
 * @author George Lee
 * 
 */
public class PictureBean {

  // /** The context of the web application. */
  // private final ServletContext servletContext = (ServletContext)
  //   FacesContext.getCurrentInstance().getExternalContext().getContext();

  ///** The path to the approved pictures directory. */
  //private String directoryPath = "pictures/approved/";

  /** The current tag directory being browsed. */
  private String currentTag = "";

  /** The model supporting this backing bean. */
  private final PictureModel model = new PictureModel();

  /** The list of approved pictures. */
  private final List<PictureFile> pictures = this.model.getPictures();

  /**
   * Constructor for PictureBean class.
   */
  public PictureBean() {
    //Needs to be left empty.
  }

  /**
   * Get the list of available tags.
   * 
   * @return The list of tags available.
   */
  public List<SelectItem> getTagList() {
    return this.model.getTagList();
  }

  /**
   * Get the list of approved pictures.
   * 
   * @return The list of approved pictures.
   */
  public List<PictureFile> getApprovedPictures() {
    return this.pictures;
  }

  /**
   * Change the current tag directory.
   * 
   * @param directory The tag directory to view.
   * @return Returns null to refresh the current page.
   */
  public String changeTag(String directory) {
    this.currentTag = directory;

    //Forces refresh of current page.
    return null;
  }

  /**
   * Get the current tag.
   * 
   * @return The tag currently being browsed.
   */
  public String getCurrentTag() {
    return this.currentTag;
  }

  /**
   * Set the current tag.
   * 
   * @param tag The tag to view.
   */
  public void setCurrentTag(String tag) {
    this.currentTag = tag;
  }
}
