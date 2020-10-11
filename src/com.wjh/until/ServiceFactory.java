package com.wjh.until;

public class ServiceFactory {
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getproxy();
    }
}
