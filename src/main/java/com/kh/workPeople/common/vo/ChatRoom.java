package com.kh.workPeople.common.vo;

import lombok.Data;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Data
public class ChatRoom {

    private String id;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public ChatRoom(String id, String name){
        this.id=id;
        this.name=name;
    }

//    해당 방에서 메세지가 발생했을 때 처리하는 메소드
    public void handleMessage(WebSocketSession session,ChatMessage chatMessage) throws IOException {

        if(chatMessage.getMessageType() == MessageType.JOIN){
            /* 사용자 입장 */
            sessions.add(session);
            System.out.println("session"+session);

            if(chatMessage.getSender().equals("고객센터")){
                chatMessage.setMessage(chatMessage.getSender() + "와의 채팅이 연결되었습니다.<br> 안녕하세요, Work People 고객센터입니다. <br>무엇을 도와드릴까요?");
            } else{
                chatMessage.setMessage(chatMessage.getSender() + "님, 상담 신청이 접수되었습니다.<br>담당 상담원과 연결이 될 때까지 잠시만 기다려주세요.");
            }

        } else if(chatMessage.getMessageType() == MessageType.LEAVE){
            /* 사용자 퇴장 */
            sessions.remove(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 퇴장하셨습니다.");
        } else{
            /* 메세지 전달 */
            chatMessage.setMessage(chatMessage.getSender()+ " : "+chatMessage.getMessage());
        }

        /* 세션 안의 사람들에게 타입에 맞게 설정 된 메세지 발송 */
        for(WebSocketSession wss : sessions){
            wss.sendMessage(new TextMessage(chatMessage.getMessage()));
        }


    }


























}
