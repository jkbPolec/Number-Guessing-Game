import javax.swing.*;
import java.awt.*;

public class Styling {

    private static Font font = new Font("Arial", Font.PLAIN, 36);

    public static JButton styledButton(String buttonText) {
        JButton newButton = new JButton(buttonText);
        AddFont(newButton);
        newButton.setForeground(Color.WHITE);
        newButton.setBackground(new Color(70, 130, 180));
        newButton.setFocusPainted(false);
        newButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return newButton;
    }

    public static void AddFont(Component comp) {
        comp.setFont(font);
    }

    public static void AddFont(Component comp, float size) {
        Font tempFont = font.deriveFont(size);
        comp.setFont(tempFont);
    }


}
