package com.ucc.application.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.CommunityEntity;
import com.ucc.application.Entities.PostComuEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.PostPCModel;
import com.ucc.application.Repositories.CommunityRepo;
import com.ucc.application.Repositories.PostComRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/ucc/postCom")
public class PostComController {

    @Autowired
    PostComRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    FormService formService;
    @Autowired
    CommunityRepo communityRepo;

    @PostMapping(path = "/add/{u_id}")
    public PostPCModel addpost(@RequestBody PostComuEntity postEntity , @PathVariable(name = "u_id") Long user_id)
    {
        Optional<UserEntity> userEntity;
      
        if((userEntity = userRepo.findById(user_id)).isPresent()){
            UserEntity userEntity2 = userEntity.get();
            postEntity.setUserEntity(userEntity2);
            postEntity.setPost_Likes(new ArrayList<>());
            postEntity.setComments(new ArrayList<>());
            postEntity.setReplaies(new ArrayList<>());
            postEntity.setCreated_At(new Date());
            CommunityEntity communityEntity2 = userEntity2.getCommunityEntity();
            postEntity.setCommunityEntity(communityEntity2);
            postEntity = postRepo.save(postEntity);
            return formService.PostPCEntity_To_PostPCModel(postEntity);
        }
        else{
            PostPCModel postModel = new PostPCModel();
            postModel.setId(Long.valueOf(-1));
            return postModel;
        }
    }

    @GetMapping(path="/userPosts/{user_id}")
    public List<PostPCModel> getUserPosts(@PathVariable(name="user_id") Long user_id)
    {
        Optional<UserEntity> userEntity ;

        
        if((userEntity = userRepo.findById(user_id)).isPresent())
        {
            UserEntity userEntity2 = userEntity.get();
            List<PostPCModel> response = new ArrayList<>();
            List<PostComuEntity> templete = new ArrayList<>();
            templete = userEntity2.getUser_PostCom();
           
            for (PostComuEntity postEntity : templete) {
                response.add(formService.PostPCEntity_To_PostPCModel(postEntity));
            }

            return response; 
        }
        return null;
    }

    @GetMapping(path = "/search")
    public List<PostPCModel> searchList(@RequestParam String value) {

        List<PostPCModel> postModels = new ArrayList<>();
        for( PostComuEntity postEntity : postRepo.search(value).get() )
        {
            postModels.add(formService.PostPCEntity_To_PostPCModel(postEntity));
        }
        return postModels;
    }

    @GetMapping(path = "/getallCommunityPost")
    public List<PostPCModel> getAllUserPost(@RequestParam Long community_id){

        if(!communityRepo.findById(community_id).isPresent())
            return null;
     
        List<PostComuEntity> postComuEntities = new ArrayList<>();
        Optional<List<PostComuEntity>> pOptional  = postRepo.getAllUserPost(community_id);
        postComuEntities = pOptional.get();
        List<PostPCModel> postModels = new ArrayList<>();
        for (PostComuEntity postComuEntity : postComuEntities) {
            postModels.add(formService.PostPCEntity_To_PostPCModel(postComuEntity));
        }

        return postModels;
    }

    @GetMapping(path = "/delete")
    public boolean deletePost(@RequestParam Long user_id ,@RequestParam Long post_id ){
        if(!userRepo.findById(user_id).isPresent() || !postRepo.findById(post_id).isPresent())
            return false;
        UserEntity userEntity = new UserEntity();
        userEntity = userRepo.findById(user_id).get();
        PostComuEntity postEntity = new PostComuEntity();
        postEntity = postRepo.findById(post_id).get();
        if(userEntity.getUser_PostCom().contains(postEntity)){
            userEntity.getUser_PostCom().remove(postEntity);
            postRepo.deleteById(post_id);
            userRepo.save(userEntity);
            return true;
        }
        else
        return false;
    }  

    
}
