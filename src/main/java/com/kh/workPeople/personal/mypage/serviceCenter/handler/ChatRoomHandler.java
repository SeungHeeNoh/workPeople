package com.kh.workPeople.personal.mypage.serviceCenter.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class ChatRoomHandler extends TextWebSocketHandler {

    private Set<WebSocketSession> sessions = new HashSet<>();

//    사용자 연결이 되면 실행
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        연결되면 사용자를 session에 담음
        sessions.add(session);

//        연결 된 사용자에 부여 된 세션 아이디 출력
        log.info("---------- 사용자 연결 -------------");
        log.info("session ip : {}", session.getRemoteAddress());
        log.info("session id : {}", session.getId());



        super.afterConnectionEstablished(session);
    }

//    메세지가 전송되면 실행되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        log.info("-------------사용자 메세지 발송-------------");
        log.info("session ip : {}", session.getRemoteAddress());
        log.info("session id : {}", session.getId());
        log.info("username : {}",session.getAttributes().get("username"));
        log.info("message : {}",message.getPayload());

//        다수 인원에게 메세지 전송
        for(WebSocketSession wss : sessions){
            /* 발송자 ip, username, 메세지 */
            wss.sendMessage(new TextMessage(session.getRemoteAddress() + "|" +
                    session.getAttributes().get("username")+"|"+
                    message.getPayload()));
        }


        super.handleTextMessage(session, message);
    }

//    사용자 연결이 끊어지면 실행되는 메소드드
   @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

       log.info("----- 사용자 연결 끊김 -----");
       log.info("session ip : {}", session.getRemoteAddress());
       log.info("session id : {}",session.getId());
       log.info("username : {}",session.getAttributes().get("username"));

       /* 접속 리스트에서 session 삭제 */
       sessions.remove(session);

       /* 퇴장 메세지 전달 */
       for(WebSocketSession wss : sessions) {
           wss.sendMessage(new TextMessage(session.getAttributes().get("username") + "님이 퇴장하셨습니다."));
       }




        super.afterConnectionClosed(session, status);
    }






























}
