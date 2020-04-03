package com.progressio.gateway.utils;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DestinationRouter {
    public Object createApiEndpoint(String json) throws JSONException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        JSONObject jsonObject = new JSONObject(json);

        JSONObject destination = jsonObject.getJSONObject("Destination");

            Method method = Class
                    .forName("com.progressio.gateway.apimessages." + destination.getString("ApiName"))
                    .getMethod(destination.getString("ApiMethod"), String.class);

            return method.invoke(null, json);
    }
}
