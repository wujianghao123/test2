package com.wjh.service.inpl;

import com.wjh.dao.Province;
import com.wjh.entity.province;
import com.wjh.service.ProvinceService;
import com.wjh.until.Sqlsessionuntil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private  Province provincedao= Sqlsessionuntil.getsqlsession().getMapper(Province.class);
    @Override
    public province getid(Integer id) {
        province pro=provincedao.getid(2);
        return pro;
    }

    @Override
    public void insert(province prov) {
        provincedao.insert(prov);
    }

    @Override
    public List<province> GetAll() {
        List<province> list=provincedao.GetAll();
        return list;
    }
}
