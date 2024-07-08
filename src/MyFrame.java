import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JTextField;
import java.awt.GridLayout;



public class MyFrame extends JFrame {

    private static JTextField timeField;
    private static JTextField inputField;
    static long startTime = System.currentTimeMillis();

    public MyFrame() {
        super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        setLocation(700,200);
        setLayout(new GridLayout(4,1));

        add(new JButton("Button 1"));
//        add(new JButton("Button 2"));
//        add(new JButton("Button 3"));

        timeField = createTimeField();
        add(timeField);

        inputField = new JTextField(10);


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



    public static void updateTimer()
    {
        if (timeField == null)
        {
            System.out.print(""); //nwm czemu jak tego nie ma, to okienko timeField nie wyswietla potem sekund
            return;
        }

        long currentTime = System.currentTimeMillis();
        long secondsPassed = (currentTime - startTime)/1000;

        timeField.setText((60 - secondsPassed) + "s");
    }
}
