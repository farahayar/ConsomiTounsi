package tn.esprit.pi.services;

import tn.esprit.pi.configurations.WebsocketConfig.Greeting;
import tn.esprit.pi.entities.WebSocketMessage;

public interface IWebSocketService {
	   Greeting sendWebSocketMessage(WebSocketMessage message) throws Exception ;


}


