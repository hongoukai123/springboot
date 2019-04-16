package com.kai.chap.queue;

public class QueueTest {

    public static void main(String[] args) {
        QueueActiveMq queueActiveMq = new QueueActiveMq();
        try {
            //发送消息
            queueActiveMq.testMqProducerQueue();
            //接收消息
            queueActiveMq.testMqConsumerQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
