package edu.hawaii.photohunt.mail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

//import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

/**
 * A simple email receiver class.
 * 
 * Notes: Received help from the following source,
 * http://www.javaworld.com/jw-10-2001/jw-1026-javamail.html .
 * 
 * @author Elayne Man
 * 
 */

public class Receiver {
  /*  @param popServer    The internet address of the POP3 server
  *   @param popUser      The username of the POP3 user
  *   @param popPassword  The password of the POP3 user
  */
  private static String popServer = "pop3.1net.gr";
  private static String popUser = "bishopmuseum";
  private static String popPassword = "bishop";
  
  /*
   * Execute method to receive messages from the mail server.
   *
  public void execute() {

    receive(popServer, popUser, popPassword);
    System.exit(0);
  }*/

  /**
   * The receive method that fetches messages and processes them.
   * 
   * @return true if successful
   * 
   */
  public boolean receive() {
    Store store = null;
    Folder folder = null;
    boolean success = false;
    try {
      
      // Get default session
      Properties props = System.getProperties();
      Session session = Session.getDefaultInstance(props, null);
      
      // Get POP3 message store, and connect to it
      store = session.getStore("pop3");
      store.connect(popServer, popUser, popPassword);

      // Get the default folder
      folder = store.getDefaultFolder();
      if (folder == null) {
        throw new Exception("No default folder");
      }
        
      // Get the INBOX
      folder = folder.getFolder("INBOX");
      if (folder == null) {
        throw new Exception("No POP3 INBOX");
      }
      
      // Open the folder for read only
      // Consider changing this to write access to
      // mark messages as read or unread
      folder.open(Folder.READ_ONLY);
      
      
      // Get the message wrappers and process them
      Message[] msgs = folder.getMessages();
      for (int msgNum = 0; msgNum < msgs.length; msgNum++) {
        printMessage(msgs[msgNum]);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    finally {
      
      // Close folders
      try {
        if (folder != null) {
          folder.close(false);
        }
        
        if (store != null) {
          store.close();
        }
          
        success = true;
      }
      catch (Exception ex2) {
        ex2.printStackTrace();
      }
    }
    
    return success;
  }

  /**
   * "printMessage()" method to print a message.
   * @param message The message to be printed.
   */
  public void printMessage(Message message) {
    try {
      // Get the header information
      String from = ((InternetAddress) message.getFrom()[0]).getPersonal();
      
      if (from == null) {
        from = ((InternetAddress) message.getFrom()[0]).getAddress();
      }
      
      System.out.println("FROM: " + from);
      String subject = message.getSubject();
      System.out.println("SUBJECT: " + subject);
      
      // Get the message part (i.e. the message itself)
      Part messagePart = message;
      Object content = messagePart.getContent();
      
      // or its first body part if it is a multipart message
      if (content instanceof Multipart) {
        messagePart = ((Multipart) content).getBodyPart(0);
        System.out.println("[ Multipart Message ]");
      }
      
      // Get the content type
      String contentType = messagePart.getContentType();
      
      // If the content is plain text, we can print it
      System.out.println("CONTENT:" + contentType);
      if (contentType.startsWith("text/plain") || contentType.startsWith("text/html")) {
        InputStream is = messagePart.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String thisLine = reader.readLine();
        while (thisLine != null) {
          System.out.println(thisLine);
          thisLine = reader.readLine();
        }
        //Close reader.
        reader.close();
      }
      System.out.println("-----------------------------");
      
      //Uncomment the following line when folders has write access
      //message.setFlag(Flags.Flag.ANSWERED,true);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
