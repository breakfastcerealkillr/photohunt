# Introduction #

This guide details the steps needed to install Photo Hunt.


# Web Application #
> ## Java setup ##
    * Download and install the Java Runtime Environment (JRE 5) from [Sun's website](http://java.sun.com/javase/downloads/index.jsp).
    * Set the JAVA\_HOME environment variable to point to your Java installation (for example, c:\java\jdk1.5.0\_08).
    * Add JAVA\_HOME/bin to your PATH variable.
> ## Download and install Apache Tomcat 5.5.20 ##
    * Download the core installation of Apache Tomcat 5.5.20 (apache-tomcat-5.5.20.zip) from [here](http://tomcat.apache.org/download-55.cgi). DO NOT download the "windows installer .exe" version, download the zip version instead.
    * Unzip the file to a directory, preferably the same directory as your Java installation.
    * Set the CATALINA\_HOME environment variable to point to your Tomcat installation (why "Catalina"?  Beats me. But that's what it should be named).
    * Add CATALINA\_HOME/bin to your PATH variable.
> ## Start up Tomcat by invoking the start up command. ##
    * Windows users: Go to Start -> Run.  Type "cmd" and press enter.  At the prompt, type "startup".
> ## Download the latest build of Photo Hunt. ##
![http://photohunt.googlecode.com/svn/trunk/screenshots/photohunt-downloads.png](http://photohunt.googlecode.com/svn/trunk/screenshots/photohunt-downloads.png)
    * Go to the [Photo Hunt](http://code.google.com/p/photohunt/) web page.
    * Click on the "Downloads" tab.
    * Download the latest Photo Hunt binary by clicking on the line.  You may download the source code if you intend to build it using Ant.
    * Unzip the downloaded file.
> ## Deploy the war file to Tomcat. ##
![http://photohunt.googlecode.com/svn/trunk/screenshots/tomcat-manager.png](http://photohunt.googlecode.com/svn/trunk/screenshots/tomcat-manager.png)
    * Visit http://localhost:8080 and click on the Manager link in the top left corner.
    * Input the user name and password found in tomcat-users.xml.
    * Look for the section labeled "Deploy directory or WAR file located on server".
    * For the XML configuration file, click on browse and navigate to <Photo Hunt>/war/WEB-INF/web.xml, where <Photo Hunt> is the location of the unzipped binary download.
    * For the War or directory URL, click on browse and select <Photo Hunt>/war.
    * Click on "Deploy".





