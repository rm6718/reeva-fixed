import com.ironyard.inspo.dto.BollywoodSongs;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by reevamerchant on 10/28/16.
 */
public class TestApi {

    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<BollywoodSongs[]> respEntity = restTemplate.exchange("http://api.cinemalytics.in/v2/song/latest-songs/?auth_token=E1F44609FDE7F5E9190CBBECE89B84E2",
                HttpMethod.GET, entity, BollywoodSongs[].class);
        BollywoodSongs[] songs = respEntity.getBody();
        System.out.println(songs);
    }

}


