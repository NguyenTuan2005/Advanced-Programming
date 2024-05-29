package Bai24_25;

import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    public JMenu fileMenu, shapeMenu, colorMenu;
    public JMenuItem exit, oval, line, rectangle, red, blue ,yellow, orange;
    public MenuBar() {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        shapeMenu = new JMenu("Shape");
        shapeMenu.setMnemonic('S');
        colorMenu = new JMenu("Color");
        colorMenu.setMnemonic('C');
        exit = new JMenuItem("Exit");
//        exit.addActionListener(new ActionEvents());
        oval = new JMenuItem("Oval");
        line = new JMenuItem("Line");
        rectangle = new JMenuItem("Rectangle");
        red = new JMenuItem("Red");
        blue = new JMenuItem("Blue");
        yellow = new JMenuItem("Yellow");
        orange = new JMenuItem("Orange");

        fileMenu.add(exit);
        shapeMenu.add(oval);
        shapeMenu.add(line);
        shapeMenu.add(rectangle);
        colorMenu.add(red);
        colorMenu.add(blue);
        colorMenu.add(yellow);
        colorMenu.add(orange);
        add(fileMenu);
        add(shapeMenu);
        add(colorMenu);
    }
    /*
      To Be Continue....
     */
//    public class ActionEvents implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JMenuItem source = (JMenuItem) e.getSource();
//            if (source == exit) {
//                //Close the screen.
//                System.exit(0);
//            } else if (source == oval) {
//
//            }
//        }
//    }
}
