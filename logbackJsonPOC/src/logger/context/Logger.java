/**
 * logbackJsonPOC.logger.context.LogContent.java
 * 26-Feb-2015 9:51:04 pm
 * [2015]
 */
package logger.context;

import static net.logstash.logback.marker.Markers.appendEntries;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * logbackJsonPOC
 * 
 * @author ketandikshit 26-Feb-2015 9:51:04 pm
 * logger.context.Logger.java--->[Logger.class]
 */
public class Logger {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    private static ThreadLocal<Map<String, String>> content = new ThreadLocal<>();
    private final Map<String, String> contentMap = new HashMap<>();

    /**
     * Constructor Logger
     */
    public Logger() {
        content.set(contentMap);
    }

    public Logger append(String key, String value) {
        contentMap.put(key, value);
        LOGGER.trace(key + " Added to map with value:" + value);
        return this;
    }

    public void log(String message) {
        try {
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            if (className.contains("$")) {
                className = className.substring(0, className.indexOf('$'));
            }
            Class<?> logSourceClass = Class.forName(className);
            org.slf4j.Logger logger = LoggerFactory.getLogger(logSourceClass);
            logger.trace(appendEntries(contentMap), message);
            logger.info("*************Message Logged****************");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
