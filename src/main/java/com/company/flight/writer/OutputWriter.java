package com.company.flight.writer;

import com.company.flight.model.Pilot;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OutputWriter {
    public static void writeToJson(List<Pilot> pilots, String path) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(path), pilots);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи JSON", e);
        }
    }
}