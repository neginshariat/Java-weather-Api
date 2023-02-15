package io.reflectoring.javaWeatherApi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class LiveWeatherService {
    private static final String WEATHER_JAVA = "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}&units=metric";

    @Value("${api.openweathermap.key}")
    private String apiKey;

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public LiveWeatherService(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    public Weather getWeather(String city, String country){
        URI url= new UriTemplate(WEATHER_JAVA).expand(city,country,apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return convert(response);
    }
    private Weather convert( ResponseEntity<String> response){
        try {
            JsonNode convertor= objectMapper.readTree(response.getBody());
            return new Weather(
                    convertor.path("weather").get(0).get("main").asText(),
                    BigDecimal.valueOf(convertor.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(convertor.path("main").path("feels_like").asDouble()),
                    BigDecimal.valueOf(convertor.path("wind").path("speed").asDouble())
                    );

        }catch (JsonProcessingException exception){
            throw new RuntimeException("Exception by parsing",exception);

        }

    }
}
