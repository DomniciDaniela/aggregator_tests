package helpers.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteToLogFile {

    public static void main(String string) {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(new Date());
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter(Constants.LOGS_PATH + "Esure_Test_Log.log", true));
            output.write("\r\n");
            output.append(timeStamp + " - " + string);
            output.close();

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

