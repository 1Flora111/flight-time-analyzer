package com.company.flight.model;

import java.util.*;

public class MonthlyReport {
    public String month;
    public double totalHours;
    public boolean over80h;
    public Set<String> daysOver8h = new HashSet<>();
    public Set<String> weeksOver36h = new HashSet<>();
}