package app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.stream.Stream;

@RestController
public class Helo {

    @GetMapping
    public String main() {
        return "Hello";
    }

    @GetMapping("/getElectronicData")
    public void getElectronicData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Computer[]> responseEntity =  restTemplate.exchange(
                "http://localhost:8080/api/computers",
                HttpMethod.GET,
                null,
                Computer[].class);

        Stream.of(responseEntity.getBody()).forEach(System.out::println);
    }

    @GetMapping("/deleteElectronicData")
    public void deleteElectronicData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> responseEntity =  restTemplate.exchange(
                "http://localhost:8080/api/computers?id=1",
                HttpMethod.DELETE,
                null,
                Boolean.class);

        System.out.println(Stream.of(responseEntity.getBody()));
    }


    @GetMapping("/addElectronicData")
    public void addElectronicData(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE,"application/json");
        String objToSend = "{\n" +
                "        \"id\": 5,\n" +
                "        \"ddrType\": \"DDR5\",\n" +
                "        \"mHz\": 5000,\n" +
                "        \"memorySize\": 50\n" +
                "    }";
        HttpEntity httpEntity = new HttpEntity(objToSend, httpHeaders);

        restTemplate.exchange(
                "http://localhost:8080/api/computers?id=1",
                HttpMethod.POST,
                httpEntity,
               Void.class);
    }
}
