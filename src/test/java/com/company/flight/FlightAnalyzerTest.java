
package com.company.flight;

import com.company.flight.model.Pilot;
import com.company.flight.parser.DataParser;
import com.company.flight.service.FlightAnalyzer;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FlightAnalyzerTest {
    @Test
    public void testAnalysisNotEmpty() {
        List<Pilot> pilots = DataParser.parseData("src/main/resources/data.txt");
        FlightAnalyzer.analyze(pilots);
        assertFalse(pilots.get(0).monthlyReports.isEmpty());
    }
}
