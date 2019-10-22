package todo.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import todo.core.Listeklasse;
import todo.core.Todo;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RestClient {

    private static final String GET_TASK_ENDPOINT_URL = "http://localhost:8080/save";
    private static final String CREATE_TASK_ENDPOINT_URL = "http://localhost:8080/save";
    private RestTemplate restTemplate = new RestTemplate();

    private String server = "http://localhost:8080";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;
    private ObjectMapper objectMapper;

    //Constructer som definerer parametere. RestTemplate er en funksjon fra Springboot som hjelper å koble mot server
    public RestClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        this.objectMapper = new ObjectMapper();
    }

    //funksjon for å kunne hente ting fra server
    public String get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    //funksjon for å kunne poste ting opp til server
    public String post(String uri, Listeklasse listeklasse) throws JsonProcessingException {
        HttpHeaders headers2 = new HttpHeaders();
        String json = objectMapper.writeValueAsString(listeklasse);
        headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers2);
        ResponseEntity<String> responseEntity = rest.exchange(
                server + uri,
                HttpMethod.POST,
                requestEntity,
                String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    //Henter http status
    public HttpStatus getStatus() {
        return status;
    }

    //Setter http status
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
