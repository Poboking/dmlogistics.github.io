package rog.sziit.dynamicplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rog.sziit.dynamicplus.models.DataSourceEntity;
import rog.sziit.dynamicplus.service.impl.DataSourceManagementServiceImpl;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/21 19:57
 */
@Controller
@RestController
public class DataSourceController {
    private final DataSourceManagementServiceImpl dataSourceManagementService;
    private final Map<String , DataSourceEntity> dataSourceEntityMap;

    @Autowired
    public DataSourceController(DataSourceManagementServiceImpl dataSourceManagementService, Map<String, DataSourceEntity> dataSourceEntityMap) {
        this.dataSourceManagementService = dataSourceManagementService;
        this.dataSourceEntityMap = dataSourceEntityMap;
    }

    /**
     * 新增数据源
     * @param dataSourceEntity
     */
    @PostMapping("/data-sources")
    public void addDataSource(@RequestBody DataSourceEntity dataSourceEntity) {
        dataSourceManagementService.addDataSource(dataSourceEntity);
    }

    /**
     * 删除数据源
     * @param name
     */
    @DeleteMapping("/data-sources/{name}")
    public void removeDataSource(@PathVariable String name) {
        dataSourceManagementService.removeDataSource(name);
    }

    /**
     * 获取数据源
     * @param name
     * @return
     */
    @GetMapping("/data-sources/{name}")
    public DataSource getDataSource(@PathVariable String name) {
        return dataSourceManagementService.getDataSource(name);
    }

    @GetMapping("/data-source/list")
    public ResponseEntity<Map> getDataSourceList(){
        return ResponseEntity.ok().body(dataSourceEntityMap);
    }


}

