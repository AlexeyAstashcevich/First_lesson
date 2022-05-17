package ru.stqa.pft.srt.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import org.apache.axis.Handler;
import org.apache.axis.SimpleChain;
import org.apache.axis.SimpleTargetedChain;
import org.apache.axis.client.AxisClient;
import org.apache.axis.configuration.SimpleProvider;
import org.apache.axis.transport.http.HTTPSender;
import org.apache.axis.transport.http.HTTPTransport;
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
    return Arrays.asList(projects).stream().map(p -> new Project()
                    .withId(p.getId().intValue())
                    .withName(p.getName()))
            .collect(Collectors.toSet());
  }

//  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
//    return new MantisConnectLocator()
//            .getMantisConnectPort(new URL("http://localhost/mantisbt-2.25.3/api/soap/mantisconnect.php"));
//
//  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] category = mc.mc_project_get_categories("administrator", "rooter", BigInteger.valueOf(issue.getProject().getId()));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
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

  public MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    SimpleProvider clientConfig = new SimpleProvider();
    AxisLogHandler logHandler = new AxisLogHandler();
    SimpleChain reqHandler = new SimpleChain();
    SimpleChain respHandler = new SimpleChain();
    reqHandler.addHandler(logHandler);
    respHandler.addHandler(logHandler);
    Handler pivot = new HTTPSender();
    Handler transport = new SimpleTargetedChain(reqHandler, pivot, respHandler);
    clientConfig.deployTransport(HTTPTransport.DEFAULT_TRANSPORT_NAME, transport);

    MantisConnectLocator locator = new MantisConnectLocator();
    locator.setEngineConfiguration(clientConfig);
    locator.setEngine(new AxisClient(clientConfig));
    return locator.getMantisConnectPort(new URL("http://localhost/mantisbt-2.25.3/api/soap/mantisconnect.php"));
  }
}
