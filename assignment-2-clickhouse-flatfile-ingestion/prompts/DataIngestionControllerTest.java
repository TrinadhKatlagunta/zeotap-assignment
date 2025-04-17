package tests;

import io.zeotap.backend.controller.DataIngestionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DataIngestionControllerTest {

    @Autowired
    private DataIngestionController controller;

    @Test
    public void testIngestDataToFlatFile() {
        IngestionRequest request = new IngestionRequest();
        request.setSource("ClickHouse");
        request.setTarget("Flat File");

        ResponseEntity<String> response = controller.ingestDataToFlatFile(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Data ingested to flat file successfully", response.getBody());
    }

    @Test
    public void testIngestDataToClickHouse() {
        IngestionRequest request = new IngestionRequest();
        request.setSource("Flat File");
        request.setTarget("ClickHouse");

        ResponseEntity<String> response = controller.ingestDataToClickHouse(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Data ingested to ClickHouse successfully", response.getBody());
    }
}
