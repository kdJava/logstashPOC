package logback.test;

import static net.logstash.logback.marker.Markers.append;
import static net.logstash.logback.marker.Markers.appendEntries;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackConfigTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackConfigTest.class);

    public static void main(String[] args) {

        LOGGER.info(append("@path", "Test-Path"), "My log message1");
        LOGGER.info("");
        LOGGER.info(append("@path", "Test-Path").and(append("@transactionId", "123456789")), "My log message2");
        LOGGER.info("");
        Map<String, String> map = new HashMap<>();
        map.put("transactionId", "12234567");
        map.put("action", "12234567");
        map.put("from", "cassandra");
        map.put("to", "importer");
        LOGGER.info(appendEntries(map), "My log message5");
        LOGGER.info("");
        LOGGER.error("I have logged this message", new NullPointerException("Test Null-Exception Message3"));
    }

}
