package com.praveen.rideshare.ws.controller;

import lombok.Data;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
    @MessageMapping("/echo")           // client sends to /app/echo
    @SendTo("/topic/echo")             // subscribers to /topic/echo receive it
    public Msg echo(Msg m) { return m; }

    @Data public static class Msg { private String text; }
}
