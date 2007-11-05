package edu.hawaii.photohunt.webapp.beans;

import org.ajax4jsf.dnd.Dropzone;
import org.ajax4jsf.dnd.event.DropEvent;
import org.ajax4jsf.dnd.event.DropListener;

import edu.hawaii.photohunt.webapp.support.PictureFile;

/**
 * The EventBean class handles the drag and drop functionality of the Approval process.
 * 
 * @author George Lee
 *
 */
public class EventBean implements DropListener {
  
  /**The ApprovalBean for this class.*/
  protected ApprovalBean approvalBean;

  /**
   * Process the dropped picture by moving it to the appropriate list.
   * 
   * @param event The event that is sent when an item is dropped.
   */
  public void processDrop(DropEvent event) {
    Dropzone dropzone = (Dropzone) event.getComponent();
    PictureFile file = (PictureFile) event.getDragValue();
    String destination = dropzone.getDropValue().toString();
    this.approvalBean.movePicture(file, destination);
  }

  /**
   * Get the approval bean.
   * 
   * @return The approval bean assigned to this EventBean.
   */
  public ApprovalBean getApprovalBean() {
    return this.approvalBean;
  }

  /**
   * Set the approval bean.
   * 
   * @param bean The approval bean to process drops for.
   */
  public void setApprovalBean(ApprovalBean bean) {
    this.approvalBean = bean;
  }
}
