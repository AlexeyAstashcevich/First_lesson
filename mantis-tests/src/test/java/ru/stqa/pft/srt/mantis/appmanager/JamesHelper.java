package ru.stqa.pft.srt.mantis.appmanager;

import org.apache.commons.net.telnet.TelnetClient;
import ru.stqa.pft.srt.mantis.model.MailMessage;

import javax.mail.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JamesHelper {
  private  ApplicationManager app;
  private TelnetClient telnet;
  private InputStream in;
  private PrintStream out;

  private Session mailSession;
  private Store store;
  private String mailServer;

  public JamesHelper(ApplicationManager app){
    this.app = app;
    telnet = new TelnetClient();
    mailSession = Session.getDefaultInstance(System.getProperties());
  }

  public boolean doesUserExist(String name){
    initTelnetSession();
    write("verify " + name);
    String result = readUntil("exist");
    closeTelnetSession();
    return result.trim().equals("User " + name + " exist");
  }

  public void createUser(String username, String password) {
    initTelnetSession();
    write("adduser "+ username + " " + password);
    String result = readUntil("User " + username + " added");
    closeTelnetSession();
  }

  public void deleteUser(String name){
    initTelnetSession();
    write("delete "+ name);
    String result = readUntil("User " + name + " deleted");
    closeTelnetSession();
  }
  private void initTelnetSession(){
    mailServer = app.getProperty("mailServer.host");
    int port = Integer.parseInt(app.getProperty("mailServer.port"));
    String login = app.getProperty("mailServer.adminlogin");
    String password = app.getProperty("mailsServer.password");

    try {
      telnet.connect(mailServer,port);
      in = telnet.getInputStream();
      out = new PrintStream(telnet.getOutputStream());

    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    readUntil("Login id:");
    write(login);
    readUntil("Password:");
    write(password);

//    readUntil("Login id:");
//    write(login);
//    readUntil("Password:");
//    write(password);

    readUntil ("Welcome "+ login + ". HELP for a list of commands");
  }

  private String readUntil(String pattern){
    try{
      char lastChar = pattern.charAt(pattern.length()-1);
      StringBuffer sb = new StringBuffer();
      char ch =(char) in.read();
      while (true){
        System.out.println(ch);
        sb.append(ch);
        if(ch == lastChar){
          if(sb.toString().endsWith(pattern)){
            return sb.toString();
          }
        }
        ch=(char) in.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void write(String value){
    try {
      out.println(value);
      out.flush();
      System.out.println(value);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private  void closeTelnetSession(){
    write("quit");
  }

  public void drainEmail(String username, String password) throws MessagingException {
    Folder inbox =  openInbox(username, password);
    for (Message message: inbox.getMessages()) {
      message.setFlag(Flags.Flag.DELETED,true);
    }
    closeFolder(inbox);
  }

  private  void closeFolder(Folder folder) throws MessagingException {
    folder.close(true);
    store.close();
  }

  public List<MailMessage> waitForMail(String username, String password, long timeout) throws MessagingException {
    long now = System.currentTimeMillis();
    while (System.currentTimeMillis()< now + timeout){
      List<MailMessage> allMail = getAllMail(username, password);
      if (allMail.size() >0){
        return allMail;
      }
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    throw new Error ("No mail :(");
  }

  public List<MailMessage> getAllMail (String username, String password) throws MessagingException {
    Folder inbox= openInbox(username,password);
    List<MailMessage> messages= Arrays.asList(inbox.getMessages()).stream().map(m->toModeMail(m)).collect(Collectors.toList());
    closeFolder(inbox);
    return messages;
  }

  public MailMessage toModeMail(Message m)  {
    try {
      return new MailMessage(m.getAllRecipients()[0].toString(),(String) m.getContent());
    } catch (MessagingException e) {
      e.printStackTrace();
      return  null;
    } catch (IOException e) {
      e.printStackTrace();
      return  null;
    }
  }

  private Folder openInbox (String username, String password) throws MessagingException {
    store = mailSession.getStore("pop3");
    store.connect(mailServer,username,password);
    Folder folder = store.getDefaultFolder().getFolder("INBOX");
    folder.open(Folder.READ_WRITE);
    return folder;
  }
}
