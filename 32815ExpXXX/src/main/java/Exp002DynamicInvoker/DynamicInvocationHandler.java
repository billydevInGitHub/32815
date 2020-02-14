package Exp002DynamicInvoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.logging.Logger;

public class DynamicInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoked method: {}"+method.getName());
        if (method.getName().equals("get")) {
            return 42;
        } else {
            throw new UnsupportedOperationException(
                    "Unsupported method: " + method.getName());
        }
    }

    public static void main(String[] args) {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                DynamicInvocationHandler.class.getClassLoader(),
                new Class[] { Map.class },
                new DynamicInvocationHandler());
        System.out.println(proxyInstance.get("hello"));
        proxyInstance.put("key","test");
    }
}
