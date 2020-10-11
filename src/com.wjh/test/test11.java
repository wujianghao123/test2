package com.wjh.test;

import com.wjh.entity.province;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test11 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            //通过加载MyBatis的主配文件mybatis-config.xml，创建输入流对象
            resourceAsStream = Resources.getResourceAsStream(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        SqlSessionFactoryBuilder:SqlSessionFactory的创造者
        通过改建造者对象调用建造方法，为我们建造一个SqlSessionFactory对象
        SqlSessionFactory对象唯一的作用就是要为我创建一个sqlsession对象
        我们未来所有的操作使用的都是sqlsession对象来完成


        */
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession s1 = build.openSession();
        /*


        */

        province a=s1.selectOne("test1.l1",1);
        System.out.println(a.getId());
        List<province> list = s1.selectList("test1.l2");
        for (province a2 :
                list) {
            System.out.println(a2);

        }
        /**
         * 我们需要提交事务(commit)才能把数据添加进去或者在sql里面删除数据
         */
        //删除操作
        int delete = s1.delete("test1.d1", 10);
        s1.commit();
        System.out.println(delete);
        //添加操作
        province chengshi = new province();
        chengshi.setId(10);
        chengshi.setJiancheng("ss");
        chengshi.setName("玉玉");
        chengshi.setShenghui("1");
        int insert = s1.insert("test1.i1", chengshi);
        s1.commit();
        System.out.println(insert);
        //更新
       List qq=new ArrayList();
       qq.add("aasd");
       qq.add(10);
        s1.update("test1.u1",qq);
        s1.commit();
        s1.close();
    }
}
