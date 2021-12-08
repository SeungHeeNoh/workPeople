package com.kh.workPeople.personal.mypage.serviceCenter.model.service;

import com.kh.workPeople.common.vo.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceCenterServiceImpl implements ChatService{

    //만들어진 채팅방이 관리 되는 공간 - db대신, 나중에 연결
    private final Map<String,ChatRoom> chatRooms;

    public ServiceCenterServiceImpl(){
        this.chatRooms = new LinkedHashMap<>();
    }

    @Override
    public ChatRoom createChatRoom(String name) {

//        새로운 채팅방 생성
        String id = UUID.randomUUID().toString();       // db연결하면 시퀀스
        ChatRoom newChatRoom = new ChatRoom(id,name);
        chatRooms.put(id,newChatRoom);


        return newChatRoom;
    }

    @Override
    public List<ChatRoom> findAllChatRoom() {

//        모든 채팅방 리턴

        // values붙이면 컬렉션 타입 리턴
        return new ArrayList<>(chatRooms.values());
    }

    @Override
    public ChatRoom findChatRoomById(String chatRoomId) {
//        id값 일치하는 채팅방 리턴
        return chatRooms.get(chatRoomId);
    }

    @Override
    public void deleteChatRoom(String chatRoomId) {

        chatRooms.remove(chatRoomId);
    }
}
