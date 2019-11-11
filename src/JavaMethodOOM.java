import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class JavaMethodOOM {

    public static void main(String[] args) {
        while (true){
            //构建代理对象
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects,args);
                }
            });
            //生成代理对象
            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
