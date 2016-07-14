package winter.hell.producer.service;

/**
 * Created by Rayee on 16/7/14.
 */
public interface IMessageProducerService {

    <E> boolean writeInnerQueue(E msgObj);

}
