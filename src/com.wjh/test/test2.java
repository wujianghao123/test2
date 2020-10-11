package com.wjh.test;

import com.wjh.entity.province;
import com.wjh.service.ProvinceService;
import com.wjh.service.inpl.ProvinceServiceImpl;
import com.wjh.until.ServiceFactory;

import java.util.List;

public class test2 {
    public static void main(String[] args) {
//        ProvinceService provinceService= (ProvinceService) ServiceFactory.getService(new ProvinceServiceImpl());
//        province pro = provinceService.getid(2);
//        System.out.println(pro);
//        province pro1=new province();
//        pro1.setShenghui("sfds");
//        pro1.setName("dsfsfsdf");
//        pro1.setJiancheng("sb");
//        pro1.setId(53);
        ProvinceService provinceService1= (ProvinceService) ServiceFactory.getService(new ProvinceServiceImpl());
//        provinceService1.insert(pro1);
        List<province> list=provinceService1.GetAll();
        System.out.println(list);

    }

}
