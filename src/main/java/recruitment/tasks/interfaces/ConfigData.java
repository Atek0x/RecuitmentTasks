package recruitment.tasks.interfaces;

import org.aeonbits.owner.Config;

import java.time.Duration;

@Config.Sources("file:src/test/java/resources/config.properties")
public interface ConfigData extends Config {

    @Key("driver.type")
    String driverType();

    @Key("url.api")
    String apiUrl();

    @Key("url.ui")
    String uiUrl();

    @Key("wait.timeout.seconds")
    Integer waitTimeoutInSeconds();

}

