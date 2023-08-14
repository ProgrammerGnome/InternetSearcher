package org.example;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*
        DataManagement x = new DataManagement();
        x.wow("szolgaltatas");
        */
        SearchLogic searchLogic = new SearchLogic();
        //searchLogic.fun("szolgaltatas", "https://innoteq.hu/");

        int counter = 0;
        while(counter != 3) {
            searchLogic.fun("szolgaltatas", "https://innoteq.hu/");
            counter++;
        }

    }
}