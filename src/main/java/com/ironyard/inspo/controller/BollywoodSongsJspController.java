package com.ironyard.inspo.controller;

import com.ironyard.inspo.dto.BollywoodSongs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by reevamerchant on 10/28/16.
 */
@Controller
public class BollywoodSongsJspController {

    @RequestMapping(value = "/inspo/songs", method = RequestMethod.GET)
    public String list(Map<String, Object> model){
        RestTemplate restTemplate = new RestTemplate();
        BollywoodSongs[] songs = restTemplate.getForObject("http://api.cinemalytics.in/v2/song/latest-songs/?auth_token=E1F44609FDE7F5E9190CBBECE89B84E2", BollywoodSongs[].class);
        List<BollywoodSongs> foundAllList = Arrays.asList(songs);
        List<BollywoodSongs> filteredList = new ArrayList<>();

        // only return teams that start with parameter name
//        if(filter != null){
//            // filter the list
//            for(BollywoodSongs aSong: foundAllList){
//                if(aSong.getTitle().startsWith(filter)){
//                    filteredList.add(aSong);
//                }
//            }
//        }else{
//            // just return all
//            filteredList = foundAllList;
//        }

        model.put("songs", foundAllList);
        return "inspo";
    }

}


