package com.company.flight.parser;

import com.company.flight.model.Flight;
import com.company.flight.model.Pilot;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataParser {
    public static List<Pilot> parseData(String path) {
        Map<String, Pilot> pilots = new HashMap<>();
        List<Flight> flights = new ArrayList<>();
        List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл", e);
        }

        int i = 0;
        while (i < lines.size() && !lines.get(i).isEmpty()) {
            String[] parts = lines.get(i).split(",");
            pilots.put(parts[0], new Pilot(parts[0], parts[1]));
            i++;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        for (; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) continue;
            String[] parts = lines.get(i).split(",");
            List<String> crew = Arrays.asList(parts[8].split(";"));
            Flight flight = new Flight(parts[0], parts[1], parts[2],
                    LocalDateTime.parse(parts[3], formatter),
                    LocalDateTime.parse(parts[4], formatter),
                    parts[5], parts[6], crew);
            for (String pid : crew) {
                if (pilots.containsKey(pid)) {
                    pilots.get(pid).flights.add(flight);
                }
            }
        }
        return new ArrayList<>(pilots.values());
    }
}