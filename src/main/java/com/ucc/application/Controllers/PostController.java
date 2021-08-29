package com.ucc.application.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.ucc.application.Entities.PostEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.PostModel;
import com.ucc.application.Repositories.PostRepo;
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
@RequestMapping(path="/ucc/posts")
public class PostController {

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    FormService formService;

    @PostMapping(path = "/add/{u_id}")
    public PostModel addpost(@RequestBody PostEntity postEntity , @PathVariable(name = "u_id") Long user_id)
    {
        Optional<UserEntity> userEntity;
        if((userEntity = userRepo.findById(user_id)).isPresent()){
            UserEntity userEntity2 = userEntity.get();
            postEntity.setUserEntity(userEntity2);
            postEntity.setPost_Likes(new ArrayList<>());
            postEntity.setComments(new ArrayList<>());
            postEntity.setReplaies(new ArrayList<>());
            postEntity.setPost_Loves(new ArrayList<>());
            postEntity.setCreated_At(new Date());
            postEntity = postRepo.save(postEntity);
            return formService.PostEntity_To_PostModel(postEntity);
        }
        else{
            PostModel postModel = new PostModel();
            postModel.setId(Long.valueOf(-1));
            return postModel;
        }
    }

    @GetMapping(path="/userPosts/{user_id}")
    public List<PostModel> getUserPosts(@PathVariable(name="user_id") Long user_id)
    {
        Optional<UserEntity> userEntity ;

        
        if((userEntity = userRepo.findById(user_id)).isPresent())
        {
            UserEntity userEntity2 = userEntity.get();
            List<PostModel> response = new ArrayList<>();
            List<PostEntity> templete = new ArrayList<>();
            templete = userEntity2.getUser_Posts();
           
            for (PostEntity postEntity : templete) {
                response.add(formService.PostEntity_To_PostModel(postEntity));
            }

            return response; 
        }
        return null;
    }

    @GetMapping(path = "/search")
    public List<PostModel> searchList(@RequestParam String value) {

        List<PostModel> postModels = new ArrayList<>();
        for( PostEntity postEntity : postRepo.search(value).get() )
        {
            postModels.add(formService.PostEntity_To_PostModel(postEntity));
        }
        return postModels;
    }

    @GetMapping(path = "/getallusersPost")
    public List<PostModel> getAllUserPost(){
        List<PostModel> postModels = new ArrayList<>();
        for( PostEntity postEntity : postRepo.getAllUserPost().get() )
        {
            postModels.add(formService.PostEntity_To_PostModel(postEntity));
        }
        return postModels;
    }

    @GetMapping(path = "/delete")
    public boolean deletePost(@RequestParam Long user_id ,@RequestParam Long post_id ){
        if(!userRepo.findById(user_id).isPresent() || !postRepo.findById(post_id).isPresent())
            return false;
        UserEntity userEntity = new UserEntity();
        userEntity = userRepo.findById(user_id).get();
        PostEntity postEntity = new PostEntity();
        postEntity = postRepo.findById(post_id).get();
        if(userEntity.getUser_Posts().contains(postEntity)){
            userEntity.getUser_Posts().remove(postEntity);
            postRepo.deleteById(post_id);
            userRepo.save(userEntity);
            return true;
        }
        else
        return false;
    }  

    @GetMapping(path = "/share")
    public boolean sharePost(@RequestParam Long user_id , @RequestParam Long post_id){
        if(!userRepo.findById(user_id).isPresent() || !postRepo.findById(post_id).isPresent())
        return false;

        PostEntity postEntity = new PostEntity();
        postEntity = postRepo.findById(post_id).get();

        if(userRepo.findById(user_id).get().getUser_Posts().contains(postEntity))
                 return false;

        PostEntity newpostEntity = new PostEntity();
       

        newpostEntity.setTitle(postEntity.getTitle());
        newpostEntity.setAttachment(postEntity.getAttachment());
        newpostEntity.setPost_Value(postEntity.getPost_Value());

        addpost(newpostEntity, user_id);

        return true;
    }
    
}
