package com.ironyard.inspo.controller;

import com.ironyard.inspo.dto.BollywoodSongs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by reevamerchant on 10/28/16.
 */
@RestController
public class BollywoodSongsController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/service/bwsongs", method = RequestMethod.GET)
    public Iterable<BollywoodSongs> list(@RequestParam(value = "filter", required = false)String filter){
        log.debug("Request to list songs started.");
        RestTemplate restTemplate = new RestTemplate();
       // BollywoodSongs[] songs = restTemplate.getForObject("http://api.cinemalytics.in/v2/song/id/93508a12/?auth_token=E1F44609FDE7F5E9190CBBECE89B84E2", BollywoodSongs[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<BollywoodSongs[]> respEntity = restTemplate.exchange("http://api.cinemalytics.in/v2/song/latest-songs/?auth_token=E1F44609FDE7F5E9190CBBECE89B84E2",
                HttpMethod.GET, entity, BollywoodSongs[].class);
        BollywoodSongs[] songs = respEntity.getBody();


        log.info(songs.toString());
        log.debug("Fetch song complete.");
        List<BollywoodSongs> foundAllList = Arrays.asList(songs);
        List<BollywoodSongs> filteredList = new ArrayList<>();

        // only return songs that start with parameter name
        if(filter != null){
            // filter the list
            for(BollywoodSongs aSong: foundAllList){
                if(aSong.getTitle().startsWith(filter)){
                    filteredList.add(aSong);
                }
            }
        }else{
            // just return all
            filteredList = foundAllList;
        }
        return filteredList;
    }

}


