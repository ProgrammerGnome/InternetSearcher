package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Bomber extends TimerTask {
    //https://pte.hu/hu
    public void run(){

        FrontEnd frontEnd = new FrontEnd();
        BackEnd backEnd = new BackEnd();

        String x = frontEnd.txtBox.getText();
        String y = frontEnd.txtBox2.getText();

        try {
            backEnd.fun(x,y);
        } catch(Exception e) {
            Timer timer = new Timer();
            TimerTask timerTask = new Bomber();
            timer.schedule(timerTask, 10000L, 10000L);
        }

    }
}
