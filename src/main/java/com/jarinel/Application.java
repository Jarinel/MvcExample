package com.jarinel;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() throws HeadlessException {
        this.setTitle("MVC");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);

        this.setLocationRelativeTo(null);
    }
}
