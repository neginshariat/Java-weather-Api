package io.reflectoring.javaWeatherApi;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StubWeatherService {
    public Weather getWeather(String city, String country){

        return new Weather("clear", BigDecimal.ONE, BigDecimal.ZERO,BigDecimal.TEN);
    }
}
