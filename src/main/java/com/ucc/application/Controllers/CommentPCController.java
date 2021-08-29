package com.ucc.application.Controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.ComReactPCEntity;
import com.ucc.application.Entities.CommnetPCEntity;
import com.ucc.application.Entities.PostComuEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.ComReactPCModel;
import com.ucc.application.Models.CommentPCModel;
import com.ucc.application.Repositories.ComReactPCRepo;
import com.ucc.application.Repositories.CommentPCRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;
import com.ucc.application.Repositories.PostComRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ucc/commentsPC")
public class CommentPCController {
    @Autowired
    PostComRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentPCRepo commentRepo;
    @Autowired
    FormService service;
    @Autowired
    ComReactPCRepo comReactRepo;

    @PostMapping(path = "/addcomment")
    public CommentPCModel addcomment(@RequestParam Long user_id, @RequestParam Long post_id, @RequestParam String value) {
        CommnetPCEntity commentEntity = new CommnetPCEntity();
        if (postRepo.findById(post_id).isPresent() && userRepo.findById(user_id).isPresent()) {

            commentEntity.setUserEntity(userRepo.findById(user_id).get());
            commentEntity.setPostComuEntity(postRepo.findById(post_id).get());
            commentEntity.setComment_Value(value);
            commentEntity.setComment_Replaies(new ArrayList<>());
            commentEntity.setComment_Reactions(new ArrayList<>());
            commentEntity = commentRepo.save(commentEntity);
            return service.CommentPCEntity_To_CommentPCModel(commentEntity);

        } else
            return null;
    }

    @PostMapping(path = "/delete")
    public Boolean deleteComment(@RequestParam Long user_id, @RequestParam Long post_id,
            @RequestParam Long comment_id) {

        if (!userRepo.findById(user_id).isPresent() || !commentRepo.findById(comment_id).isPresent()
                || !postRepo.findById(post_id).isPresent())
            return false;

        CommnetPCEntity commentEntity = commentRepo.findById(comment_id).get();
        UserEntity userEntity = userRepo.findById(user_id).get();
        PostComuEntity postEntity = postRepo.findById(post_id).get();

        if (postEntity.getComments().contains(commentEntity)) {

            if (userEntity.getUser_PostCom().contains(postEntity)) {
                postEntity.getComments().remove(commentEntity);
                userEntity = commentEntity.getUserEntity();
                userEntity.getUser_CommentsPC().remove(commentEntity);
                commentRepo.deleteById(commentRepo.findById(comment_id).get().getId());
                postRepo.save(postEntity);
                userRepo.save(userEntity);
                return true;
            } else {
                if (userEntity.getUser_CommentsPC().contains(commentEntity)) {
                    postEntity.getComments().remove(commentEntity);
                    userEntity = commentEntity.getUserEntity();
                    userEntity.getUser_CommentsPC().remove(commentEntity);
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
        ComReactPCEntity comReactEntity = new ComReactPCEntity();
        if(!userRepo.findById(user_id).isPresent() || !commentRepo.findById(comment_id).isPresent())
            return false;

        for(int i=0; i< userRepo.findById(user_id).get().getUser_ComReactsPC().size() ; i++){

            if(userRepo.findById(user_id).get().getUser_ComReactsPC().get(i).getCommnetPCEntity().equals(commentRepo.findById(comment_id).get())){
                
                comReactRepo.deleteComReact(userRepo.findById(user_id).get().getUser_ComReactsPC().get(i).getId());
                   return false;
      
                }
        }

        comReactEntity.setUserEntity(userRepo.findById(user_id).get());
        comReactEntity.setCommnetPCEntity(commentRepo.findById(comment_id).get());
        comReactRepo.save(comReactEntity);
        return true;

    }

    @GetMapping(path = "/getpostcomment")
    public List <CommentPCModel> getcomments(@RequestParam Long post_id){

        
        //PostEntity postEntity = new PostEntity();
        if(postRepo.findById(post_id).isPresent())
        {
            // postEntity = postRepo.findById(post_id).get();
            // List <CommentModel> commentModels = new ArrayList<>();
            // for( CommentEntity commentEntity : postEntity.getComments() )
            //     commentModels.add(service.CommentEntity_To_CommentModel(commentEntity));

            // return commentModels;

            Optional<List<CommnetPCEntity>> cOptional = commentRepo.getcommentposts(post_id);
        List<CommnetPCEntity> commentEntities = cOptional.get();

        List<CommentPCModel> commentModels = new ArrayList<>();
        for (CommnetPCEntity commentEntity : commentEntities) {
            commentModels.add(service.CommentPCEntity_To_CommentPCModel(commentEntity));
        }
        return commentModels;
        }
        else
        return new ArrayList<>();

    }

    @GetMapping(path = "/getreactioncomment")
    public List<ComReactPCModel> getreaction(@RequestParam Long comment_id){
        CommnetPCEntity commentEntity = new CommnetPCEntity();
        if(commentRepo.findById(comment_id).isPresent()){
            commentEntity = commentRepo.findById(comment_id).get();
            List<ComReactPCModel> comReactModels=new ArrayList<>();
            for(ComReactPCEntity comReactPCEntity : commentEntity.getComment_Reactions())
                comReactModels.add(service.ComReactPCEntity_To_ComReactPCModel(comReactPCEntity));

            return comReactModels;
        }
        else
        return new ArrayList<>();
    }

}
