package ru.stqa.pft.srt.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {
  private  FTPClient ftp;
  private final ApplicationManager app;

  public FtpHelper(ApplicationManager app) {
    this.app = app;
    ftp = new FTPClient();

  }

  public void upload(File file, String target, String backup) throws IOException {
    ftp.connect(app.getProperty("ftp_host"));
    ftp.login(app.getProperty("ftp_login"), app.getProperty("ftp_password"));
    ftp.deleteFile(backup);
    ftp.rename(target,backup);
    ftp.enterLocalPassiveMode();
    ftp.storeFile(target, new FileInputStream(file));
    ftp.disconnect();
  }

  public void restore(String backup, String target) throws IOException {
    ftp.connect(app.getProperty("ftp_host"));
    ftp.login(app.getProperty("ftp_login"), app.getProperty("ftp_password"));
    ftp.deleteFile(target);
    ftp.rename(backup,target);
    ftp.disconnect();
  }
}
