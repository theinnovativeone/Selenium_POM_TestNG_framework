package listeners;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import java.io.File;
import java.io.IOException;

public class SuiteListener implements ISuiteListener {

    private static final Logger logger = LogManager.getLogger(SuiteListener.class);
    static String sourcePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Current_test_results";
    static String destinationPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Archived_test_results";

    public void onStart(ISuite suite){

        logger.info("Test Suite has started!!");

        File srcDir = new File(sourcePath);
        File destinationDir = new File(destinationPath);

        if(srcDir.list().length > 1){
            if(!destinationDir.exists()){
                destinationDir.mkdirs();
            }
        }
        try {
            FileUtils.moveDirectoryToDirectory(srcDir, destinationDir, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String newName = destinationPath + System.getProperty("file.separator") + "Test_Results" + "_" + System.currentTimeMillis();
        String oldName = destinationPath + System.getProperty("file.separator") + "Current_test_results";

        File oldFile = new File(oldName);
        File newFile = new File(newName);
        oldFile.renameTo(newFile);
    }

    public void onFinish(ISuite suite){
        logger.info("Test suite execution is finished successfully!!");
    }
}
