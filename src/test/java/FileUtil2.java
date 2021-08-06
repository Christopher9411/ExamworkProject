import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil2 {
 // String data;

    public String readCredential() {
       // String[] result = new String[2];
        String data = "";
        try {
            File myUser = new File("Forum.txt");
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                 data += scanner.nextLine()+" ";
                //String[] temp = data.split(" = ");
                /*if (temp[0].equals("email")) {
                    result[0] = temp[1];
                } else {
                    result[1] = temp[1];
             }
            */
        }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}