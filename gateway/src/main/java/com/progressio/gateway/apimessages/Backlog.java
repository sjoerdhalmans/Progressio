package com.progressio.gateway.apimessages;

import com.progressio.gateway.utils.MicroserviceRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;

public class Backlog {
    public static String getBacklogById(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/getBacklogById/" + jsonObject.getString("Content");

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.GET);
    }

    public static String addEpic(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/addEpic";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.POST);
    }

    public static String addStory(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);


        String url = "http://localhost:8086/api/addStory/";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.POST);
    }

    public static String addTask(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/addTask/";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.POST);
    }

    public static String updateEpic(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/updateEpic";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.PUT);
    }

    public static String updateStory(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/updateStory/";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.PUT);
    }

    public static String updateTask(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/updateTask/";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.PUT);
    }

    public static String deleteTask(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/deleteTask/" + jsonObject.getString("Content");

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.DELETE);
    }

    public static String deleteEpic(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/deleteEpic/" + jsonObject.getString("Content");

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.DELETE);
    }

    public static String deleteStory(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8086/api/deleteStory/" + jsonObject.getString("Content");

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.DELETE);
    }
}
