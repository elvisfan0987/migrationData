package com.immigration.Statistics;

public class DataCleaner {

    public static int takeOutflowData(String[] values){
        String outflowData = "";
        if(values[1].equals("Airport") && values[2].equals("Departure")) {
            outflowData = values[3];
        }

        if (outflowData != "") {
            return Integer.parseInt(outflowData);
        }

        return 0;
    }

    public static int takeInflowData(String[] values){
        String inflowData = "";
        if(values[1].equals("Airport") && values[2].equals("Arrival")) {
            inflowData = values[3];
        }

        if (inflowData != "") {
            return Integer.parseInt(inflowData);
        }

        return 0;
    }
}
