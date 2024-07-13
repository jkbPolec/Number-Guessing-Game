import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GameFrame extends JFrame implements ActionListener {

    private static JLabel timeField;
    private static JTextField inputField;
    private static JButton confirmButton;
    private static JTextField resultField;
    static long startTime = System.currentTimeMillis();

    public GameFrame() {
        super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        setLocation(700,200);
        setLayout(new GridLayout(4,1));

        timeField = createTimeField();
        add(timeField);

        inputField = new JTextField();
        Styling.AddFont(inputField);
        add(inputField);

        confirmButton = Styling.styledButton("Confirm");
        confirmButton.addActionListener(this);
        add(confirmButton);

        resultField = new JTextField("Guess the number :)");
        Styling.AddFont(resultField);
        resultField.setEditable(false);
        resultField.setFocusable(false);
        add(resultField);



        setVisible(true);
    }

    private JLabel createTimeField() {

        JLabel newField = new JLabel("60s");
        Styling.AddFont(newField, 72);
        newField.setHorizontalAlignment(JTextField.CENTER);
        return newField;
    }

    public static void updateResultField(String s) {
        resultField.setText(s);
    }

    public static void updateTimer() {
        if (timeField == null)
        {
            System.out.print(""); //nwm czemu jak tego nie ma, to okienko timeField nie wyswietla potem sekund
            return;
        }

        long currentTime = System.currentTimeMillis();
        long secondsPassed = (currentTime - startTime)/1000;

        timeField.setText((60 - secondsPassed) + "s");

        if (secondsPassed >= 60)
        {
            Main.EndGame();
            updateResultField("End of time :(");
        }
    }

    public static void disableInputs() {
        inputField.setEditable(false);
        confirmButton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == confirmButton)
        {
            int num;
            try {
                num = Integer.parseInt(inputField.getText());
                Main.checkNumber(num);
            }
            catch (Exception exc)
            {
                updateResultField("It isnt a number :<");
                System.err.println(exc);
            }



        }
    }
}
