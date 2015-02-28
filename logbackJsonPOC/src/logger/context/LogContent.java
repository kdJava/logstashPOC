/**
 * logbackJsonPOC.logger.context.LogContent.java
 * 26-Feb-2015 9:51:04 pm
 * [2015]
 */
package logger.context;

import java.util.HashMap;
import java.util.Map;

/**
 * logbackJsonPOC
 *
 * @author ketandikshit 26-Feb-2015 9:51:04 pm
 *         logger.context.LogContent.java--->[LogContent.class]
 */
public class LogContent {

	private static ThreadLocal<Content> content = new ThreadLocal<>();

	private String appId;
	private String action;
	private String workFlow;
	private final Map<String, String> contentMap = new HashMap<>();

	/**
	 * Constructor LogContent
	 */
	public LogContent(Content logData) {
		content.set(logData);
	}

	public static Content getContent() {
		return content.get();
	}
}
