package makeit.util.push;

import makeit.util.push.gcm.server.Message;
import makeit.util.push.gcm.server.Result;

import java.io.IOException;

/**
 * Created by jinhyung on 2015. 12. 2..
 */
public interface PushMakeit {
    /**
     * 푸쉬알림 날리기
     * @param message 메시지
     * @param key push Key
     * @return
     */
    public Result sendNoti(Message message, String key) throws IOException;
}
