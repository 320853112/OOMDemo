import java.util.ArrayList;

/**
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        ArrayList<String > list = new ArrayList();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
