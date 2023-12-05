import java.awt.*;
import java.awt.event.*;
//import java.awt.AWTEvent .*;
//import javax.swing.*;
//import javax.swing.event.*;


public class DrawingApp extends Frame implements ActionListener{
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8;
    Panel pnl;
    //int red, green, blue;
    MyCanvas mc;
    Color defaultcolor;

    public static void main(String[] args){
        DrawingApp da = new DrawingApp();
    }

    DrawingApp(){
        super("Drawing Application");
        this.setSize(900, 600);

        pnl = new Panel();
        mc = new MyCanvas(this);

        this.setLayout(new BorderLayout(10, 10));
        this.add(pnl, BorderLayout.EAST);
        this.add(mc, BorderLayout.CENTER);

        pnl.setLayout(new GridLayout(9,1));
        bt1 = new Button("Free Hand");
        bt1.addActionListener(this);
        pnl.add(bt1);
        bt2 = new Button("Line");
        bt2.addActionListener(this);
        pnl.add(bt2);
        bt3 = new Button("Rectangle");
        bt3.addActionListener(this);
        pnl.add(bt3);
        bt4 = new Button("FillRectangle");
        bt4.addActionListener(this);
        pnl.add(bt4);
        bt5 = new Button("Oval");
        bt5.addActionListener(this);
        pnl.add(bt5);
        bt6 = new Button("FillOval");
        bt6.addActionListener(this);
        pnl.add(bt6);
        bt7 = new Button("Delete");
        bt7.addActionListener(this);
        pnl.add(bt7);
        bt8 = new Button("Color");
        bt8.addActionListener(this);
        pnl.add(bt8);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bt1){
            mc.mode = 1;
        }else if(e.getSource() == bt2){
            mc.mode = 2;
        }else if(e.getSource() == bt3){
            mc.mode = 3;
        }else if(e.getSource() == bt4){
            mc.mode = 4;
        }else if(e.getSource() == bt5){
            mc.mode = 5;
        }else if(e.getSource() == bt6){
            mc.mode = 6;
        }else if(e.getSource() == bt7){
            mc.mode = 7;
        }else if(e.getSource() == bt8){
            ColorChooser colorChooser = new ColorChooser(this);
            colorChooser.setVisible(true);
        }
    }
}