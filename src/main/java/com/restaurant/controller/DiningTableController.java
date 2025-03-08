package com.restaurant.controller;

import com.restaurant.entity.DiningTable;
import com.restaurant.service.DiningTableService;
import com.restaurant.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class DiningTableController {

    private final DiningTableService diningTableService;

    @Autowired
    public DiningTableController(DiningTableService diningTableService) {
        this.diningTableService = diningTableService;
    }

    @GetMapping("/available")
    public ApiResponse<List<DiningTable>> getAvailableTables() {
        List<DiningTable> tables = diningTableService.findAvailableTables();
        return ApiResponse.success(tables);
    }

    @PutMapping("/{id}/status")
    public ApiResponse<?> updateStatus(@PathVariable Integer id, @RequestBody DiningTable diningTable) {
        // 确保ID与路径参数一致
        diningTable.setId(id);

        int result = diningTableService.updateStatus(diningTable);
        if (result > 0) {
            return ApiResponse.success("餐桌状态更新成功", null);
        } else {
            return ApiResponse.error("餐桌状态更新失败");
        }
    }

    @GetMapping("/{id}")
    public ApiResponse<DiningTable> getById(@PathVariable Integer id) {
        DiningTable table = diningTableService.findById(id);
        return ApiResponse.success(table);
    }
}