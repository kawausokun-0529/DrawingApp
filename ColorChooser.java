import java.awt.*;
import java.awt.event.*;

import javax.swing.JColorChooser;

public class ColorChooser extends Frame{
    Color currentColor = Color.BLACK;

    public ColorChooser(DrawingApp da){
        setTitle("Choose the color");
        setSize(300, 200);

        Button colorButton = new Button("choose the color");
        colorButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                chooseColor();
            }
        });
        
        add(colorButton, "South");

        addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent e){
                saveFinalColor();
                applyColorExternally(da.defaultcolor, da.mc);
                //mc is not graphics class
                dispose();
            }
        });
    }

    public void chooseColor(){
        Color newColor = JColorChooser.showDialog(this, "choose the color", currentColor);
        if(newColor != null){
            currentColor = newColor;
            repaint();
        }
    }

    private void saveFinalColor(){
        System.out.println("final color : " + currentColor);
    }

    public void applyColorExternally(Color externalColor, MyCanvas mc){
        externalColor = currentColor;
        mc.clr = currentColor;
        repaint();
    }

    public void paint(Graphics g){
        g.setColor(currentColor);
        g.fillRect(50, 50, 100, 100);
    }
}
