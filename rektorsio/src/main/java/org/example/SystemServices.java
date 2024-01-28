package org.example;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SystemServices {

    SystemTray tray = SystemTray.getSystemTray();
    Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
    TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");

    public void SystemMessage() {

        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        trayIcon.displayMessage("Hello, World", "notification demo", TrayIcon.MessageType.WARNING);
        //end
    }

    public void SystemAlarm() {

        File audioFile = new File("beep.wav");
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(1.0f); // Reduce volume by 10 decibels.

        FrontEnd frontEnd = new FrontEnd();
        clip.start();
            //Thread.sleep(clip.getMicrosecondLength() / 1000);
        try {
            if (frontEnd.jButton.getModel().isPressed() == false) {
                Thread.sleep(10000);
                //frontEnd.jButton.doClick(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clip.close();
        //end

    }
}
