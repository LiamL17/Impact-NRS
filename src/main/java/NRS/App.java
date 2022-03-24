package NRS;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main( String[] args ) throws IOException {
        if (args.length == 1) {
            computeNRS(args[0]);
        } else if (args.length == 2) {
            if (args[0].equals("-f") || args[0].equals("--file")) {
                computeNRSWithFile(args[1]);
            } else {
                System.out.println(usage(args));
            }
        } else {
            System.out.println(usage(args));
        }
    }

    /**
     * Return a string that explains how the app should be used.
     *
     * @param args  String array of arguments passed to program
     * @return      String of info regarding how to use app
     */
    public static String usage(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid arguments: ").append(Arrays.asList(args)).append("\n");
        sb.append("Usage:\nApp [--file | -f] <relative fileName>\nApp <string>\n");
        sb.append("Example:\nApp --file src/main/resources/in1.txt\nApp 1,2,3,4,6,7,10");
        return sb.toString();
    }


    /**
     * Call the summarize function on an input string.
     *
     * @param string String used in summarizeCollection
     * @see NRS
     */
    public static void computeNRS(String string) {
        NRS nrs = new NRS();
        List<Integer> list = (List<Integer>) nrs.collect(string);
        System.out.println(nrs.summarizeCollection(list));
    }

    /**
     * Call the summarize function on for each of the lines of the file.
     *
     * @param fileName the relative path of the file
     * @see NRS
     */
    public static void computeNRSWithFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        NRS nrs = new NRS();

        String line;
        List<Integer> list;
        while ((line = br.readLine()) != null) {
            list = (List<Integer>) nrs.collect(line);
            System.out.println(nrs.summarizeCollection(list));
        }
        br.close();
    }
}
