package com.kai.chap.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 测试ActiveMQ的queue(一对多)
 * 消息发送与接收
 * @author hok
 * @since 2019-4-16 14:40:11
 */
public class QueueActiveMq {

    /**
     * 测试queue的消息发送
     * @throws Exception
     */
    public void testMqProducerQueue()throws Exception{
        //创建工厂连接对象，需要指定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //使用连接对象创建会话(session)对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用会话创建目标对象
        Queue queue = session.createQueue("test-queue");
        //使用会话对象创建一个生产者对象
        MessageProducer producer = session.createProducer(queue);
        //使用会话对象创建一个消息对象
        TextMessage textMessage = session.createTextMessage("hellotest-queue");
        //发送消息
        producer.send(textMessage);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }

    /**
     * 测试queue的消息接收
     * @throws Exception
     */
    public void testMqConsumerQueue() throws Exception{
        //创建工厂连接对象，需要指定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //使用连接工厂创建连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //使用连接对象创建会话(session)对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用会话对象创建目标对象
        Queue queue = session.createQueue("test-queue");
        //使用会话创建消费者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //想consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //等待程序接收用户消息
        System.in.read();
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

}
