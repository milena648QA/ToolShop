package configuration;

import lombok.Getter;
import lombok.Setter;
import org.jeasy.props.annotations.Property;
import org.jeasy.props.annotations.SystemProperty;

import static org.jeasy.props.PropertiesInjectorBuilder.aNewPropertiesInjector;

@Getter
@Setter
public class Configuration {

    private static final String CONFIGURATION_FILE_PATH = "config/configuration.properties";

    public Configuration() {
        aNewPropertiesInjector().injectProperties(this);
    }

/*    @SystemProperty(value = "testEnv", defaultValue = "DEV")
    private String testEnv;
    @SystemProperty(value = "uploadResultsToXray", defaultValue = "true")
    private String uploadResultsToXray;
    @SystemProperty(value = "notifySlack", defaultValue = "true")
    private String notifySlack;
    @SystemProperty(value = "profile", defaultValue = "TEST")
    private String profile;
    @SystemProperty(value = "numberOfRequests", defaultValue = "10")
    private String numberOfRequests;
    @SystemProperty(value = "serviceProvider", defaultValue = "SauceLabs")
    private String serviceProvider;
    @SystemProperty(value = "platform", defaultValue = "WIN10")
    private String platform;
    @SystemProperty(value = "platformVersion", defaultValue="")
    private String platformVersion;
    @SystemProperty(value = "browser", defaultValue = "chrome")
    private String browser;
    @SystemProperty(value = "browserVersion", defaultValue = "latest")
    private String browserVersion;*/

    @Property(source = CONFIGURATION_FILE_PATH, key = "coinmarket.baseURI")
    private String coinMarketBaseURI;
    @Property(source = CONFIGURATION_FILE_PATH, key = "coinmarket.apiKey")
    private String coinMarketApiKey;


}