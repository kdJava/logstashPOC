/**
 * logbackJsonPOC.logger.main.LoggerMain.java
 * 26-Feb-2015 10:02:28 pm
 * [2015]
 */
package logger.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import logger.context.Logger;

/**
 * logbackJsonPOC
 * 
 * @author ketandikshit 26-Feb-2015 10:02:28 pm
 * logger.main.LoggerMain.java--->[LoggerMain.class]
 */
public class LoggerMain {

    private static final String THREAD_NAME = "THREAD-";

    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 1000000; i++) {
            final int thrdCnt = i;
            EXECUTOR.submit(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(THREAD_NAME + thrdCnt);
                    Logger logContent = new Logger();
                    logContent.append("@threadName", THREAD_NAME + thrdCnt).log(
                            "Logging Message for " + THREAD_NAME + thrdCnt);
                }
            });
        }

        EXECUTOR.shutdown();
        EXECUTOR.awaitTermination(1, TimeUnit.DAYS);
    }
}
