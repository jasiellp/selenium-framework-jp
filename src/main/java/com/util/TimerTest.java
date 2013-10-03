package com.util;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

 
public class TimerTest extends JPanel {

    
	private static final long serialVersionUID = 1L;

	JLabel label;

    JButton startButton;
    JButton stopButton;    
    
    DateFormat dateFormat;
    
    Calendar calendar;
    
    Timer timer;

    public TimerTest() {
        this.dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.calendar  =  Calendar.getInstance();
        this.calendar.set(Calendar.MILLISECOND, 0);
        this.calendar.set(Calendar.SECOND, 0);
        this.calendar.set(Calendar.MINUTE, 0);
        this.calendar.set(Calendar.HOUR_OF_DAY, 0);        
        
        this.initialize();
    }

    protected void initialize() {
        this.add(this.getLabel());
        this.add(this.getStartButton());
        this.add(this.getStopButton());
        this.go();
    }

    public JLabel getLabel() {
        if (this.label == null) {
            this.label = new JLabel(getTime());
            this.label.setPreferredSize(new Dimension(100, 22));
        }
        return this.label;
    }
    
    public JButton getStartButton() {
        if (this.startButton == null) {
            this.startButton = new JButton("Start");
            this.startButton.setPreferredSize(new Dimension(75, 22));
            this.startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {                    
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
            });
        }
        return this.startButton;
    }
    
    public JButton getStopButton() {
        if (this.stopButton == null) {
            this.stopButton = new JButton("Stop");
            this.stopButton.setPreferredSize(new Dimension(75, 22));
            this.stopButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {                    
                    if (timer.isRunning()) {
                        timer.stop();
                    }
                }
            });            
        }
        
        return this.stopButton;
    }

    public void go() {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TimerTest.this.label.setText(getTime());
            }
        };
        this.timer = new Timer(1000, action);
        this.timer.start();
    }

    public String getTime() {
        this.calendar.add(Calendar.SECOND, 1);
        return this.dateFormat.format(this.calendar.getTime());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new TimerTest());
        frame.setSize(300, 75);
        frame.setVisible(true);
    }
}
