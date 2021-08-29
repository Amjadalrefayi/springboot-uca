package com.ucc.application.Controllers;


import com.ucc.application.Models.MessageModel;
import com.ucc.application.Repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired 
    UserRepo userRepo;

    @MessageMapping("/chat")
    public void sendMessage(@RequestBody MessageModel message , @RequestParam Long user_id){

        String to = userRepo.findById(user_id).get().getEmail();
        System.out.println("handling send message" + message + "to" + to);

        if(!userRepo.findById(user_id).isPresent())
            return;

        simpMessagingTemplate.convertAndSend("/topic/messages"+to , message);

    }

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to , MessageModel message){
        System.out.println("handling send message" + message + "to" + to);
        
        
            simpMessagingTemplate.convertAndSend("/topic/messages"+to , message);



    }

    
    
}
