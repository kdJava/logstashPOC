/**
 * logbackJsonPOC.logger.context.Content.java
 * 26-Feb-2015 9:51:59 pm
 * [2015]
 */
package logger.context;

import java.util.HashMap;
import java.util.Map;

/**
 * logbackJsonPOC
 *
 * @author ketandikshit 26-Feb-2015 9:51:59 pm
 *         logger.context.Content.java--->[Content.class]
 */
public class Content {

	private String appId;
	private String action;
	private String workFlow;
	private final Map<String, String> contentMap = new HashMap<>();

	public Content() {
	}

	public Content hasAppId(String appId) {
		this.appId = appId;
		return this;
	}

	public Content forAction(String action) {
		this.action = action;
		return this;
	}

	public Content ofWorkflow(String workflow) {
		workFlow = workflow;
		return this;
	}

	public Map<String, String> setProperty(String propName, String propValue) {
		contentMap.put(propName, propValue);
		return contentMap;
	}

	public String getProperty(String propName) {
		return contentMap.get(propName);
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @return the workFlow
	 */
	public String getWorkFlow() {
		return workFlow;
	}

	/**
	 * @return the contentMap
	 */
	public Map<String, String> getContentMap() {
		return contentMap;
	}

}
