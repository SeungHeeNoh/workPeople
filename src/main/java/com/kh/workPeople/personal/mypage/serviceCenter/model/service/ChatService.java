package com.kh.workPeople.personal.mypage.serviceCenter.model.service;

import com.kh.workPeople.common.vo.ChatRoom;

import java.util.List;

public interface ChatService {

//    채팅방 생성
    ChatRoom createChatRoom(String name);

//    모든 채팅방 조회
    List<ChatRoom> findAllChatRoom();

//    특정 채팅방 조회 - 채팅방 입장
    ChatRoom findChatRoomById(String chatRoomId);


    void deleteChatRoom(String chatRoomId);
}
