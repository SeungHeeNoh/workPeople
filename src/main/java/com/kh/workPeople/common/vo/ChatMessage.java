package com.kh.workPeople.common.vo;

import lombok.Data;

@Data
public class ChatMessage {
    private String id;
    private String chatRoomId;
    private String sender;
    private String message;
    private MessageType messageType;
}
