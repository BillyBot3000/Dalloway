import java.io.*;
import java.util.*;

public class Dalloway {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("dalloway.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found lmao");
            System.exit(1);
        }

        // get sentences
        ArrayList<String> sentences = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineSentences = line.split("\\. |\\? |\\! ");
            for (String sentence : lineSentences) {
                sentences.add(sentence);
            }
        }

        scanner.close();

        // output to csv
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("output.csv"));
            bw.write("index,character count,word count\n");
            for (int i = 0; i < sentences.size(); i++) {
                bw.write(i + "," + sentences.get(i).length() + "," + sentences.get(i).split(" ").length + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
            System.exit(1);
        }
    }
}
