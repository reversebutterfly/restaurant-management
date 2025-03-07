package com.restaurant.controller;

import com.restaurant.entity.DiningTable;
import com.restaurant.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class DiningTableController {

    @Autowired
    private DiningTableService diningTableService;

    @GetMapping("/available")
    public ResponseEntity<List<DiningTable>> getAvailableTables() {
        List<DiningTable> tables = diningTableService.findAvailableTables();
        return ResponseEntity.ok(tables);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Integer id, @RequestBody DiningTable diningTable) {
        diningTable.setId(id);
        int result = diningTableService.updateStatus(diningTable);
        if (result > 0) {
            return ResponseEntity.ok().body("Table status updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update table status");
        }
    }
}