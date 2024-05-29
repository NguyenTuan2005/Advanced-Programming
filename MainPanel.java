package Bai24_25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    public JButton red, blue, yellow, orange, clear, line, rectangle, oval;
    public JRadioButton fill;
    private boolean isStarted = false;
    private String type = "", command = "";
    private Color color;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public MainPanel() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(new PButton(), BorderLayout.EAST);
        add(new PShape(), BorderLayout.NORTH);
        add(new PDraw(), BorderLayout.CENTER);
    }
    
    public void getCommand(String command) {
    	this.command = command;
    }
    //Setting action events.
    public class ActionEvents implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	isStarted = false;
        	command = e.getActionCommand();
            switch (command) {
                case "clear all": {
                    shapes.clear();
                    repaint();
                    break;
                }
                case "line": {
                	type = "line";
                    break;
                }
                case "rectangle": {
                	type = "rectangle";
                    break;
                }
                case "oval": {
                	type = "oval";
                    break;
                }
                case "red": {
                	color = Color.RED;
                	break;
                }
                case "blue": {
                	color = Color.BLUE;
                	break;
                }
                case "yellow": {
                	color = Color.YELLOW;
                	break;
                }
                case "orange": {
                	color = Color.ORANGE;
                	break;
                }
            }
        }
    }

    class PButton extends JPanel {
        public PButton() {
            setLayout(new GridLayout(5, 1, 0, 20));
            setBackground(Color.CYAN);

            red = new JButton();
            red.setBackground(Color.RED);
            red.setActionCommand("red");
            red.addActionListener(new ActionEvents());
            blue = new JButton();
            blue.setBackground(Color.BLUE);
            blue.setActionCommand("blue");
            blue.addActionListener(new ActionEvents());
            yellow = new JButton();
            yellow.setBackground(Color.YELLOW);
            yellow.setActionCommand("yellow");
            yellow.addActionListener(new ActionEvents());
            orange = new JButton();
            orange.setBackground(Color.ORANGE);
            orange.setActionCommand("orange");
            orange.addActionListener(new ActionEvents());
            clear = new JButton("Clear All");
            clear.setMnemonic('A');
            clear.setActionCommand("clear all");
            clear.addActionListener(new ActionEvents());

            add(clear);
            JPanel PColor = new JPanel(new GridLayout(2, 2, 2, 2));
            PColor.add(red);
            PColor.add(blue);
            PColor.add(yellow);
            PColor.add(orange);
            add(PColor);
        }
    }

    class PShape extends JPanel {
        public PShape() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBackground(Color.CYAN);

            line = new JButton("Line");
            line.setMnemonic('L');
            line.setActionCommand("line");
            line.addActionListener(new ActionEvents());
            rectangle = new JButton("Rectangle");
            rectangle.setMnemonic('R');
            rectangle.setActionCommand("rectangle");
            rectangle.addActionListener(new ActionEvents());
            oval = new JButton("Oval");
            oval.setMnemonic('O');
            oval.setActionCommand("oval");
            oval.addActionListener(new ActionEvents());
            fill = new JRadioButton("Fill");
            fill.setMnemonic('I');
            add(line);
            add(rectangle);
            add(oval);
            add(fill);
        }
    }

    //Drawing part.
    class PDraw extends JPanel {
        public PDraw() {
            setBackground(Color.GRAY);
            addMouseListener(new MouseEvents());
            addMouseMotionListener(new MouseMotionEvents());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape i : shapes) {
                i.draw(g);
            }
        }
    }

    public class MouseMotionEvents extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            if (isStarted && !shapes.isEmpty()) {
                shapes.get(shapes.size() - 1).resize(e.getX(), e.getY());
            }
            repaint();
        }
    }

    public class MouseEvents extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (e.getButton() == MouseEvent.BUTTON1)
                isStarted = !isStarted;
            if (isStarted) {
                switch (type) {
                    case "line": {
                        shapes.add(new Line(e.getX(), e.getY(), color, fill.isSelected()));
                        break;
                    }
                    case "rectangle": {
                        shapes.add(new Rectangle(e.getX(), e.getY(), color, fill.isSelected()));
                        break;
                    }
                    case "oval": {
                        shapes.add(new Circle(e.getX(), e.getY(), color, fill.isSelected()));
                        break;
                    }
                }
            } else {
                //Fix bug shapes has no element.
                if (!shapes.isEmpty())
                    shapes.get(shapes.size() - 1).resize(e.getX(),e.getY());
                repaint();
            }
        }
    }
}
