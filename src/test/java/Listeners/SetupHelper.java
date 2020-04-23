package Listeners;

import java.io.File;

public class SetupHelper {

    // Delete all logs before the run starts
    public static void deleteLogs(){
        System.out.println("Deleting log file before run");
        File logDir = new File(System.getProperty("user.dir")+"/src/test/logs");
        File[] logs = logDir.listFiles();
        for(File log: logs){
            log.delete();
        }
    }

}
