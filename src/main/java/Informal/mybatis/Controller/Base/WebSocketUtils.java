package Informal.mybatis.Controller.Base;


import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketUtils {
    private  static Map<String, Session> WEBSOCKET_SESSION = new ConcurrentHashMap<>();
    public static void put(String id, Session session){
        WEBSOCKET_SESSION.put(id, session);
    }

    public static Map<String, Session> getWebsocketSession() {
        return WEBSOCKET_SESSION;
    }

    public static Session get(String key) {
        return WEBSOCKET_SESSION.get(key);
    }

    public static void removeSession(String key) {
        WEBSOCKET_SESSION.remove(key);
    }

    public static boolean hasConnection(String key) {
        return WEBSOCKET_SESSION.containsKey(key);
    }
}
