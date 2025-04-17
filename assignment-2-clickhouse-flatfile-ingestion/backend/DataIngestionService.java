package io.zeotap.backend.service;

import org.springframework.stereotype.Service;

@Service
public class DataIngestionService {

    public String ingestDataToFlatFile(IngestionRequest request) {
        // Logic for ClickHouse to Flat File
        return "Data ingested to flat file successfully";
    }

    public String ingestDataToClickHouse(IngestionRequest request) {
        // Logic for Flat File to ClickHouse
        return "Data ingested to ClickHouse successfully";
    }
}
