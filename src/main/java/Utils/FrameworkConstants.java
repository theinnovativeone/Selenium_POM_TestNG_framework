package Utils;

public class FrameworkConstants {

    public static String URL = PropertyFileReader.getConfigData("url");
    public static String BROWSER_NAME = PropertyFileReader.getConfigData("browser");
    public static String WAIT_IMPLICIT = PropertyFileReader.getConfigData("wait_implicit");

    public static String VALID_EMAIL = PropertyFileReader.getTestData("validEmail");
    public static String VALID_PASSWORD = PropertyFileReader.getTestData("validPassword");
    public static String INVALID_EMAIL = PropertyFileReader.getTestData("invalidEmail");
    public static String INVALID_PASSWORD = PropertyFileReader.getTestData("invalidPassword");
    public static String SEARCH_KEYWORD = PropertyFileReader.getTestData("searchKeyword");

    public static String FILE_SEPARATOR = System.getProperty("file.separator");
    public static String CURRENT_DIR = System.getProperty("user.dir");
}
