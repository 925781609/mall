package com.liuil.web.domain;

public class City {
  private Long id;
  private Long provinceId;
  private String cityName;
  private String description;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(Long proviceId) {
    this.provinceId = proviceId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
