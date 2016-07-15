package winter.hell.producer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import winter.hell.exception.HellServiceException;

/**
 * Created by Rayee on 16/7/14.
 */
@Service
public class HellMessageHandler {

    private Logger logger = LoggerFactory.getLogger(HellMessageHandler.class);

    public void handle(String message) throws HellServiceException {
        logger.info("get a message:{}", message);
    }
}
