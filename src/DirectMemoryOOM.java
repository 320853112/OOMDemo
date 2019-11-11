import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * vm Args -Xmx20M -xx:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB =1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            //不停的分配
            unsafe.allocateMemory(_1MB);
        }
    }
}
