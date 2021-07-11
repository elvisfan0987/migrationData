package com.immigration.Statistics;

import java.time.LocalDate;

public class Statistics {
    private int inflow;
    private int outflow;
    private LocalDate startingDate;
    private LocalDate endingDate;

    public int getInflow() {
        return inflow;
    }

    public void setInflow(int inflow) {
        this.inflow = inflow;
    }

    public int getOutflow() {
        return outflow;
    }

    public void setOutflow(int outflow) {
        this.outflow = outflow;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getNetOutflow() {
        int netOutflow = this.outflow - this.inflow;
        return Integer.valueOf(netOutflow).toString();
    }
}
