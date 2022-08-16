package Unit9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();
//        screen.addWindowListener((WindowListener)(e) ->System.exit(1));

        screen.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(1);
            }});

        Button button = new Button("Press me");

        screen.add(button);

//        button.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"Welcome to Java by Example",
//                        "Java Sample",JOptionPane.INFORMATION_MESSAGE);
//            }
//        });

        button.addActionListener(e ->
                {
                    JOptionPane.showMessageDialog(null, "Welcome to Java by Example",
                            "Java Sample", JOptionPane.INFORMATION_MESSAGE);
                }
               );
        screen.setSize(250, 400);
        screen.setVisible(true);
    }
}

interface WindowClosing extends WindowListener{
    public default void windowOpened(WindowEvent e){};
    public default void windowconifiled(WindowEvent e){};
    public default void windowDeiconified(WindowEvent e){};
    public default void windowActivated(WindowEvent e){};
    public default void windowDeactivated(WindowEvent e){};
    public default void windowClosed(WindowEvent e){};
}
