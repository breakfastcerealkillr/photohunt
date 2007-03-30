package edu.hawaii.photohunt.webapp.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import edu.hawaii.photohunt.webapp.model.PictureFile;
import edu.hawaii.photohunt.webapp.model.PictureFileFilter;

/**
 * The PictureBean class is the bean that backs the display of approved pictures in the webapp.
 * 
 * @author George Lee
 * 
 */
public class PictureBean {

   /** The context of the web application. */
   private final ServletContext servletContext = (ServletContext)
     FacesContext.getCurrentInstance().getExternalContext().getContext();

  /** The current tag directory being browsed. */
  private String tag = "";

  /** The list of approved pictures. */
  private final List<PictureFile> pictures = new ArrayList<PictureFile>();

  /**
   * Constructor for PictureBean class.
   */
  public PictureBean() {
    //Needs to be left empty.
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
   * Get the current tag.
   * 
   * @return The tag currently being browsed.
   */
  public String getTag() {
    return this.tag;
  }

  /**
   * Set the current tag.
   * 
   * @param tag The tag to view.
   */
  public void setTag(String tag) {
    this.tag = tag;
  }
  
  /**
   * Update the set of pictures.
   * 
   * @return Returns "refresh" to refresh the current page.
   */
  public String update() {
    //Updated by the dropdown menu
    File pendingDir = new File(servletContext.getRealPath(this.tag));

    // Insert the file names into the lists.
    PictureFileFilter pictureFilter = new PictureFileFilter();
    for (File inFile : Arrays.asList(pendingDir.listFiles(pictureFilter))) {
      this.pictures.add(new PictureFile(this.tag, inFile));
    }
    
    return "refresh";
  }
}
