import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoEndpoint {
    @OnMessage
    public void onMessage(Session session, String message)
    {
        System.out.println(message);
        try {
            session.getBasicRemote().sendText("You sent " + message + " Count : " + WebSocketServer.getCount().get());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
