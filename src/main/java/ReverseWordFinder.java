import java.io.*;
import java.util.*;

/**
 * Created by surendar on 25/07/2017.
 */
public class ReverseWordFinder {

    public List<String> processMessage() {

        String str[] = getMessages("Message.txt");
        List<String> wordList = Arrays.asList(str);
        List<String> reverseWordList = new ArrayList<>();
        Set<String> matchWord = new HashSet<>();
        for (String st : str) {
            StringBuilder stringBuilder = new StringBuilder(st).reverse();
            reverseWordList.add(stringBuilder.toString());
        }

        for (String string : wordList) {
            if (reverseWordList.contains(string)) {
                matchWord.add(string);
            }
        }
        List<String> finalWords = new ArrayList<>(matchWord);

        Collections.sort(finalWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(finalWords);
        return finalWords;

    }

    public String[] getMessages(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        System.out.println(file.getAbsoluteFile());

        BufferedReader br = null;
        String line = "";
        String[] messageArray = null;
        try {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                messageArray = line.split(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return messageArray;

    }


}


