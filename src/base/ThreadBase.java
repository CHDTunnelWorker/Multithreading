package base;

/**
 * @program: Multithreading
 * @description: 线程基础
 * @author: Holland
 * @create: 2020-07-24 15:24
 **/
public class ThreadBase {

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        //lamda表达式创建一个继承与Runnable接口的实例
        Runnable runnable = () -> {
            int i = 10;

            for(int j = 0;j < i;j++){
                count++;
                System.out.println(Thread.currentThread().getName()+"  count: "+count);
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"InterruptedException");
            }

        };

        Thread thread = new Thread(runnable);

        //start() 负责启动新线程,启动后直接返回;代码的执行由启动的新线程处理
        thread.start();

        Thread.sleep(5000);

        //main线程执行 thread.interrupt() 代码,向thread线程发送中断请求
        thread.interrupt();

        //注意,调用run方法,发现打印的线程名为main 说明 调用run方法只是将代码在同一个线程中执行  而不是 新开启一个线程去执行
        //thread.run();
    }

}
