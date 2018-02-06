package effectiveJava;

import com.mysql.jdbc.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author GuanBin
 * @version Thread.java, v1 2018/1/24 下午2:00 GuanBin Exp $$
 */
public class Thread {

    private static boolean stopRequest;

    private static synchronized void requestStop() {
        stopRequest = true;
    }

    private static synchronized boolean setStopRequested() {
        return stopRequest;
    }

    public static void main(String[] args) throws InterruptedException {
        java.lang.Thread thread = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequest) {
                    i++;
                }
                System.out.println(i);
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
//        TimeUtil.changeTimezone();

    }

}
