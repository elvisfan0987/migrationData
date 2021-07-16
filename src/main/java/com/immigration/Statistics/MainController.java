package com.immigration.Statistics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class MainController {
    @GetMapping
    public String returnStatistics(Model model) throws MalformedURLException {
        Statistics stat = new Statistics();

        URL url = new URL("https://www.immd.gov.hk/opendata/eng/transport/immigration_clearance/statistics_on_daily_passenger_traffic.csv");

        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get("statistics_on_daily_passenger_traffic.csv"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CSVReader.readCSVFile(stat, "statistics_on_daily_passenger_traffic.csv");

        System.out.println(stat.getNetOutflow());
        model.addAttribute("stat", stat);
        return "viewStatistics";
    }
}
