package com.kh.workPeople.personal.mypage.serviceCenter.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.workPeople.common.vo.ChatMessage;
import com.kh.workPeople.common.vo.ChatRoom;
import com.kh.workPeople.personal.mypage.serviceCenter.model.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class MultiChatRoomHandler extends TextWebSocketHandler {

    private final ChatService chatService;
    private final ObjectMapper objectMapper;

    public MultiChatRoomHandler(ChatService chatService,ObjectMapper objectMapper){
        this.chatService = chatService;
        this.objectMapper = objectMapper;
    }

//    클라이언트에서 서버로 메세지가 왔을 때 동작하는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        log.info("메세지 전송 {} : {}",session,message.getPayload());

//   클라이언트측에서 전달받은 JSON형태의 문자열을 ChatMessage 객체로 변환
//        ObjectMapper(jackson.databind) - JSON to JAVA Object

        String msg = message.getPayload();
        ChatMessage chatMessage = objectMapper.readValue(msg,ChatMessage.class);
        ChatRoom chatRoom = chatService.findChatRoomById(chatMessage.getChatRoomId());
        chatRoom.handleMessage(session,chatMessage);

        super.handleTextMessage(session, message);
    }

























}
