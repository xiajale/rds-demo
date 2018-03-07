package com.huawei.com.rdsdemo.controller;

import com.huawei.com.rdsdemo.model.Good;
import com.huawei.com.rdsdemo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodController {

    private final GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @PostMapping(value = "/good")
    public int add(@RequestBody Good good){
        return goodService.add(good);
    }

    @PutMapping(value = "/good/{id}")
    public int update(@RequestBody Good good, @PathVariable(value = "id") String id){
        return goodService.update(good, id);
    }

    @DeleteMapping(value = "/good/{id}")
    public int delete(@PathVariable(value = "id") String id){
        return goodService.delete(id);
    }

    @GetMapping(value = "/good/{id}")
    public Good find(@PathVariable(value = "id") String id){
        return goodService.find(id);
    }

    @GetMapping(value = "/good")
    public List<Good> findAll(){
        return goodService.findAll();
    }
}
