package listeners;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import java.io.File;
import java.io.IOException;

public class SuiteListener implements ISuiteListener {

    static String sourcePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Current_test_results";
    static String destinationPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Archived_test_results";

    public void onStart(ISuite suite){
        System.out.println("Suite listener onStart execution started!!");

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
        System.out.println("Test suite execution is finished successfully!!");
    }
}
