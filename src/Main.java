import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String file1 = buffer.readLine();          // file to read
        String file2 = buffer.readLine();          // file to write
        BufferedReader buffR = new BufferedReader(new FileReader(file1));
        BufferedWriter buffW = new BufferedWriter(new FileWriter(file2));
        ArrayList<String> strings = new ArrayList<>();
        while (buffR.ready()) strings.add(buffR.readLine());
        for (int i = 0; i < strings.size(); i++) {
            String[] words = strings.get(i).split(" ");
            for (int j = 0; j < words.length; j++) {
                try {                           // if number have a symbol, like 2d3 or 22f Java create Number format exception
                    int jj = Integer.parseInt(words[j]);
                    buffW.write(jj + " ");
                } catch (NumberFormatException e) {          // catch exception, and repeat cycle
                    continue;
                }

            }
        }


        buffW.close();                 // close all used buffers, to free used memory
        buffR.close();
        buffer.close();
    }
}