package com.websocket.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping("/websocketdinle")
	public String htmlPage(){
		return "websocket";
	}
	
}
