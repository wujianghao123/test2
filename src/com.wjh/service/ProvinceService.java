package com.wjh.service;

import com.wjh.entity.province;

import java.util.List;

public interface ProvinceService {
    public province getid(Integer id);
    public void insert(province prov);
    public List<province> GetAll();
}
