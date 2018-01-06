package com.liuil.web.service.impl;

import com.liuil.web.dao.CityDao;
import com.liuil.web.domain.City;
import com.liuil.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{
  @Autowired
  private CityDao cityDao;

  public City findCityByName(String cityName) { return cityDao.findByName(cityName);}

}
