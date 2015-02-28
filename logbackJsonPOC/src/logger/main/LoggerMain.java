/**
 * logbackJsonPOC.logger.main.LoggerMain.java
 * 26-Feb-2015 10:02:28 pm
 * [2015]
 */
package logger.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import logger.context.Content;
import logger.context.LogContent;

/**
 * logbackJsonPOC
 *
 * @author ketandikshit 26-Feb-2015 10:02:28 pm
 *         logger.main.LoggerMain.java--->[LoggerMain.class]
 */
public class LoggerMain {

	private static final String APP_ID = "CA";
	private static final String ACTION = "parse";
	private static final String WORKFLOW = "MQListener";

	private static final ExecutorService EXECUTOR = Executors
			.newFixedThreadPool(10);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			final int thrdCnt = i;
			EXECUTOR.submit(new Runnable() {
				@Override
				public void run() {
					Thread.currentThread().setName("Thread-" + thrdCnt);
					Content content = new Content();
					content.hasAppId(APP_ID).forAction(ACTION)
							.ofWorkflow(WORKFLOW);
					LogContent logContent = new LogContent(content);
				}
			});
		}
	}
}
