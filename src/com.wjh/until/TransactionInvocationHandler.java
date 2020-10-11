package com.wjh.until;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res=null;
        SqlSession session= Sqlsessionuntil.getsqlsession();
        try {

            res=method.invoke(target,args);
            session.commit();

        }catch (Exception e){
            session.rollback();
            e.printStackTrace();

        }finally {
            Sqlsessionuntil.closesession(session);
        }

        return res;
    }

    public Object getproxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
    }
}
