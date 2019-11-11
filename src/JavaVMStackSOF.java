/**
 * 过度调用方法产生异常，在一个线程中的栈空间超过设置的栈空间大小
 * VM args: -Xss128k
 */
public class JavaVMStackSOF {
    //记录深度
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{

            oom.stackLeak();
        }catch (Throwable t){
            //输出深度
            System.out.println("stack length:"+oom.stackLength);
            throw t;
        }
    }
}
