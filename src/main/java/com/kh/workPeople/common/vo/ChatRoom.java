package com.kh.workPeople.common.vo;

import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

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
    public void handleMessage(WebSocketSession session,ChatMessage chatMessage){

        if(chatMessage.getMessageType() == MessageType.JOIN){
            /* 사용자 입장 */
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장하셨습니다.");
        } else if(chatMessage.getMessageType() == MessageType.LEAVE){
            /* 사용자 퇴장 */
            sessions.remove(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 퇴장하셨습니다.");
        } else{

            /* 메세지 전달 */
            chatMessage.setMessage(chatMessage.getSender()+ " : "+);
        }
    }


























}
