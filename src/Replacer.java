import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Replacer {
    public static void doubleReplacer(File file) throws IOException, FileNotFoundException {
        // Declaring vars:
        Scanner fileReader = new Scanner(file);
        File tempFile = new File("src/temp.txt"); // Temp File
        FileWriter fileWriter = new FileWriter(tempFile);
        PrintWriter printer = new PrintWriter(fileWriter);

        char[] lineAsCharArray;
        char[] numbers = new char[]{'1','2','3','4','5','6','7','8','9','0'};
        int commaIndex;

        // Interating at the archive:
        while (fileReader.hasNextLine()) {
            lineAsCharArray = fileReader.nextLine().toCharArray();
            // Interating at line:
            for (int x = 0; x < lineAsCharArray.length; x++) {
                // Looking for the comma:
                if (lineAsCharArray[x] == ',') {
                    // Checking if this part of the char array is a number:
                    boolean afterCommaIsNum = false;
                    boolean beforeCommaIsNum = false;

                    for (int n = 0; n < numbers.length; n++) {
                        if (lineAsCharArray[x+1] == numbers[n]) afterCommaIsNum = true;
                        if (lineAsCharArray[x-1] == numbers[n]) beforeCommaIsNum = true;
                    }

                    // Validating if is num:
                    if (afterCommaIsNum && beforeCommaIsNum) {
                        // Replacing:
                        lineAsCharArray[x] = '.';
                    }
                }
            }
            printer.println(String.valueOf(lineAsCharArray));
        }
        // Closing everything:
        printer.close();
        fileWriter.close();
        fileReader.close();

        // Substituting the temp file to the original file
        Files.move(Paths.get(tempFile.getPath()), Paths.get(file.getPath()), StandardCopyOption.REPLACE_EXISTING);
    }
}