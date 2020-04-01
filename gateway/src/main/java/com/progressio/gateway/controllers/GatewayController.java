package com.progressio.gateway.controllers;

import com.progressio.gateway.utils.DestinationRouter;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GatewayController {
    private DestinationRouter destinationRouter = new DestinationRouter();

    @PostMapping (value = "/gateway")
    public String gatewayEntrance(@RequestBody String incomingMessage) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, JSONException, InvocationTargetException {
        return (String) destinationRouter.createApiEndpoint(incomingMessage);
    }
}
