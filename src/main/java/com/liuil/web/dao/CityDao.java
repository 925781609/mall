package com.liuil.web.dao;

import com.liuil.web.domain.City;
import org.apache.ibatis.annotations.Param;

public interface CityDao {
  City findByName(@Param("cityName") String cityName);
}
