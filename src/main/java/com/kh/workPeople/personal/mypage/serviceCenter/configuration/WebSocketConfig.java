package com.kh.workPeople.personal.mypage.serviceCenter.configuration;

import com.kh.workPeople.personal.mypage.serviceCenter.handler.ChatRoomHandler;
import com.kh.workPeople.personal.mypage.serviceCenter.handler.MultiChatRoomHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatRoomHandler chatRoomHandler;
    private final MultiChatRoomHandler multiChatRoomHandler;

    @Autowired
    public WebSocketConfig(ChatRoomHandler chatRoomHandler,MultiChatRoomHandler multiChatRoomHandler){
        this.chatRoomHandler = chatRoomHandler;
        this.multiChatRoomHandler = multiChatRoomHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(chatRoomHandler, "/single-chat")
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .withSockJS();

        registry.addHandler(multiChatRoomHandler,"/multi-chat");

    }
}
