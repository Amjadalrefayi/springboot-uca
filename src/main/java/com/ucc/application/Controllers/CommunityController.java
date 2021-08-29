package com.ucc.application.Controllers;

import com.ucc.application.Entities.CommunityEntity;
import com.ucc.application.Models.CommunityModel;
import com.ucc.application.Repositories.CommunityRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/ucc/communities")
public class CommunityController {
    @Autowired
    CommunityRepo communityRepo;
    @Autowired
    FormService service;

    @GetMapping(path = "/get")
    public CommunityEntity get(){
        return communityRepo.findByName("DMU_ITE").get();
    }

    @GetMapping(path = "/getCommunityInfo")
    public CommunityModel getCommunityInfo(@RequestParam Long community_id ){
        
        if(communityRepo.findById(community_id).isPresent())
            return service.CommunityModel_To_CommunityEntity(communityRepo.findById(community_id).get());

        else
            return null;
    }

    
}
