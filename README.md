User Guide – Replacer

Purpose:
Fix numbers with decimal commas (e.g., 12,34) in .txt files by replacing only the comma between digits with a dot (12.34). Other commas remain unchanged.

1. Project Structure:
Place the Replacer class inside a working Java project. The input file should be located at the correct path (e.g., src/file.txt).

2. How to Use the Function:
In your main method, call it like this:

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/file.txt");
        Replacer.doubleReplacer(file);
    }
}

3. How It Works:
Reads the file line by line.
Scans each character looking for commas.
If a comma is found between digits, it replaces that specific comma with a dot.
Writes the modified lines to a temporary file.
Replaces the original file with the corrected one.

4. Notes:
The input file must exist at the specified path.
Only commas between digits are changed (e.g., 12,34 becomes 12.34, but value, total stays the same).
Does not use any external libraries or regex.
Ensures number formatting is compatible with double type in Java.
