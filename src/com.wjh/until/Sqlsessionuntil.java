package com.wjh.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Sqlsessionuntil {
    private static SqlSessionFactory s1;
    static {
        try {
            InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
            s1 =  new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static ThreadLocal<SqlSession> local=new ThreadLocal<>();
    public static SqlSession getsqlsession(){
        SqlSession session=local.get();
        if(session==null){
            session=s1.openSession();
            local.set(session);
        }
        return session;
    }
    public static void closesession(SqlSession session){
        if(session!=null){
            session.close();
            //清理干净线程池里面的session
            local.remove();
        }

    }

}
