package com.huawei.com.rdsdemo.controller;

import com.huawei.com.rdsdemo.model.Purchaser;
import com.huawei.com.rdsdemo.service.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaserController {

    private final PurchaserService purchaserService;

    @Autowired
    public PurchaserController(PurchaserService purchaserService) {
        this.purchaserService = purchaserService;
    }

    @PostMapping(value = "/purchaser")
    public int add(@RequestBody Purchaser purchaser){
        return purchaserService.add(purchaser);
    }

    @PutMapping(value = "/purchaser/{id}")
    public int update(@RequestBody Purchaser purchaser, @PathVariable(value = "id") String id){
        return purchaserService.update(purchaser, id);
    }

    @DeleteMapping(value = "/purchaser/{id}")
    public int delete(@PathVariable(value = "id") String id){
        return purchaserService.delete(id);
    }

    @GetMapping(value = "/purchaser/{id}")
    public Purchaser find(@PathVariable(value = "id") String id){
        return purchaserService.find(id);
    }

    @GetMapping(value = "/purchaser")
    public List<Purchaser> findAll(){
        return purchaserService.findAll();
    }
}
