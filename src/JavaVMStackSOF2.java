/**
 * 过度创建线程导致异常，创建每个线程都需要栈空间，线程创建多了，栈就爆了
 */
public class JavaVMStackSOF2 {
    public static void main(String[] args) {
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();
        }
    }
}
