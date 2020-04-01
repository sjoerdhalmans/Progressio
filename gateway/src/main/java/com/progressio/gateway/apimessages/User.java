package com.progressio.gateway.apimessages;

import com.progressio.gateway.utils.MicroserviceRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;

public class User {
    public static String getUserById(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        String url = "http://localhost:8081/api/getUserById/" + jsonObject.getString("Content");

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.GET);
    }

    public static String getAllUsers(String json) throws JSONException {
        String url = "http://localhost:8081/api/getAllUsers";

        return (String) MicroserviceRequest.CreateRequest(url, json, "", HttpMethod.GET);
    }

    public static String addUser(String json) throws JSONException {
        String url = "http://localhost:8081/api/addUser";

        JSONObject jsonObject = new JSONObject(json);
        JSONObject body = jsonObject.getJSONObject("Destinations");

        return (String) MicroserviceRequest.CreateRequest(url, body.toString(), "", HttpMethod.POST);
    }
}

