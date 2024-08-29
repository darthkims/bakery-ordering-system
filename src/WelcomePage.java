import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame{

    public WelcomePage(){

        ImageIcon bg = new ImageIcon("src/bg.jpg");
        Image image = bg.getImage();
        Image newimg = image.getScaledInstance(500,700, Image.SCALE_SMOOTH);
        ImageIcon newbg = new ImageIcon(newimg);
        JLabel label = new JLabel(newbg);
        setContentPane(label);

        setTitle("Welcomepage");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel title1 = new JLabel("WELCOME TO ");
        title1.setFont(new Font("Harrington", Font.BOLD,30));
        title1.setForeground(Color.white);
        title1.setBounds(160,200,300,30);

        JLabel title2 = new JLabel("TRIPLE H BAKERY");
        title2.setFont(new Font("Harrington", Font.BOLD,30));
        title2.setForeground(Color.WHITE);
        title2.setBounds(120,250,300,50);

        JButton b = new JButton("START YOUR ORDER");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPage();
            }
        });
        b.setBounds(160,400, 180,50);

        add(title1);
        add(b);
        add(title2);
        //getContentPane().setBackground(Color.BLUE);
    }
}