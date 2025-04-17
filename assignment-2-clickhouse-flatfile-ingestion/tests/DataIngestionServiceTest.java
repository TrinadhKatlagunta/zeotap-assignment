package tests;

import io.zeotap.backend.service.DataIngestionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataIngestionServiceTest {

    private DataIngestionService service = new DataIngestionService();

    @Test
    public void testIngestDataToFlatFile() {
        IngestionRequest request = new IngestionRequest();
        request.setSource("ClickHouse");
        request.setTarget("Flat File");

        String result = service.ingestDataToFlatFile(request);
        assertEquals("Data ingested to flat file successfully", result);
    }

    @Test
    public void testIngestDataToClickHouse() {
        IngestionRequest request = new IngestionRequest();
        request.setSource("Flat File");
        request.setTarget("ClickHouse");

        String result = service.ingestDataToClickHouse(request);
        assertEquals("Data ingested to ClickHouse successfully", result);
    }
}
