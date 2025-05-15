package com.company.flight;

import com.company.flight.model.Pilot;
import com.company.flight.parser.DataParser;
import com.company.flight.service.FlightAnalyzer;
import com.company.flight.writer.OutputWriter;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Pilot> pilots = DataParser.parseData("src/main/resources/data.txt");
        FlightAnalyzer.analyze(pilots);
        OutputWriter.writeToJson(pilots, "src/main/resources/output.json");
        System.out.println("Анализ завершён. Результаты сохранены в output.json.");
    }
}