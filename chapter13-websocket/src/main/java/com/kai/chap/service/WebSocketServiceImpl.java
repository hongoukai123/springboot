package com.kai.chap.service;

import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * WebSocket服务端站点
 * <p>
 *     注解@Service代表此类为业务类，启动程序spring会扫描此类到容器中。
 *     注解@ServerEndopint表示当前类为端点服务类，其中”/ws“是请求地址
 * </p>
 */
@ServerEndpoint("/ws")
@Service
public class WebSocketServiceImpl {

    //静态变量，用来记录当前在线连接数
    private static int ONLINE_COUNT = 0;

    //concurrent包的线程安全set,用来存放每个客户端对应的WebSocketServiceImpl对象
    private static CopyOnWriteArraySet<WebSocketServiceImpl> WEBSOCKET_SET = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * <p>
     *     注解@OnOpen标注客户端打开WebSocket服务端点调用方法
     * </p>
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        //将当前服务端点类加入set中
        WEBSOCKET_SET.add(this);
        //在线数+1
        addOnlineCount();
        System.out.println("有新链接加入！当前在线人数为：" + getOnlineCount());
        try {
            sendMessage("有新的连接加入了！！");
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     * <p>
     *     注解@OnClose标注客户端关闭WebSocket服务端点调用方法
     * </p>
     */
    @OnClose
    public void onClose(){
        //从set中删除当前对象
        WEBSOCKET_SET.remove(this);
        //在线数减一
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("来自客户端的消息");
    }

    /**
     * 当前在线数+1
     */
    private static synchronized void addOnlineCount(){
        WebSocketServiceImpl.ONLINE_COUNT++;
    }

    /**
     * 返回在线数
     * @return
     */
    private static synchronized int getOnlineCount(){
        return ONLINE_COUNT;
    }

    /**
     * 发送消息
     * @param message 消息
     * @throws IOException
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 在线数-1
     */
    private static synchronized void subOnlineCount(){
        WebSocketServiceImpl.ONLINE_COUNT--;
    }

}
