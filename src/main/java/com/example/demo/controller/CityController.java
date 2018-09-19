package com.example.demo.controller;


import com.example.demo.annotation.NoRepeatSubmit;
import com.example.demo.dao.CityDao;
import com.example.demo.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 15:36
 **/
@RestController
public class CityController {

    @Autowired
    private CityDao cityDao;

    @NoRepeatSubmit
    @GetMapping("/get/{id}")
    public City get(@PathVariable Integer id){
        return cityDao.getById(id);
    }

}
