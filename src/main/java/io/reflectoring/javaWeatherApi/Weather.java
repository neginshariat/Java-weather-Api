package io.reflectoring.javaWeatherApi;

import java.io.Serializable;
import java.math.BigDecimal;

public class Weather implements Serializable {
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

    public Weather(String clear, BigDecimal one, BigDecimal zero, BigDecimal ten) {
    }
}
