package org.example.display;

import org.example.Main;
import org.example.constant.ConstantsMain;

import javax.swing.*;
import java.awt.*;

public class Window {
    private int width;
    private int height;
    private JFrame frame;
    private Main main;


    public Window(int width, int height, Main main) {
        this.width = width;
        this.height = height;
        this.main = main;

        init();
    }

    private void init(){
        if(this.frame == null){
            this.frame = new JFrame();
        }

        this.frame.setPreferredSize(new Dimension(this.width, this.height));
        this.frame.setMaximumSize(new Dimension(this.width, this.height));
        this.frame.setMinimumSize(new Dimension(this.width, this.height));

        this.frame.setTitle(ConstantsMain.TITLE);

        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(this.main);
        this.frame.pack();
    }


}
