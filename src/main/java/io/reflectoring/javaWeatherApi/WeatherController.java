package io.reflectoring.javaWeatherApi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class WeatherController {
    @GetMapping("/weather")
    public  String getWeather(Model model){
        Weather weather = new Weather("Clear", BigDecimal.ONE,BigDecimal.ZERO ,BigDecimal.TEN);
        model.addAttribute("weather", weather);
        return "weather";
    }
}
