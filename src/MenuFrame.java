import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {

    private static JButton playButton;
    private static JButton exitButton;

    private static JTextField bottomValue;
    private static JTextField topValue;

    public MenuFrame ()
    {
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        setLocation(700,200);
        setLayout(new GridLayout(4,1));

        playButton = Styling.styledButton("Play");
        playButton.addActionListener(this);
        add(playButton);

        JPanel panel = new JPanel();

        bottomValue = new JTextField(5);
        Styling.AddFont(bottomValue);
        bottomValue.setText("0");
        topValue = new JTextField(5);
        Styling.AddFont(topValue);
        topValue.setText("100");

        JLabel label = new JLabel("From");
        Styling.AddFont(label);

        JLabel label2 = new JLabel("to");
        Styling.AddFont(label2);

        JLabel byLabel = new JLabel("Projekt by jkbPolec :>");
        Styling.AddFont(byLabel);
        byLabel.setHorizontalAlignment(JTextField.CENTER);


        panel.add(label);
        panel.add(bottomValue);
        panel.add(label2);
        panel.add(topValue);
        add(panel);


        add(byLabel);

        exitButton = Styling.styledButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);


        setVisible(true);
    }

    public static int getBottomValue() {return Integer.parseInt(bottomValue.getText());}
    public static int getTopValue() {return Integer.parseInt(topValue.getText());}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == playButton) {
            Main.switchFrames();
        }
        if (source == exitButton) {
            System.exit(0);
        }
    }
}
