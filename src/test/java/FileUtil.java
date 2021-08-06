

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {

    public static void writeToFile() {
    }

    public String[] readCredential() {
        String[] result = new String[2];
        try {
            File myUser = new File("Login.txt");
            Scanner scanner = new Scanner(myUser);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = data.split(" = ");
                if (temp[0].equals("email")) {
                    result[0] = temp[1];
                } else {
                    result[1] = temp[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void writeToFile(String privacy_text) {
        try {
            FileWriter textFile = new FileWriter("Privacy.txt");
            textFile.close();
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
