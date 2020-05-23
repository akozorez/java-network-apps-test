package question4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorldSwing extends JFrame {

    private JTextField textField;

    public HelloWorldSwing() {
        super("Hello world!");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton helloButton = new JButton("sayHello");
        helloButton.setActionCommand("Hello world!");
        panel.add(helloButton);

        textField = new JTextField();
        textField.setColumns(23);
        panel.add(textField);

        helloButton.addActionListener(new sayHello());

        getContentPane().add(panel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(dim.width/2, dim.height/2));
    }

    public class sayHello implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField.setText(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                HelloWorldSwing frame = new HelloWorldSwing();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}