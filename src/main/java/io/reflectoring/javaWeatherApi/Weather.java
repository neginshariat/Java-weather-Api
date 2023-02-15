package io.reflectoring.javaWeatherApi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Weather implements Serializable {
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

    public Weather(String clear, BigDecimal one, BigDecimal zero, BigDecimal ten) {
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public BigDecimal getFeelsLike() {
        return feelsLike;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public void setFeelsLike(BigDecimal feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        Weather weather = (Weather) o;
        return Objects.equals(description, weather.description) && Objects.equals(temperature, weather.temperature) && Objects.equals(feelsLike, weather.feelsLike) && Objects.equals(windSpeed, weather.windSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, temperature, feelsLike, windSpeed);
    }*/
}
