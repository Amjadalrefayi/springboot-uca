package com.ucc.application.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.ucc.application.Entities.CommnetPCEntity;
import com.ucc.application.Entities.PostComuEntity;
import com.ucc.application.Entities.ReplayPCEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.ReplayPCModel;
import com.ucc.application.Repositories.CommentPCRepo;
import com.ucc.application.Repositories.PostComRepo;
import com.ucc.application.Repositories.ReplayPcRepo;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ucc/replaiesPC")
public class ReplayPCController {

    @Autowired
    PostComRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentPCRepo commentRepo;
    @Autowired
    ReplayPcRepo replayRepo;
    @Autowired
    FormService service;

    @PostMapping(path = "/addreplay")
    public ReplayPCModel addcomment(@RequestParam Long user_id, @RequestParam Long post_id,
            @RequestParam Long comment_id, @RequestParam String value) {
        ReplayPCEntity replayEntity = new ReplayPCEntity();
        if (postRepo.findById(post_id).isPresent() && userRepo.findById(user_id).isPresent()
                && commentRepo.findById(comment_id).isPresent()) {

            replayEntity.setCommnetPCEntity(commentRepo.findById(comment_id).get());
            replayEntity.setReplay_Value(value);
            replayEntity.setUserEntity(userRepo.findById(user_id).get());
            replayEntity.setPostComuEntity(postRepo.findById(post_id).get());
            replayEntity = replayRepo.save(replayEntity);
            return service.ReplayPCEntity_To_ReplayPCModel(replayEntity);
        } else
            return null;
    }

    @PostMapping(path = "/delete")
    public Boolean deleteReplay(@RequestParam Long user_id, @RequestParam Long post_id, @RequestParam Long comment_id,
            @RequestParam Long replay_id) {

        if (!userRepo.findById(user_id).isPresent() || !commentRepo.findById(comment_id).isPresent()
                || !postRepo.findById(post_id).isPresent() || !replayRepo.findById(replay_id).isPresent())
            return false;

        CommnetPCEntity commentEntity = commentRepo.findById(comment_id).get();
        UserEntity userEntity = userRepo.findById(user_id).get();
        PostComuEntity postEntity = postRepo.findById(post_id).get();
        ReplayPCEntity replayEntity = replayRepo.findById(replay_id).get();

        if (postEntity.getReplaies().contains(replayEntity)
                && commentEntity.getComment_Replaies().contains(replayEntity)) {

            if (userEntity.getUser_PostCom().contains(postEntity)) {
                replayRepo.deleteReplay(replayEntity.getId());
                return true;
            } else {
                if (userEntity.getUser_ReplayiesPC().contains(replayEntity)) {
                    replayRepo.deleteReplay(replayEntity.getId());
                    return true;
                } else
                    return false;
            }

        } else
            return false;
    }

    @GetMapping(path = "/getreplayepost")
    public List<ReplayPCModel> getreplayepost(@RequestParam Long comment_id) {
        CommnetPCEntity commnetPCEntity = new CommnetPCEntity();
        if (commentRepo.findById(comment_id).isPresent()) {
            commnetPCEntity = commentRepo.findById(comment_id).get();
            List<ReplayPCModel> replayModels = new ArrayList<>();
            for (ReplayPCEntity replayEntity : commnetPCEntity.getComment_Replaies())
                replayModels.add(service.ReplayPCEntity_To_ReplayPCModel(replayEntity));

            return replayModels;

        }
        return new ArrayList<>();

    }

}
