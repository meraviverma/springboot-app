package com.db.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RV00451128 on 7/17/2017.
 */
@Service
public class TopicService {
   private List<Topic> topics=new ArrayList<>(Arrays.asList(
            new Topic("spring","spring framework","spring framework description"),
            new Topic("java","core java","core java description"),
            new Topic("javascript","javascript","javascript description")
   ));
   public List<Topic> getAllTopics(){
       return topics;
   }
   public Topic getTopic(String id){
      return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
   }

    public void addTopic(Topic topic) {
       topics.add(topic);
    }

    public void updateTopic(String id,Topic topic) {

       for(int i=0;i<topics.size();i++){
           Topic t=topics.get(i);
           if(t.getId().equals(id)){
               topics.set(i,topic);
               return;
           }
       }
    }

    public void deleteTopic(String id) {
       topics.removeIf(t->t.getId().equals(id));
    }
}