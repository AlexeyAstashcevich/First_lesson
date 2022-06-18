package rest;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {

  boolean isIssueOpen(int issueId) {
    String status = "";
    String json = RestAssured.get("https://bugify.stqa.ru/api/issues/" + issueId + ".json").getBody().asString();
    JsonObject parsed = new JsonParser().parse(json).getAsJsonObject();
    JsonArray issues = parsed.getAsJsonArray("issues");
    for (JsonElement state_name : issues) {
      JsonObject statuses = state_name.getAsJsonObject();
      status = statuses.get("state_name").toString().replaceAll("\"", "");
      System.out.println("Статус задачи - " + status); // выводим имя статуса задачи.
    }
    return !status.equals("Resolved");
  }


  public void skipIfNotFixed(int issueId) {
    if (!isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }


  public Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }


  public int createIssue(Issue newIssue) throws IOException {

    String json = getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json").bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()), new BasicNameValuePair("description", newIssue.getDescription()))).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }


  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }


  public Set<Issue> getIssuesWithRestAssured() throws IOException {
    String json = RestAssured.get("https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }


  public int createIssueWithRestAssured(Issue newIssue) throws IOException {
    String json = RestAssured.given().parameter("subject", newIssue.getSubject()).parameter("description", newIssue.getDescription()).post("https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

}

