package winter.hell.producer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by Rayee on 16/7/14.
 */
public class HellMessageListener implements MessageListener{

    private Logger logger = LoggerFactory.getLogger(HellMessageListener.class);

    @Resource
    private HellMessageHandler hellMessageHandler;

    @Override
    public void onMessage(Message message) {
        try {
            String msg = new String(message.getBody(), "utf-8");
            hellMessageHandler.handle(msg);
        } catch (UnsupportedEncodingException e) {
            logger.error("serialize message error!");
        }catch (Exception e){
            logger.error("handle message error");
        }
    }
}
