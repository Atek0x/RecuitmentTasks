package recruitment.tasks.utils;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import recruitment.tasks.interfaces.ConfigData;

import java.util.List;

public class Utils {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final ConfigData CONFIG_DATA = ConfigFactory.create(ConfigData.class);

    public static int generateRandomNumber() {
        LOGGER.info("Generate random number.");
        return (int) (Math.random() * 100000);
    }

    public static int generateRandomPhoneNumber() {
        LOGGER.info("Generate random number.");
        return (int) (Math.random() * 999999999);
    }

    public static String generateRandomString(String username) {
        String usernameWithUniqueId = username + generateRandomNumber();
        LOGGER.info("New random string was generated.", usernameWithUniqueId);
        return usernameWithUniqueId;
    }

//    public static String generateRandomEmail(String email) {
//        String emailWithUniqueId = email.replace("@", "." + generateRandomString("user"));
//        LOGGER.info("New random string was generated.", emailWithUniqueId);
//        return emailWithUniqueId;
//    }
}
