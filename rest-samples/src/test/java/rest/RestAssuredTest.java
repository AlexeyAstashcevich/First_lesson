package rest;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class RestAssuredTest extends TestBase {
  @BeforeMethod
  public void init() {
    RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
  }


  @Test
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(1797);
    Set<Issue> oldIssues = getIssuesWithRestAssured();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssueWithRestAssured(newIssue);
    Set<Issue> newIssues = getIssuesWithRestAssured();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }


}

