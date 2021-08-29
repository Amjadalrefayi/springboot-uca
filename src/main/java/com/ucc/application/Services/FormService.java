package com.ucc.application.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ucc.application.Entities.ComReactEntity;
import com.ucc.application.Entities.ComReactPCEntity;
import com.ucc.application.Entities.CommentEntity;
import com.ucc.application.Entities.CommnetPCEntity;
import com.ucc.application.Entities.CommunityEntity;
import com.ucc.application.Entities.LikeEntity;
import com.ucc.application.Entities.LikePCEntity;
import com.ucc.application.Entities.LoveEntity;
import com.ucc.application.Entities.PostComuEntity;
import com.ucc.application.Entities.PostEntity;
import com.ucc.application.Entities.ReplayEntity;
import com.ucc.application.Entities.ReplayPCEntity;
import com.ucc.application.Entities.StoryEntity;
import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.ComReactModel;
import com.ucc.application.Models.ComReactPCModel;
import com.ucc.application.Models.CommentModel;
import com.ucc.application.Models.CommentPCModel;
import com.ucc.application.Models.CommunityModel;
import com.ucc.application.Models.LikeModel;
import com.ucc.application.Models.LikePCModel;
import com.ucc.application.Models.LoveModel;
import com.ucc.application.Models.PostModel;
import com.ucc.application.Models.PostPCModel;
import com.ucc.application.Models.ReplayModel;
import com.ucc.application.Models.ReplayPCModel;
import com.ucc.application.Models.StoryModel;
import com.ucc.application.Models.UserModel;
import com.ucc.application.Models.UserStoryModel;
import com.ucc.application.Repositories.CommunityRepo;
import com.ucc.application.Repositories.StoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    CommunityRepo communityRepo;
    @Autowired
    StoryRepo storyRepo;

    public UserEntity UserModel_To_UserEntity(UserModel userModel) {
        UserEntity response = new UserEntity();

        response.setFirstName(userModel.getFirstName());
        response.setLastName(userModel.getLastName());
        response.setUserName(userModel.getFirstName() + " " + userModel.getLastName());
        response.setEmail(userModel.getEmail());
        response.setPassword(userModel.getPassword());
        response.setUniversity(userModel.getUniversity());
        response.setSpecialize(userModel.getSpecialize());
        response.setAge(userModel.getAge());
        response.setStudy_Year(userModel.getStudy_Year());
        response.setOnline(true);
        response.setCreated_At(new Date());
        response.setImage(userModel.getImage());
        response.setCover(userModel.getCover());
        response.setUser_Likes(new ArrayList<>());
        response.setUser_Comments(new ArrayList<>());
        response.setUser_Posts(new ArrayList<>());
        response.setUser_Replayies(new ArrayList<>());
        response.setUser_stories(new ArrayList<>());
        response.setUser_Loves(new ArrayList<>());
        response.setUser_PostCom(new ArrayList<>());
        response.setUser_CommentsPC(new ArrayList<>());
        response.setUser_LikesPC(new ArrayList<>());
        response.setUser_ComReactsPC(new ArrayList<>());
        String name = userModel.getUniversity() + "_" + userModel.getSpecialize();
        System.out.println(name);
        System.out.println("HIIIIIIIIIIIII");
        response.setCommunityEntity(communityRepo.findByName(name).get());
        System.out.println("TMMMMMMMMMMM");

        return response;

    }

    public UserModel UserEntity_To_UserModel(UserEntity userEntity) throws ParseException {

        List<PostModel> postmodel = new ArrayList<>();
        List<PostEntity> postentity = new ArrayList<>();
        postentity = userEntity.getUser_Posts();
        for (PostEntity postEntity2 : postentity) {
            postmodel.add(PostEntity_To_PostModel(postEntity2));
        }

        List<CommentModel> commentmodel = new ArrayList<>();
        List<CommentEntity> commentEntities = new ArrayList<>();
        commentEntities = userEntity.getUser_Comments();

        for (CommentEntity commentEntity : commentEntities) {
            commentmodel.add(CommentEntity_To_CommentModel(commentEntity));
        }

        List<LikeModel> likeModels = new ArrayList<>();
        List<LikeEntity> likeEntities = new ArrayList<>();
        likeEntities = userEntity.getUser_Likes();

        for (LikeEntity likeEntity : likeEntities) {
            likeModels.add(LikeEntity_To_LikeModel(likeEntity));
        }

        List<ReplayModel> replayModels = new ArrayList<>();
        List<ReplayEntity> replayEntities = new ArrayList<>();
        replayEntities = userEntity.getUser_Replayies();
        for (ReplayEntity replayEntity : replayEntities) {
            replayModels.add(ReplayEntity_To_ReplayModel(replayEntity));

        }

        List<StoryModel> storyModels = new ArrayList<>();
        List<StoryEntity> storyEntities = new ArrayList<>();
        storyEntities = userEntity.getUser_stories();
        for (StoryEntity storyEntity : storyEntities) {
            storyModels.add(StoryEntity_To_StoryModel(storyEntity));
        }

        List<LoveModel> loveModels = new ArrayList<>();

        List<LoveEntity> loveEntities = new ArrayList<>();
        loveEntities = userEntity.getUser_Loves();
        for (LoveEntity loveEntity2 : loveEntities) {
            loveModels.add(LoveEntity_To_LoveModel(loveEntity2));

        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY@hh:mm:ss aa");
        String dateString = sdf.format(userEntity.getCreated_At());

        UserModel response = new UserModel();
        response.setUser_id(userEntity.getId());
        response.setFirstName(userEntity.getFirstName());
        response.setLastName(userEntity.getLastName());
        response.setEmail(userEntity.getEmail());
        response.setUserName(userEntity.getUserName());
        response.setPassword(userEntity.getPassword());
        response.setUniversity(userEntity.getUniversity());
        response.setSpecialize(userEntity.getSpecialize());
        response.setAge(userEntity.getAge());
        response.setStudy_Year(userEntity.getStudy_Year());
        response.setCover(userEntity.getCover());
        response.setImage(userEntity.getImage());
        response.setCreated_At(dateString);
        response.setOnline(userEntity.getOnline());
        response.setLikes(likeModels);
        response.setComments(commentmodel);
        response.setPosts(postmodel);
        response.setOnline(true);
        response.setReplaies(replayModels);
        response.setStories(storyModels);
        response.setLoves(loveModels);
        response.setCommunity_id(userEntity.getCommunityEntity().getId());
        return response;
    }

    public PostModel PostEntity_To_PostModel(PostEntity postEntity) {
        List<CommentModel> commentModels = new ArrayList<>();
        List<CommentEntity> commentEntities = new ArrayList<>();
        commentEntities = postEntity.getComments();

        for (CommentEntity commentEntity : commentEntities) {
            commentModels.add(CommentEntity_To_CommentModel(commentEntity));

        }

        List<String> UserName = new ArrayList<>();

        List<LikeEntity> likeEntities = new ArrayList<>();
        likeEntities = postEntity.getPost_Likes();
        for (LikeEntity likeEntity : likeEntities) {
            UserName.add(likeEntity.getUserEntity().getUserName());

        }
        List<ReplayModel> replayModels = new ArrayList<>();
        List<ReplayEntity> replayEntities = new ArrayList<>();
        replayEntities = postEntity.getReplaies();
        for (ReplayEntity replayEntity : replayEntities) {
            replayModels.add(ReplayEntity_To_ReplayModel(replayEntity));

        }

        List<String> UserNamelove = new ArrayList<>();

        List<LoveEntity> loveEntities = new ArrayList<>();
        loveEntities = postEntity.getPost_Loves();
        for (LoveEntity loveEntity2 : loveEntities) {
            UserNamelove.add(loveEntity2.getUserEntity().getUserName());

        }

        PostModel response = new PostModel();
        response.setId(postEntity.getId());
        response.setTitle(postEntity.getTitle());
        response.setPost_Value(postEntity.getPost_Value());
        response.setAttachment(postEntity.getAttachment());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY@hh:mm:ss aa");
        String dateString = sdf.format(postEntity.getCreated_At());

        response.setCreated_At(dateString);
        response.setPost_Value(postEntity.getPost_Value());
        response.setUserImage(postEntity.getUserEntity().getImage());
        response.setLikeCount(postEntity.getPost_Likes().size());
        response.setCommnetCount(postEntity.getComments().size() + postEntity.getReplaies().size());
        response.setUsers_Make_like(UserName);
        response.setCommentInfo(commentModels);
        response.setUserName(postEntity.getUserEntity().getUserName());
        response.setReplaiesInfo(replayModels);
        response.setUsers_Make_loveReaction(UserNamelove);
        response.setLoveCount(postEntity.getPost_Loves().size());

        return response;

    }

    public PostPCModel PostPCEntity_To_PostPCModel(PostComuEntity postEntity) {
        List<CommentPCModel> commentModels = new ArrayList<>();
        List<CommnetPCEntity> commentEntities = new ArrayList<>();
        commentEntities = postEntity.getComments();

        for (CommnetPCEntity commentEntity : commentEntities) {
            commentModels.add(CommentPCEntity_To_CommentPCModel(commentEntity));

        }


        List<String> UserName = new ArrayList<>();

        List<LikePCEntity> likeEntities = new ArrayList<>();
        likeEntities = postEntity.getPost_Likes();
        for (LikePCEntity likeEntity : likeEntities) {
            UserName.add(likeEntity.getUserEntity().getUserName());

        }
        List<ReplayPCModel> replayModels = new ArrayList<>();
        List<ReplayPCEntity> replayEntities = new ArrayList<>();
        replayEntities = postEntity.getReplaies();
        for (ReplayPCEntity replayEntity : replayEntities) {
            replayModels.add(ReplayPCEntity_To_ReplayPCModel(replayEntity));

        }

        PostPCModel response = new PostPCModel();
        response.setId(postEntity.getId());
        response.setTitle(postEntity.getTitle());
        response.setPost_Value(postEntity.getPost_Value());
        response.setAttachment(postEntity.getAttachment());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY@hh:mm:ss aa");
        String dateString = sdf.format(postEntity.getCreated_At());
        response.setCreated_At(dateString);
        response.setPost_Value(postEntity.getPost_Value());
        response.setUserImage(postEntity.getUserEntity().getImage());
        response.setLikeCount(postEntity.getPost_Likes().size());
        response.setCommnetCount(postEntity.getComments().size() + postEntity.getReplaies().size());
        response.setUsers_Make_like(UserName);
        response.setCommentInfo(commentModels);
        response.setUserName(postEntity.getUserEntity().getUserName());
        response.setReplaiesInfo(replayModels);
        return response;

    }

    public CommentModel CommentEntity_To_CommentModel(CommentEntity commentEntity) {
        CommentModel commentModel = new CommentModel();
        List<ComReactModel> comReactModels = new ArrayList<>();
        List<ComReactEntity> comReactEntities = new ArrayList<>();
        comReactEntities = commentEntity.getComment_Reactions();

            for (ComReactEntity comReactEntity : comReactEntities) {
                
                comReactModels.add(ComReactEntity_To_ComReactModel(comReactEntity));
            }

        
        List<ReplayModel>replayModels = new ArrayList<>();
        List<ReplayEntity> replayEntities = new ArrayList<>();
        replayEntities = commentEntity.getComment_Replaies();
        for( ReplayEntity replayEntity : replayEntities)
        replayModels.add(ReplayEntity_To_ReplayModel(replayEntity));


        commentModel.setUserName(commentEntity.getUserEntity().getUserName());
        commentModel.setUserImg(commentEntity.getUserEntity().getImage());
        commentModel.setValue(commentEntity.getComment_Value());
        commentModel.setPost_id(commentEntity.getPostEntity().getId());
        commentModel.setComment_id(commentEntity.getId());
        commentModel.setComReacts(comReactModels);
        commentModel.setReplaies(replayModels);
        commentModel.setReactions(comReactModels.size());
        commentModel.setReplaiesCount(replayModels.size());
        return commentModel;
    }

    public CommentPCModel CommentPCEntity_To_CommentPCModel(CommnetPCEntity commentEntity) {
        CommentPCModel commentModel = new CommentPCModel();
        List<ComReactPCModel> comReactModels = new ArrayList<>();
        List<ComReactPCEntity> comReactEntities = new ArrayList<>();
        comReactEntities = commentEntity.getComment_Reactions();
        for (ComReactPCEntity comReactEntity : comReactEntities) {
            comReactModels.add(ComReactPCEntity_To_ComReactPCModel(comReactEntity));
        }

        List<ReplayPCModel>replayModels = new ArrayList<>();
        List<ReplayPCEntity> replayEntities = new ArrayList<>();
        replayEntities = commentEntity.getComment_Replaies();
        for( ReplayPCEntity replayEntity : replayEntities)
        replayModels.add(ReplayPCEntity_To_ReplayPCModel(replayEntity));

        commentModel.setUserName(commentEntity.getUserEntity().getUserName());
        commentModel.setUserImg(commentEntity.getUserEntity().getImage());
        commentModel.setValue(commentEntity.getComment_Value());
        commentModel.setPost_id(commentEntity.getPostComuEntity().getId());
        commentModel.setComment_id(commentEntity.getId());
        commentModel.setComReacts(comReactModels);
        commentModel.setReactions(comReactModels.size());
        commentModel.setReplaiesCount(replayModels.size());
        return commentModel;
    }

    public LikeModel LikeEntity_To_LikeModel(LikeEntity likeEntity) {
        LikeModel likeModel = new LikeModel();
        likeModel.setPost_id(likeEntity.getPostEntity().getId());
        likeModel.userName(likeEntity.getUserEntity().getUserName());
        return likeModel;
    }

    public LikePCModel LikePCEntity_To_LikePCModel(LikePCEntity likeEntity) {
        LikePCModel likeModel = new LikePCModel();
        likeModel.setPost_id(likeEntity.getPostComuEntity().getId());
        likeModel.userName(likeEntity.getUserEntity().getUserName());
        return likeModel;
    }

    public LoveModel LoveEntity_To_LoveModel(LoveEntity loveEntity) {
        LoveModel loveModel = new LoveModel();
        loveModel.setPost_id(loveEntity.getPostEntity().getId());
        loveModel.userName(loveEntity.getUserEntity().getUserName());
        return loveModel;
    }

    public UserEntity UserModel_Update(UserModel userModel, UserEntity userEntity) {
        UserEntity response = new UserEntity();

        response.setFirstName(userModel.getFirstName());
        response.setLastName(userModel.getLastName());
        response.setUserName(userModel.getFirstName() + " " + userModel.getLastName());
        response.setEmail(userModel.getEmail());
        response.setPassword(userModel.getPassword());
        response.setUniversity(userModel.getUniversity());
        response.setSpecialize(userModel.getSpecialize());
        response.setAge(userModel.getAge());
        response.setStudy_Year(userModel.getStudy_Year());
        response.setOnline(true);
        response.setCreated_At(userEntity.getCreated_At());
        response.setImage(userModel.getImage());
        response.setCover(userModel.getCover());
        response.setUser_Likes(userEntity.getUser_Likes());
        response.setUser_Comments(userEntity.getUser_Comments());
        response.setUser_Posts(userEntity.getUser_Posts());

        return response;

    }

    public ReplayModel ReplayEntity_To_ReplayModel(ReplayEntity replayEntity) {
        ReplayModel replayModel = new ReplayModel();
        replayModel.setComment_id(replayEntity.getCommentEntity().getId());
        replayModel.setPost_id(replayEntity.getPostEntity().getId());
        replayModel.setUserImg(replayEntity.getUserEntity().getImage());
        replayModel.setUserName(replayEntity.getUserEntity().getUserName());
        replayModel.setValue(replayEntity.getReplay_Value());
        replayModel.setReplay_id(replayEntity.getId());
        return replayModel;
    }

    public ReplayPCModel ReplayPCEntity_To_ReplayPCModel(ReplayPCEntity replayEntity) {
        ReplayPCModel replayModel = new ReplayPCModel();
        replayModel.setComment_id(replayEntity.getCommnetPCEntity().getId());
        replayModel.setPost_id(replayEntity.getPostComuEntity().getId());
        replayModel.setUserImg(replayEntity.getUserEntity().getImage());
        replayModel.setUserName(replayEntity.getUserEntity().getUserName());
        replayModel.setValue(replayEntity.getReplay_Value());
        replayModel.setReplay_id(replayEntity.getId());
        return replayModel;
    }

    public StoryModel StoryEntity_To_StoryModel(StoryEntity storyEntity) throws ParseException {
        StoryModel storyModel = new StoryModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY@hh:mm:ss aa");
        String dateString = sdf.format(storyEntity.getCreated_At());
        // Date Created_at=new
        // SimpleDateFormat("dd/MM/YYYY@hh:mm:ss").parse(dateString);
        storyModel.setUserName(storyEntity.getUserEntity().getUserName());
        storyModel.setUserImage(storyEntity.getUserEntity().getImage());
        storyModel.setText(storyEntity.getText());
        storyModel.setCreated_at(dateString);
        storyModel.setId(storyEntity.getId());
        storyModel.setImage(storyEntity.getImage());
        return storyModel;

    }

    public ComReactModel ComReactEntity_To_ComReactModel(ComReactEntity comReactEntity) {
        ComReactModel comReactModel = new ComReactModel();
        comReactModel.setUserImage(comReactEntity.getUserEntity().getImage());
        comReactModel.setUserName(comReactEntity.getUserEntity().getUserName());
        comReactModel.setComment_id(comReactEntity.getCommentEntity().getId());
        return comReactModel;

    }

    public ComReactPCModel ComReactPCEntity_To_ComReactPCModel(ComReactPCEntity comReactEntity) {
        ComReactPCModel comReactModel = new ComReactPCModel();
        comReactModel.setUserImage(comReactEntity.getUserEntity().getImage());
        comReactModel.setUserName(comReactEntity.getUserEntity().getUserName());
        comReactModel.setComment_id(comReactEntity.getCommnetPCEntity().getId());
        return comReactModel;

    }

    public CommunityModel CommunityModel_To_CommunityEntity(CommunityEntity communityEntity) {

        CommunityModel communityModel = new CommunityModel();
        communityModel.setDescreption(communityEntity.getDescription());
        communityModel.setImage(communityEntity.getImage());
        communityModel.setName(communityEntity.getName());
        List<String> userNames = new ArrayList<>();
        for (UserEntity userEntity : communityEntity.getUsers())
            userNames.add(userEntity.getUserName());
        communityModel.setUserName(userNames);
        return communityModel;

    }

    public UserStoryModel UserStoryModelform(UserEntity userEntity) throws ParseException{

        List<StoryModel> storyModels = new ArrayList<>();
        UserStoryModel userStoryModel = new UserStoryModel();
        for(StoryEntity storyEntity : userEntity.getUser_stories())
            storyModels.add(StoryEntity_To_StoryModel(storyEntity));
        userStoryModel.setStories(storyModels);
        userStoryModel.setUserImg(userEntity.getImage());
        userStoryModel.setUserName(userEntity.getUserName());
        return userStoryModel;

    }

    public List<StoryModel> getAllUserStories() throws ParseException{
        List<StoryModel> storyModels = new ArrayList<>();
        
        for(StoryEntity storyEntity : storyRepo.getAllUserStory().get()){
            storyModels.add(StoryEntity_To_StoryModel(storyEntity));
        }
        return storyModels;
    }

}
