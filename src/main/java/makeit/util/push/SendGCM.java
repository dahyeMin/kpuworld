package makeit.util.push;

import makeit.util.push.gcm.server.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jinhyung on 2015. 12. 16..
 */
@Component
public class SendGCM {

    @Autowired
    PushMakeit pushMakeit;

    public void sendMessage(String key) {
        Message message = new Message.Builder()
                .timeToLive(3)
                .delayWhileIdle(true)
                .dryRun(true)
                .addData("name","ㅁㅁ")
                .addData("menu","ㄴㄴ")
                .addData("status","ㅇㅇ")
                .build();

        try {
            pushMakeit.sendNoti(message, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
