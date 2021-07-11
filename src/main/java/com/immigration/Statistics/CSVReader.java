package com.immigration.Statistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CSVReader {

    public static void readCSVFile(Statistics stat, String pPath){
        BufferedReader br = null;
        String line = "";
        int outflowSum = 0;
        int inflowSum = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startingDate = null;
        LocalDate endingDate = null;
        int rowCount = 0;

        try {
            br = new BufferedReader(new FileReader(pPath));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                outflowSum += DataCleaner.takeOutflowData(values);
                inflowSum += DataCleaner.takeInflowData(values);

                if (rowCount == 1){
                    // Remove the double quotes at the beginning
                    startingDate = LocalDate.parse(values[0], formatter);
                    stat.setStartingDate(startingDate);
                } else if (rowCount > 1) {
                    endingDate = LocalDate.parse(values[0], formatter);
                    stat.setEndingDate(endingDate);
                }
                rowCount++;
            }

            stat.setInflow(inflowSum);
            stat.setOutflow(outflowSum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
