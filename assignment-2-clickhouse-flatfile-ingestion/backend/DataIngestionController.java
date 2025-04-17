package io.zeotap.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import io.zeotap.backend.service.DataIngestionService;

@RestController
@RequestMapping("/api/ingest")
public class DataIngestionController {

    @Autowired
    private DataIngestionService dataIngestionService;

    // Endpoint to ingest data from ClickHouse to FlatFile
    @PostMapping("/clickhouse-to-flatfile")
    public String ingestDataToFlatFile(@RequestParam("targetTable") String targetTable) {
        // Call service method to handle the ingestion
        return dataIngestionService.ingestDataToFlatFile(targetTable);
    }

    // Endpoint to ingest data from FlatFile to ClickHouse (with file upload)
    @PostMapping("/flatfile-to-clickhouse")
    public String ingestDataToClickHouse(@RequestParam("file") MultipartFile file, 
                                        @RequestParam("targetTable") String targetTable) {
        // Call service method to handle the file ingestion to ClickHouse
        return dataIngestionService.ingestDataToClickHouse(file, targetTable);
    }
}
