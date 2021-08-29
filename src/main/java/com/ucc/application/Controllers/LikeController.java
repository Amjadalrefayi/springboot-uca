package com.ucc.application.Controllers;



import java.util.ArrayList;
import java.util.List;

import com.ucc.application.Entities.LikeEntity;
import com.ucc.application.Entities.LoveEntity;
import com.ucc.application.Entities.PostEntity;
import com.ucc.application.Models.LikeModel;
import com.ucc.application.Models.LoveModel;
import com.ucc.application.Repositories.CommentRepo;
import com.ucc.application.Repositories.LikeRepo;
import com.ucc.application.Repositories.LoveRepo;
import com.ucc.application.Repositories.PostRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/ucc/likes")
public class LikeController {

    @Autowired
    LikeRepo likeRepo;
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    LoveRepo loveRepo;
    @Autowired
    FormService service;


    @GetMapping(path = "/addlikepost")
    public boolean addlikepost(@RequestParam Long user_id , @RequestParam Long post_id){
         LikeEntity likeEntity = new LikeEntity();
        if((postRepo.findById(post_id).isPresent()) && userRepo.findById(user_id).isPresent())
        {
           for(int i =0 ; i< userRepo.findById(user_id).get().getUser_Likes().size(); i++)
           {
               if(userRepo.findById(user_id).get().getUser_Likes().get(i).getPostEntity().equals(postRepo.findById(post_id).get()))
               {

                likeRepo.deleteLike(userRepo.findById(user_id).get().getUser_Likes().get(i).getId());
                   return false;
               }
           }
           likeEntity.setUserEntity(userRepo.findById(user_id).get());
           likeEntity.setPostEntity(postRepo.findById(post_id).get());
           likeRepo.save(likeEntity);
           return true;
        }
        else
            return false;
           
    }

    @GetMapping(path = "/addlovepost")
    public boolean addlovepost(@RequestParam Long user_id , @RequestParam Long post_id){
         LoveEntity loveEntity = new LoveEntity();
        if((postRepo.findById(post_id).isPresent()) && userRepo.findById(user_id).isPresent())
        {
           for(int i =0 ; i< userRepo.findById(user_id).get().getUser_Loves().size(); i++)
           {
               if(userRepo.findById(user_id).get().getUser_Loves().get(i).getPostEntity().equals(postRepo.findById(post_id).get()))
               {

                loveRepo.deleteLove(userRepo.findById(user_id).get().getUser_Loves().get(i).getId());
                   return false;
               }
           }
           loveEntity.setUserEntity(userRepo.findById(user_id).get());
           loveEntity.setPostEntity(postRepo.findById(post_id).get());
           loveRepo.save(loveEntity);
           return true;
        }
        else
            return false;
           
    }
    
    @GetMapping(path = "/getlikespost")
    public List<LikeModel> getlikeposts(@RequestParam Long post_id){
        PostEntity postEntity = new PostEntity();
        if(postRepo.findById(post_id).isPresent())
        {
            postEntity = postRepo.findById(post_id).get();
            List <LikeModel> likeModels = new ArrayList<>();
            for( LikeEntity likeEntity : postEntity.getPost_Likes() )
                likeModels.add(service.LikeEntity_To_LikeModel(likeEntity));

            return likeModels;
        }
        else
        return new ArrayList<>();
        
    }

    @GetMapping(path = "/getlovespost")
    public List<LoveModel> getloveposts(@RequestParam Long post_id){
        PostEntity postEntity = new PostEntity();
        if(postRepo.findById(post_id).isPresent())
        {
            postEntity = postRepo.findById(post_id).get();
            List <LoveModel> loveModels = new ArrayList<>();
            for( LoveEntity loveEntity : postEntity.getPost_Loves() )
            loveModels.add(service.LoveEntity_To_LoveModel(loveEntity));

            return loveModels;
        }
        else
        return new ArrayList<>();
        
    }
    
    @GetMapping(path = "/getuserlikePost")
    public boolean getuserlikePost(@RequestParam Long user_id , @RequestParam Long post_id){
        if((postRepo.findById(post_id).isPresent()) && userRepo.findById(user_id).isPresent())
        {
           for(int i =0 ; i< userRepo.findById(user_id).get().getUser_Likes().size(); i++)
               if(userRepo.findById(user_id).get().getUser_Likes().get(i).getPostEntity().equals(postRepo.findById(post_id).get()))
                   return true;   
  
           return false;
        }
        else
            return false;
           
    }

}
