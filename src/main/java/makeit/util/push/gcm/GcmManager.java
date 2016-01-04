package makeit.util.push.gcm;

import makeit.util.push.PushMakeit;
import makeit.util.push.gcm.server.Message;
import makeit.util.push.gcm.server.Result;
import makeit.util.push.gcm.server.Sender;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jinhyung on 2015. 12. 2..
 */
@Component
public class GcmManager implements PushMakeit {
    private final String apiKey = "AIzaSyCP_nvkfqYABAAw-YVFZKnZk62iNmadW1c";

    @Override
    public Result sendNoti(Message message, String key) throws IOException {
        Sender sender = new Sender(apiKey);
        return sender.send(message, key, 3);
    }
}
