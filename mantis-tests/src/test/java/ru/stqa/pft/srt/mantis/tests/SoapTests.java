package ru.stqa.pft.srt.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.srt.mantis.model.Issue;
import ru.stqa.pft.srt.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase {
  @Test
  public void testGetProject() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(000005);
    Set<Project> projects = app.soap().getProject();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(000005);
    Set<Project> project = app.soap().getProject();
    Issue issue = new Issue().withSummary("Test Summary").withDescription("Test Description").withProject(project.iterator().next());
    Issue created = app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(), created.getSummary());
  }

}
