package com.ucc.application.Controllers;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.UserEntity;
import com.ucc.application.Models.UserModel;
import com.ucc.application.Repositories.UserRepo;
import com.ucc.application.Services.FormService;
import com.ucc.application.Services.GenerateCode;
import com.ucc.application.Services.SendEmailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ucc/users")
public class UserController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    FormService service;
    @Autowired
    SendEmailService sendEmailService;
    @Autowired
    GenerateCode generateCode;

    @PostMapping(path = "/signup")
    public UserModel signup(@RequestBody UserModel userModel) throws ParseException
    {
        UserEntity respoEntity = new UserEntity();
        if(userRepo.findByEmail(userModel.getEmail()).isPresent())
        {
            userModel.setUser_id(Long.valueOf(-1));
            userModel.setUserName("Email Already Exists");
            return userModel;
        }
        else{
            respoEntity = service.UserModel_To_UserEntity(userModel);
            respoEntity = userRepo.save(respoEntity);
            return userModel = service.UserEntity_To_UserModel(respoEntity);
        }
    }

    @GetMapping(path = "/signin")
    public UserModel singin(@RequestParam String email , @RequestParam String password ) throws ParseException
    {
        UserModel respons = new UserModel();
        if(userRepo.findByEmail(email).isEmpty())
        {       
            respons.setUser_id(Long.valueOf(-1));
            respons.setUserName("Email Not Found");
            return respons;
        }
        else{
            Optional<UserEntity> uOptional = userRepo.findByEmail(email);
            if(uOptional.get().getPassword().equals(password))
                return service.UserEntity_To_UserModel(uOptional.get());
            else{
                respons.setUser_id(Long.valueOf(-1));
                respons.setUserName("Password Incorrect");
                return respons;
            }
        }
    }

    @GetMapping(path="/delete")
    public boolean deleteUser(@RequestParam String email , @RequestParam String password ){
        if(!userRepo.findByEmail(email).isPresent())
            return false;
        else{
            Optional<UserEntity> uOptional = userRepo.findByEmail(email);
            if(uOptional.get().getPassword().equals(password)){
                UserEntity userEntity = userRepo.findByEmail(email).get();
                userRepo.delete(userEntity);
                return true;
            }
            else
                return false;
        }

    }

    @GetMapping(path  = "/search")
    public List<UserModel> searchListByUserName(@RequestParam String username) throws ParseException {

        Optional<List<UserEntity>> userEntitiesOptional=userRepo.search(username);
        List<UserModel> userModels = new ArrayList<>();
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities=userEntitiesOptional.get();
        for (UserEntity userEntity : userEntities) {
            userModels.add(service.UserEntity_To_UserModel(userEntity));
        }

        return userModels;
        
    }

//*******************NOT WORKING YET *****************************
    @PostMapping(path  = "/update")
    public UserModel updateUser(@RequestBody UserModel userModel , @RequestParam Long user_id) throws ParseException {

        UserEntity userEntity = new UserEntity();
        UserEntity newUserEntity = new UserEntity();
        newUserEntity = service.UserModel_To_UserEntity(userModel);
        String old_email = userRepo.findById(user_id).get().getEmail();

        if(userModel.getEmail().equals(old_email))
        {
            userEntity=userRepo.findById(user_id).get();

            newUserEntity.setUser_Posts(userEntity.getUser_Posts());
            newUserEntity.setUser_Comments(userEntity.getUser_Comments());
            newUserEntity.setUser_Likes(userEntity.getUser_Likes());
            newUserEntity.setUser_Replayies(userEntity.getUser_Replayies());

            userEntity = newUserEntity;
            userEntity=userRepo.save(userEntity);
            return service.UserEntity_To_UserModel(userEntity);

        }

        else{
            if(userRepo.findByEmail(userModel.getEmail()).isPresent())
            {
                userModel.setUser_id(Long.valueOf(-1));
                userModel.setUserName("Email Already Exists");
                return userModel;
            }
            else{
                userEntity = service.UserModel_To_UserEntity(userModel);
                userRepo.save(userEntity);
                return userModel;

            }
        }

    }

//**************************************************************** 
    
    @PostMapping(path = "/update/image")
    public boolean updateImage(@RequestParam Long user_id ,@RequestBody UserModel userModel){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            userRepo.updateImage(user_id,userModel.getImage());
            return true;

        }
    }

    @PostMapping(path = "/update/cover")
    public boolean updateCover(@RequestParam Long user_id ,@RequestBody UserModel userModel){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            userRepo.updateCover(user_id,userModel.getCover());
            return true;

        }
    }

    @GetMapping(path = "/update/firstName")
    public boolean updateFirstName(@RequestParam Long user_id ,@RequestParam String firstName){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            userRepo.updatefirstName(user_id,firstName);
            String userName = firstName + " " + userRepo.findById(user_id).get().getLastName();
            userRepo.updateUserName(user_id, userName);

            return true;
        }
    }

    @GetMapping(path = "/update/lastName")
    public boolean updateLastName(@RequestParam Long user_id ,@RequestParam String lastName){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            userRepo.updatelastName(user_id,lastName);
            String userName = userRepo.findById(user_id).get().getFirstName() + " " + lastName; 
            userRepo.updateUserName(user_id, userName);

            return true;
        }
    }

    @GetMapping(path = "/update/age")
    public boolean updateAge(@RequestParam Long user_id ,@RequestParam Integer age){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            userRepo.updateAge(user_id,age);
            return true;
        }
    }

    @GetMapping(path = "/update/studyyear")
    public boolean updateStudyYear(@RequestParam Long user_id ,@RequestParam Integer studyYear){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            userRepo.updateStudyYear(user_id,studyYear);
            return true;
        }
    }

    @GetMapping(path = "/update/password")
    public boolean updatePassword(@RequestParam Long user_id ,@RequestParam String old_password , @RequestParam String new_password){
        if(!userRepo.findById(user_id).isPresent())
        return false;
        else{
            if(userRepo.findById(user_id).get().getPassword().equals(old_password) && !userRepo.findById(user_id).get().getPassword().equals(new_password)){
                userRepo.updatePass(user_id, new_password);
                return true;
            }
        else
            return false;

        }
    }

    @GetMapping(path = "/update/passwordrecovery")
    public boolean updatepasswordrecovery(@RequestParam Long user_id ,@RequestParam String new_password){
        if(!userRepo.findById(user_id).isPresent())
        return false;

        else{
            userRepo.updatePass(user_id, new_password);
            return true;
        }
    }
    
    @GetMapping(path = "/register/security/recover")
    public String SendCodeToEmail(@RequestParam String email){
        if(userRepo.findByEmail(email).isPresent())
        {
            String code = generateCode.generateRandomCode();
            sendEmailService.sendEmail(email, code, "uccBackTeam");
            return code;
        }
        else
            return "Email not Exists";
    }

    @GetMapping(path = "/register/security/confirm")
    public String SendCodeToAnyEmail(@RequestParam String email){

            String code = generateCode.generateRandomCode();
            sendEmailService.sendEmail(email, code, "uccBackTeam");
            return code;
        
   
    }

    @GetMapping(path = "/GetUser")
    public UserModel getUserByEmail(@RequestParam String email) throws ParseException{
        UserModel userModel = new UserModel();
        if(userRepo.findByEmail(email).isPresent())
            return service.UserEntity_To_UserModel(userRepo.findByEmail(email).get());
        else
        {
            userModel.setUser_id(-1L);
            userModel.setEmail("Email Not Found");
            return userModel;
        }
    }

}
