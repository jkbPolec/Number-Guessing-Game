import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyFrame extends JFrame implements ActionListener {

    private static JTextField timeField;
    private static JTextField inputField;
    private static JButton confirmButton;
    private static JTextField resultField;
    static long startTime = System.currentTimeMillis();

    public MyFrame() {
        super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        setLocation(700,200);
        setLayout(new GridLayout(4,1));

        timeField = createTimeField();
        add(timeField);

        inputField = new JTextField();
        Font font = new Font("Arial", Font.PLAIN, 36);
        inputField.setFont(font);
        add(inputField);

        confirmButton = new JButton("Confirm");
        confirmButton.setFont(font);
        confirmButton.addActionListener(this);
        add(confirmButton);

        resultField = new JTextField("Guess the number :)");
        resultField.setFont(font);
        add(resultField);


        setVisible(true);
    }

    private JTextField createTimeField() {

        JTextField newField = new JTextField("pookie");
        Font timeFieldFont = newField.getFont();
        Font biggerTimeFieldFont = timeFieldFont.deriveFont(72.0f);
        newField.setFont(biggerTimeFieldFont);
        newField.setBorder(null);
        newField.setEditable(false);
        newField.setFocusable(false);
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

    public static void disableInputs()
    {
        inputField.setEditable(false);
        confirmButton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == confirmButton)
        {
            Main.checkNumber(Integer.parseInt(inputField.getText()));
        }
    }
}
