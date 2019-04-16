package com.kai.chap.topic;

public class TopicTest {

    public static void main(String[] args) {
        TopicActiveMq topicActiveMq = new TopicActiveMq();
        try {
            //发送消息
            topicActiveMq.testTopicProducer();
            //接收消息
            topicActiveMq.testTopicConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
