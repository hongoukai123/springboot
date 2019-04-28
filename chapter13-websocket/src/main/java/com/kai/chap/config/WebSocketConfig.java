package com.kai.chap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 自定义WebSocket服务端点配置类
 * <p>
 *     注解@Configuration标明此类为spring配置类
 * </p>
 * @author hok
 * @since 2019-4-18 15:05:17
 */
@Configuration
public class WebSocketConfig {

    /**
     * 创建服务器端点
     * <p>
     *     注解@Bean表示将此方法注入到spring容器中
     * </p>
     * <p>
     *     新建ServerEndpointExporter对象，通过它可以定义WebSocket服务器的端点，
     *     这样客户端就能请求服务器的端点。
     *     有了这个Bean，就可以使用@ServerEndpoint定义一个端点服务类
     * </p>
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
