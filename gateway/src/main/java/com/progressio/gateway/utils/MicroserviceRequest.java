package com.progressio.gateway.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class MicroserviceRequest {

    public static Object CreateRequest(String url, String message, Object object, HttpMethod method) throws JSONException {
        HttpHeaders headers = new HttpHeaders();

//        String token = MessageConverter.getToken(message);
//        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity;

        if(method == HttpMethod.POST){
            JSONObject postData = new JSONObject(message).getJSONObject("Content");
            entity = new HttpEntity<>(postData.toString(), headers);

        }else{
            entity = new HttpEntity<>(headers);
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<?> response = restTemplate.exchange(url, method, entity, object.getClass());

        return response.getBody();
    }

    public static Object PublicCreateRequest(String url, String message, Object object, HttpMethod method) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity;

        if(method == HttpMethod.POST){
            JSONObject postData;

            try {
                postData = new JSONObject(message).getJSONObject("Content");
            } catch (Exception e) {
                postData = new JSONObject(message).getJSONObject("content");
            }

            entity = new HttpEntity<>(postData.toString(), headers);

        }else{
            entity = new HttpEntity<>(headers);
        }

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<?> response = restTemplate.exchange(url, method, entity, object.getClass());

        return response.getBody();
    }
}
