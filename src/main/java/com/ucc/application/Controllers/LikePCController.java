package com.ucc.application.Controllers;



import java.util.ArrayList;
import java.util.List;

import com.ucc.application.Entities.LikePCEntity;
import com.ucc.application.Entities.PostComuEntity;
import com.ucc.application.Models.LikePCModel;
import com.ucc.application.Repositories.CommentPCRepo;
import com.ucc.application.Repositories.LikePCRepo;
import com.ucc.application.Repositories.PostComRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/ucc/likesPC")
public class LikePCController {

    @Autowired
    LikePCRepo likeRepo;
    @Autowired
    PostComRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentPCRepo commentRepo;
    @Autowired
    FormService service;

    @GetMapping(path = "/addlikepost")
    public boolean addlikepost(@RequestParam Long user_id , @RequestParam Long post_id){
         LikePCEntity likeEntity = new LikePCEntity();
        if((postRepo.findById(post_id).isPresent()) && userRepo.findById(user_id).isPresent())
        {
           for(int i =0 ; i< userRepo.findById(user_id).get().getUser_LikesPC().size(); i++)
           {
               if(userRepo.findById(user_id).get().getUser_LikesPC().get(i).getPostComuEntity().equals(postRepo.findById(post_id).get()))
               {

                likeRepo.deleteLike(userRepo.findById(user_id).get().getUser_LikesPC().get(i).getId());
                   return false;
               }
           }
           likeEntity.setUserEntity(userRepo.findById(user_id).get());
           likeEntity.setPostComuEntity(postRepo.findById(post_id).get());
           likeRepo.save(likeEntity);
           return true;
        }
        else
            return false;
           
    }

    @GetMapping(path = "/getlikespost")
    public List<LikePCModel> getlikeposts(@RequestParam Long post_id){
        PostComuEntity postEntity = new PostComuEntity();
        if(postRepo.findById(post_id).isPresent())
        {
            postEntity = postRepo.findById(post_id).get();
            List <LikePCModel> likeModels = new ArrayList<>();
            for( LikePCEntity likeEntity : postEntity.getPost_Likes() )
                likeModels.add(service.LikePCEntity_To_LikePCModel(likeEntity));

            return likeModels;
        }
        else
        return new ArrayList<>();
        
    }
    
    @GetMapping(path = "/getuserlikePost")
    public boolean getuserlikePost(@RequestParam Long user_id , @RequestParam Long post_id){
        if((postRepo.findById(post_id).isPresent()) && userRepo.findById(user_id).isPresent())
        {
           for(int i =0 ; i< userRepo.findById(user_id).get().getUser_LikesPC().size(); i++)
               if(userRepo.findById(user_id).get().getUser_LikesPC().get(i).getPostComuEntity().equals(postRepo.findById(post_id).get()))
                   return true;   
  
           return false;
        }
        else
            return false;
           
    }

}