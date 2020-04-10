package com.progressio.gateway.apimessages;

import com.progressio.gateway.utils.MicroserviceRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;

public class Project {

    public static String getProjectById(String json) throws JSONException {
    JSONObject jsonObject = new JSONObject(json);

    String url = "http://localhost:8085/api/getProjectById/" + jsonObject.getString("Content");

    return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.GET);
    }

    public static String getAllProjects(String json) throws JSONException {
        String url = "http://localhost:8085/api/getAllProjects";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.GET);
    }

    public static String addProject(String json) throws JSONException {
        String url = "http://localhost:8085/api/addProject";

        JSONObject jsonObject = new JSONObject(json);

        return (String) MicroserviceRequest.CreateRequest(url, jsonObject.toString(), "", HttpMethod.POST);
    }
    public static String addUserToProject(String json) throws JSONException {
        String url = "http://localhost:8085/api/addUserToProject";

        JSONObject jsonObject = new JSONObject(json);

        return (String) MicroserviceRequest.CreateRequest(url, jsonObject.toString(), "", HttpMethod.POST);
    }

    public static String removeProject(String json) throws JSONException {
        String url = "http://localhost:8085/api/removeProject";

        JSONObject jsonObject = new JSONObject(json);

        return (String) MicroserviceRequest.CreateRequest(url, jsonObject.toString(), "", HttpMethod.DELETE);
    }
}
