import java.util.ArrayList;

/**
 * jvm参数
 * -Xms20M -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList();
        //通过不停创建对象来使得堆内存溢出
        while (true){
            //加入list，防止GC
            list.add(new HeapOOM());
        }
    }
}
