package com.immigration.Statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@SpringBootApplication
@RestController
public class StatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
	}

	@GetMapping
	public String returnStatistics() throws MalformedURLException {
		Statistics stat = new Statistics();

		URL url = new URL("https://www.immd.gov.hk/opendata/eng/transport/immigration_clearance/statistics_on_daily_passenger_traffic.csv");

		try (InputStream in = url.openStream()) {
			Files.copy(in, Paths.get("statistics_on_daily_passenger_traffic.csv"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		CSVReader.readCSVFile(stat, "statistics_on_daily_passenger_traffic.csv");

		return stat.getNetOutflow();
	}

}
