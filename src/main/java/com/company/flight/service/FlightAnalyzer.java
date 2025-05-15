package com.company.flight.service;

import com.company.flight.model.Flight;
import com.company.flight.model.MonthlyReport;
import com.company.flight.model.Pilot;

import java.time.*;
import java.time.temporal.WeekFields;
import java.util.*;

public class FlightAnalyzer {

    public static void analyze(List<Pilot> pilots) {
        for (Pilot pilot : pilots) {
            Map<String, List<Flight>> flightsByMonth = new HashMap<>();
            for (Flight flight : pilot.flights) {
                String month = flight.departureTime.getYear() + "-" + String.format("%02d", flight.departureTime.getMonthValue());
                flightsByMonth.computeIfAbsent(month, k -> new ArrayList<>()).add(flight);
            }

            for (String month : flightsByMonth.keySet()) {
                MonthlyReport report = new MonthlyReport();
                report.month = month;

                Map<String, Double> daily = new HashMap<>();
                Map<String, Double> weekly = new HashMap<>();
                double total = 0;

                for (Flight flight : flightsByMonth.get(month)) {
                    Duration dur = Duration.between(flight.departureTime, flight.arrivalTime);
                    double hours = dur.toMinutes() / 60.0;
                    total += hours;

                    String day = flight.departureTime.toLocalDate().toString();
                    daily.put(day, daily.getOrDefault(day, 0.0) + hours);

                    WeekFields weekFields = WeekFields.of(Locale.getDefault());
                    String week = flight.departureTime.getYear() + "-W" + flight.departureTime.get(weekFields.weekOfWeekBasedYear());
                    weekly.put(week, weekly.getOrDefault(week, 0.0) + hours);
                }

                report.totalHours = total;
                report.over80h = total > 80;

                for (Map.Entry<String, Double> d : daily.entrySet()) {
                    if (d.getValue() > 8) report.daysOver8h.add(d.getKey());
                }
                for (Map.Entry<String, Double> w : weekly.entrySet()) {
                    if (w.getValue() > 36) report.weeksOver36h.add(w.getKey());
                }

                pilot.monthlyReports.put(month, report);
            }
        }
    }
}