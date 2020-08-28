package org.akanami.innerclass.demolist;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Date;

public class TalkingClock {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(10000, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if(beep) {
                System.out.println("Beep");
            }
        }

        public TimePrinter() {

        }
    }
}
