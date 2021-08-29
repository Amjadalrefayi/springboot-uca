package com.ucc.application.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.ucc.application.Entities.ComReactEntity;
import com.ucc.application.Entities.CommentEntity;
import com.ucc.application.Entities.PostEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.ComReactModel;
import com.ucc.application.Models.CommentModel;
import com.ucc.application.Repositories.ComReactRepo;
import com.ucc.application.Repositories.CommentRepo;
import com.ucc.application.Repositories.PostRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/ucc/comments")
public class CommentController {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    FormService service;
    @Autowired
    ComReactRepo comReactRepo;

    @PostMapping(path = "/addcomment")
    public CommentModel addcomment(@RequestParam Long user_id, @RequestParam Long post_id, @RequestParam String value) {
        CommentEntity commentEntity = new CommentEntity();
        if (postRepo.findById(post_id).isPresent() && userRepo.findById(user_id).isPresent()) {
            System.out.println("HIII");
            commentEntity.setUserEntity(userRepo.findById(user_id).get());
            commentEntity.setPostEntity(postRepo.findById(post_id).get());
            commentEntity.setComment_Value(value);
            commentEntity.setComment_Reactions(new ArrayList<>());
            commentEntity.setComment_Replaies(new ArrayList<>());
            commentEntity = commentRepo.save(commentEntity); 
            return service.CommentEntity_To_CommentModel(commentEntity);

        } else
            return null;
    }

    @PostMapping(path = "/delete")
    public Boolean deleteComment(@RequestParam Long user_id, @RequestParam Long post_id,
            @RequestParam Long comment_id) {

        if (!userRepo.findById(user_id).isPresent() || !commentRepo.findById(comment_id).isPresent()
                || !postRepo.findById(post_id).isPresent())
            return false;

        CommentEntity commentEntity = commentRepo.findById(comment_id).get();
        UserEntity userEntity = userRepo.findById(user_id).get();
        PostEntity postEntity = postRepo.findById(post_id).get();

        if (postEntity.getComments().contains(commentEntity)) {

            if (userEntity.getUser_Posts().contains(postEntity)) {
                postEntity.getComments().remove(commentEntity);
                userEntity = commentEntity.getUserEntity();
                userEntity.getUser_Comments().remove(commentEntity);
                commentRepo.deleteById(commentRepo.findById(comment_id).get().getId());
                postRepo.save(postEntity);
                userRepo.save(userEntity);
                return true;
            } else {
                if (userEntity.getUser_Comments().contains(commentEntity)) {
                    postEntity.getComments().remove(commentEntity);
                    userEntity = commentEntity.getUserEntity();
                    userEntity.getUser_Comments().remove(commentEntity);
                    commentRepo.deleteById(commentRepo.findById(comment_id).get().getId());
                    postRepo.save(postEntity);
                    userRepo.save(userEntity);
                    return true;
                } else
                    return false;
            }

        } else
            return false;
    }

    @GetMapping(path = "/addreaction")
    public boolean addReaction(@RequestParam Long user_id , @RequestParam Long comment_id){
        ComReactEntity comReactEntity = new ComReactEntity();
        if(!userRepo.findById(user_id).isPresent() || !commentRepo.findById(comment_id).isPresent())
            return false;

        for(int i=0; i< userRepo.findById(user_id).get().getUser_ComReacts().size() ; i++){

            if(userRepo.findById(user_id).get().getUser_ComReacts().get(i).getCommentEntity().equals(commentRepo.findById(comment_id).get())){
                
                comReactRepo.deleteComReact(userRepo.findById(user_id).get().getUser_ComReacts().get(i).getId());
                   return false;
            }
        }

        comReactEntity.setUserEntity(userRepo.findById(user_id).get());
        comReactEntity.setCommentEntity(commentRepo.findById(comment_id).get());
        comReactRepo.save(comReactEntity);
        return true;

    }

    @GetMapping(path = "/getpostcomment")
    public List <CommentModel> getcomments(@RequestParam Long post_id){

        
        //PostEntity postEntity = new PostEntity();
        if(postRepo.findById(post_id).isPresent())
        {
            // postEntity = postRepo.findById(post_id).get();
            // List <CommentModel> commentModels = new ArrayList<>();
            // for( CommentEntity commentEntity : postEntity.getComments() )
            //     commentModels.add(service.CommentEntity_To_CommentModel(commentEntity));

            // return commentModels;

            Optional<List<CommentEntity>> cOptional = commentRepo.getcommentposts(post_id);
        List<CommentEntity> commentEntities = cOptional.get();

        List<CommentModel> commentModels = new ArrayList<>();
        for (CommentEntity commentEntity : commentEntities) {
            commentModels.add(service.CommentEntity_To_CommentModel(commentEntity));
        }
        return commentModels;
        }
        else
        return new ArrayList<>();

    }

    @GetMapping(path = "/getreactioncomment")
    public List<ComReactModel> getreaction(@RequestParam Long comment_id){
        CommentEntity commentEntity = new CommentEntity();
        if(commentRepo.findById(comment_id).isPresent()){
            commentEntity = commentRepo.findById(comment_id).get();
            List<ComReactModel> comReactModels=new ArrayList<>();
            for(ComReactEntity comReactEntity : commentEntity.getComment_Reactions())
                comReactModels.add(service.ComReactEntity_To_ComReactModel(comReactEntity));

            return comReactModels;


        }
        else
        return new ArrayList<>();
    }

    
}
