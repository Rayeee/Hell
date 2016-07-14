package winter.hell.producer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import winter.hell.producer.service.IMessageProducerService;
import winter.hell.util.JsonHelper;

/**
 * Created by Rayee on 16/7/14.
 */
public class MessageProducerServiceImpl implements IMessageProducerService{

    Logger logger = LoggerFactory.getLogger(MessageProducerServiceImpl.class);

    private static final String DELAY_ROUTING_KEY = "";

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public <E> boolean writeInnerQueue(E msgObj) {
        String message = JsonHelper.transObjToJsonString(msgObj);
        try {
            amqpTemplate.convertAndSend(DELAY_ROUTING_KEY, message.getBytes());
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
