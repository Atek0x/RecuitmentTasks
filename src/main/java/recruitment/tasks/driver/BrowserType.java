package recruitment.tasks.driver;

public enum BrowserType {

    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
