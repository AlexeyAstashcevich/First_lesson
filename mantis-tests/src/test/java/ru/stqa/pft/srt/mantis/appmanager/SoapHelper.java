package ru.stqa.pft.srt.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.srt.mantis.model.Issue;
import ru.stqa.pft.srt.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {
  private ApplicationManager app;

  public SoapHelper(ApplicationManager app) {

    this.app = app;
  }

  public Set<Project> getProject() throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "rooter");
    return Arrays.asList(projects).stream().map(p-> new Project()
            .withId(p.getId().intValue())
            .withName(p.getName()))
            .collect(Collectors.toSet());
  }

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    return new MantisConnectLocator()
            .getMantisConnectPort(new URL("http://localhost/mantisbt-2.25.3/api/soap/mantisconnect.php"));

  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    IssueData issueData = new IssueData();
    String[] category = mc.mc_project_get_categories("administrator", "rooter",BigInteger.valueOf(issue.getProject().getId()));
    issueData.setSummary(issue.getSummary());
    issueData.setSummary(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
    issueData.setCategory(category[0]);
    BigInteger issued = mc.mc_issue_add("administrator", "rooter", issueData);
    IssueData createdIssueData = mc.mc_issue_get("administrator", "rooter", issued);
    return new Issue().withId(createdIssueData.getId().intValue())
            .withSummary(createdIssueData.getSummary())
            .withDescription(createdIssueData.getDescription())
            .withProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                    .withName(createdIssueData.getProject().getName()));
  }
}
