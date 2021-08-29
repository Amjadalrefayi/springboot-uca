package com.ucc.application.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ucc.application.Models.StoryModel;


import org.springframework.stereotype.Service;



@Service
public class StoryService {

    public List<StoryModel> MustDeleted(List<StoryModel> sList){

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY@hh:mm:ss aa");
        String dateString=sdf.format(new Date());
        String day = dateString.substring(0,2);
        
        String hour=dateString.substring(11,13);
        String month  =dateString.substring(3,5);
        String year  =dateString.substring(6,10);

      
        String min = dateString.substring(14,16);
        String sec = dateString.substring(17,19);
        String PM_AM= dateString.substring(20,dateString.length());

        int nowday = Integer.valueOf(day);
        int nowhour=Integer.valueOf(hour);
        int nowmin = Integer.valueOf(min);
        int nowsec = Integer.valueOf(sec);

        System.out.println("day "+ day);
        System.out.println("hour "+ hour);
        System.out.println("sec "+ sec);
        System.out.println("min "+ min);
        System.out.println("pm_AM  "+ PM_AM);
        System.out.println("year  "+ year);
        System.out.println("month  "+ month);

        List<StoryModel> storyModels = new ArrayList<>();

        for(StoryModel storyModel : sList){

            int storyDay = Integer.valueOf(storyModel.getCreated_at().substring(0,2));
            int storyhour = Integer.valueOf(storyModel.getCreated_at().substring(11,13));
            int storymin = Integer.valueOf(storyModel.getCreated_at().substring(14,16));
            int storySec = Integer.valueOf(storyModel.getCreated_at().substring(17,19));

            String PM_AMStory= storyModel.getCreated_at().substring(20,storyModel.getCreated_at().length());
            if(storyModel.getCreated_at().substring(6,10).equals(year)){

                if(storyModel.getCreated_at().substring(3,5).equals(month)){

                    if(!storyModel.getCreated_at().substring(0,2).equals(day)){
                        
                        if(!(nowday==storyDay+1))
                            storyModels.add(storyModel);

                        else{
                            System.out.println("hiiiiiiiiii");
                            System.out.println(PM_AMStory);
                            if(nowhour > storyhour && PM_AMStory.equals(PM_AM))
                                storyModels.add(storyModel);

                            if(nowhour == storyhour&& PM_AMStory.equals(PM_AM)){
                                if(nowmin > storymin)
                                storyModels.add(storyModel);
                                else if(nowmin == storymin){
                                    if(nowsec >= storySec)
                                        storyModels.add(storyModel);
                                }
                            }
                        }


                    }
                }
                else
                    storyModels.add(storyModel);

            }
            else
                storyModels.add(storyModel);

        }


        return storyModels;


    }
    
}
