package io.zeotap.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.zeotap.backend.service.DataIngestionService;

@RestController
@RequestMapping("/api/ingest")
public class DataIngestionController {

    @Autowired
    private DataIngestionService dataIngestionService;

    @PostMapping("/clickhouse-to-flatfile")
    public String ingestDataToFlatFile(@RequestBody IngestionRequest request) {
        return dataIngestionService.ingestDataToFlatFile(request);
    }

    @PostMapping("/flatfile-to-clickhouse")
    public String ingestDataToClickHouse(@RequestBody IngestionRequest request) {
        return dataIngestionService.ingestDataToClickHouse(request);
    }
}
