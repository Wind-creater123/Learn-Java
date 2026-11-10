package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static StarService createProxy(Star s){
        StarService proxy=(StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader()
                , s.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        if("sing".equals(methodName)){
                            System.out.println("cost 20rmb");
                        }
                        if("dance".equals(methodName)){
                            System.out.println("cost 20rmb");
                        }

                        Object result = method.invoke(s, args);
                        return result;
                    }
                });
        return proxy;
    }
}
