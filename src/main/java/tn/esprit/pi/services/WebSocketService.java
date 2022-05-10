package tn.esprit.pi.services;

import tn.esprit.pi.Config.websocket.Greeting;
import tn.esprit.pi.entities.WebSocketMessage;
import tn.esprit.pi.service.WebSocketService;
import tn.esprit.pi.service.WebSocket.WebSocketService;

@Service("webSocketService")
public class WebSocketService implements  IWebSocketService{
    @Override
    public Greeting sendWebSocketMessage(WebSocketMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(HtmlUtils.htmlEscape(message.getSocketMessage()));
    }
}