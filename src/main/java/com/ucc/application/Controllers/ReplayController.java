package com.ucc.application.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.CommentEntity;
import com.ucc.application.Entities.PostEntity;
import com.ucc.application.Entities.ReplayEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.ReplayModel;
import com.ucc.application.Repositories.CommentRepo;
import com.ucc.application.Repositories.PostRepo;
import com.ucc.application.Repositories.ReplayRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ucc/replaies")
public class ReplayController {

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ReplayRepo replayRepo;
    @Autowired
    FormService service;

    @PostMapping(path = "/addreplay")
    public ReplayModel addcomment(@RequestParam Long user_id,@RequestParam Long post_id, @RequestParam Long comment_id, @RequestParam String value) {
        ReplayEntity replayEntity = new ReplayEntity();
        if (postRepo.findById(post_id).isPresent() && userRepo.findById(user_id).isPresent() && commentRepo.findById(comment_id).isPresent() ) {

            replayEntity.setCommentEntity(commentRepo.findById(comment_id).get());
            replayEntity.setReplay_Value(value);
            replayEntity.setUserEntity(userRepo.findById(user_id).get());
            replayEntity.setPostEntity(postRepo.findById(post_id).get());
            replayEntity = replayRepo.save(replayEntity);
             return service.ReplayEntity_To_ReplayModel(replayEntity);
        } else
            return null;
    }

    @PostMapping(path = "/delete")
    public Boolean deleteReplay(@RequestParam Long user_id, @RequestParam Long post_id,
            @RequestParam Long comment_id , @RequestParam Long replay_id) {

        if (!userRepo.findById(user_id).isPresent() || !commentRepo.findById(comment_id).isPresent()
                || !postRepo.findById(post_id).isPresent() || !replayRepo.findById(replay_id).isPresent())
            return false;

        CommentEntity commentEntity = commentRepo.findById(comment_id).get();
        UserEntity userEntity = userRepo.findById(user_id).get();
        PostEntity postEntity = postRepo.findById(post_id).get();
        ReplayEntity replayEntity = replayRepo.findById(replay_id).get();

        if (postEntity.getReplaies().contains(replayEntity) && commentEntity.getComment_Replaies().contains(replayEntity)) {

            if (userEntity.getUser_Posts().contains(postEntity)) {
                replayRepo.deleteReplay(replayEntity.getId());
                return true;
            } else {
                if (userEntity.getUser_Replayies().contains(replayEntity)) {
                    replayRepo.deleteReplay(replayEntity.getId());
                    return true;
                } else
                    return false;
            }

        } else
            return false;
    }

    @GetMapping(path = "/getreplayepost")
    public List<ReplayModel> getreplayepost(@RequestParam Long comment_id){
        if(commentRepo.findById(comment_id).isPresent()){
            Optional<List<ReplayEntity>> rOptional = replayRepo.getreplayposts(comment_id);
            List<ReplayEntity> replayEntities = rOptional.get();
            List <ReplayModel> replayModels = new ArrayList<>();
            for (ReplayEntity replayEntity : replayEntities) {
                replayModels.add(service.ReplayEntity_To_ReplayModel(replayEntity));
            }
            return replayModels;

        }
        return new ArrayList<>();
        
    }

 
}
