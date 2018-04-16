package com.centennialcollege.brogrammers.businesschatapp.data.remote;

import com.centennialcollege.brogrammers.businesschatapp.Constants;
import com.centennialcollege.brogrammers.businesschatapp.model.Chat;
import com.centennialcollege.brogrammers.businesschatapp.model.Message;
import com.centennialcollege.brogrammers.businesschatapp.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FirebaseDbHelperImpl implements FirebaseDbHelper {

    @Override
    public Task<Void> addUserInfo(String userId, User user) {
        return FirebaseDatabase.getInstance()
                .getReference()
                .child(Constants.USERS_CHILD)
                .child(userId)
                .setValue(user);
    }

    @Override
    public Task<Void> addContactToUserContacts(String userId, String newContactId) {
        Map<String, Object> map = new HashMap<>();
        map.put(newContactId, true);
        return addContactsToUserContacts(userId, map);
    }

    @Override
    public Task<Void> addContactsToUserContacts(String userId, Map<String, Object> newContactsId) {
        return FirebaseDatabase.getInstance()
                .getReference()
                .child(Constants.USERS_CHILD)
                .child(userId)
                .child("contactList") // fixMe add to constant
                .updateChildren(newContactsId);
    }

    @Override
    public Task<Void> addActivePersonalChats(String userId, Map<String, Object> newChatsId) {
        return FirebaseDatabase.getInstance()
                .getReference()
                .child(Constants.USERS_CHILD)
                .child(userId)
                .child("activePersonalChats") // fixMe add to constant
                .updateChildren(newChatsId);
    }

    @Override
    public Task<Void> createChat(String chatId, Chat chat) {
        return FirebaseDatabase.getInstance()
                .getReference()
                .child(Constants.CHATS_CHILD)
                .child(chatId)
                .setValue(chat);
    }

    @Override
    public Task<Void> createMessage(String chatId, Message message) {
        return FirebaseDatabase.getInstance()
                .getReference()
                .child(Constants.MESSAGES_CHILD)
                .child(chatId)
                .child(UUID.randomUUID().toString())
                .setValue(message);
    }

}