package com.wjh.dao;

import com.wjh.entity.province;

import java.util.List;

public interface Province {
    public province getid(Integer id);
    public void insert(province pro);
    public  List<province> GetAll();
}
