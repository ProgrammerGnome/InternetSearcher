package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchLogic {
    public void fun(String search, String url) {
        DataManagement x = new DataManagement();
        String variable = x.wow(search, url);

        // print response body
        System.out.println(variable);

        String[] words = variable.split("\\s+");

        // Ellenőrizzük, hogy a keresett rész megtalálható-e a szavak között

        System.out.println("\n\n\n");
        ArrayList<String> links = new ArrayList<>();
        for (String word : words) {
            if (word.contains(search)) {
                //System.out.println("Találat: " + word);
                links.add(word);
            }
        }

        String regexPattern = "(https?|ftp)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}(/\\S*)?";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher; //= pattern.matcher("");

        for (String s : links) {
            System.out.println(s);

            String modifiedString = s.replace('"', ' ');

            matcher = pattern.matcher(modifiedString);
            System.out.println(modifiedString);
            if (matcher.find()) {
                String extractedLink = matcher.group();
                System.out.println("Extracted link: " + extractedLink);
                String corrS = extractedLink.replace("http", "https");
                //x.wow("szolgaltatas", corrS);
                System.out.println(x.wow("szolgaltatas", corrS));
            } else {
                System.out.println("No link found.");
            }
            //...
        }

    }
}
