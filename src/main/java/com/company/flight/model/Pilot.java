package com.company.flight.model;

import java.util.*;

public class Pilot {
    public String id;
    public String name;
    public List<Flight> flights = new ArrayList<>();
    public Map<String, MonthlyReport> monthlyReports = new HashMap<>();

    public Pilot(String id, String name) {
        this.id = id;
        this.name = name;
    }
}