package com.example.demo.dao;

import com.example.demo.entity.City;
import org.springframework.stereotype.Repository;


/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 16:09
 **/
@Repository
public interface CityDao {

    City getById(Integer id);
}
