package com.ucc.application.Controllers;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.StoryEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.StoryModel;
import com.ucc.application.Models.UserStoryModel;
import com.ucc.application.Repositories.StoryRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;
import com.ucc.application.Services.StoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ucc/stories")
public class StoryController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    StoryRepo storyRepo;
    @Autowired
    FormService service;
    @Autowired
    StoryService storyService;

    @PostMapping(path = "/addStory")
    public StoryModel addStory(@RequestBody StoryEntity storyEntity , @RequestParam Long user_id) throws ParseException{
        StoryModel storyModel = new StoryModel();
        if(!userRepo.findById(user_id).isPresent()){
            storyModel.setId(-1L);
            storyModel.setText("User Not Found");
            return storyModel;
        }
        else{
            storyEntity.setUserEntity(userRepo.findById(user_id).get());
            storyEntity.setCreated_At(new Date());
            storyEntity = storyRepo.save(storyEntity);
            return service.StoryEntity_To_StoryModel(storyEntity);
        }    
    }

    @GetMapping(path = "/getallusersStory")
    public List<UserStoryModel> getAllUsersPost() throws ParseException{
        Optional<List<UserEntity>> OuserEntities  = userRepo.getAllUser();
        List<UserStoryModel> userStoryModels = new ArrayList<>();
        List<UserEntity> userEntities = OuserEntities.get();
        for (UserEntity userEntity : userEntities) {
            userStoryModels.add(service.UserStoryModelform(userEntity));
            
        }
        return userStoryModels;

    }

    @GetMapping(path = "/delete")
    public boolean deleteStory(@RequestParam Long story_id , @RequestParam Long user_id){
        if(!userRepo.findById(user_id).isPresent() || !storyRepo.findById(story_id).isPresent())
        return false;
        UserEntity userEntity = userRepo.findById(user_id).get();
 
        if(storyRepo.findById(story_id).get().getUserEntity().equals(userEntity)){
            userEntity.getUser_stories().remove(storyRepo.findById(story_id).get());
            storyRepo.deleteById(story_id);
            userRepo.save(userEntity);
            return true;

        }
        else
            return false;
    }

    @GetMapping(path = "/updateStories")
    public List<StoryModel> updateStory() throws ParseException{
        List<StoryModel> storyModels = new ArrayList<>();
        storyModels=storyService.MustDeleted(service.getAllUserStories());
        for (StoryModel storyModel : storyModels) {
            StoryEntity storyEntity = storyRepo.findById(storyModel.getId()).get();
            deleteStory(storyEntity.getId(), storyEntity.getUserEntity().getId());
        }
        return storyModels;

    }
    
}
