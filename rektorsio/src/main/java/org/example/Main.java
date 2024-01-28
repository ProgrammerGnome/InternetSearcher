package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        //The application's drvier code
        System.out.println("Hello world!");
        FrontEnd frontEnd = new FrontEnd();
        frontEnd.MainWindow();

        //ide jön az időzítős rész
        Timer timer = new Timer();
        TimerTask timerTask = new Bomber();
        timer.schedule(timerTask, 10000L, 20000L);

        System.out.println("Ezaz ami nem működött: " + frontEnd.txtBox.getText() + frontEnd.txtBox2.getText());

    }
}