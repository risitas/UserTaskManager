package com.smzynm.UserTaskManager.services.impl;

import com.smzynm.UserTaskManager.services.MessageService;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class MessageServiceImpl implements MessageService {

    private final TwilioRestClient twilioClient;
    private final String twilioPhoneNumber;

    public MessageServiceImpl(@Value("${twilio.account.sid}") String accountSid,
                          @Value("${twilio.auth.token}") String authToken,
                          @Value("${twilio.phone.number}") String twilioPhoneNumber) {
        this.twilioClient = new TwilioRestClient.Builder(accountSid, authToken).build();
        this.twilioPhoneNumber = twilioPhoneNumber;
        Twilio.init(accountSid, authToken);
    }

    @Override
    public void sendMessage(String messageRequest, String phoneNumber) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(phoneNumber),
                new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                messageRequest)

                        .create();

        System.out.println(message.getSid());
    }
    }

