package com.project.contactMessage.service;

import com.project.contactMessage.dto.ContactMessageRequest;
import com.project.contactMessage.dto.ContactMessageResponse;
import com.project.contactMessage.repository.ContactMessageRepository;
import com.project.payload.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;


    public ResponseMessage<ContactMessageResponse> save(ContactMessageRequest contactMessageRequest) {

        return null;
    }
}
