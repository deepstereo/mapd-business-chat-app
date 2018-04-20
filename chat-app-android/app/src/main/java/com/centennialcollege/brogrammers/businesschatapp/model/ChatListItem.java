package com.centennialcollege.brogrammers.businesschatapp.model;

import android.support.annotation.NonNull;

/**
 * Model class to store information about one single chat item to be displayed on chat list screen.
 */

public class ChatListItem implements Comparable<ChatListItem> {

    private String chatId;
    private String chatName;
    private String avatarUrl;
    private Message lastMessage;

    public ChatListItem() {
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ChatListItem && chatId.equals(((ChatListItem) obj).chatId);
    }

    @Override
    public int compareTo(@NonNull ChatListItem chatListItem) {
        if (chatListItem.getLastMessage() != null && lastMessage != null) {
            return Long.compare(chatListItem.getLastMessage().getTimeSent(), lastMessage.getTimeSent());
        } else {
            return 0;
        }
    }
}
