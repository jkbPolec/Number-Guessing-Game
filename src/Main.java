import java.awt.*;
import javax.swing.Timer;
import java.util.Random;


public class Main {

    private static int randomNumber;
    private static MenuFrame menuFrame;
    private static GameFrame gameFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuFrame = new MenuFrame();

            }
        });

    }

    public static void switchFrames() {
        if (menuFrame != null) {
            menuFrame.setVisible(false);
            menuFrame.dispose();
        }

        Random rand = new Random();

        setRandomNumber(rand.nextInt(MenuFrame.getBottomValue(), MenuFrame.getTopValue()));

        if (gameFrame == null) {gameFrame = new GameFrame();}


        startTimer();
    }

    private static void startTimer() {
        Timer timer = new Timer(1000, e -> GameFrame.updateTimer());
        timer.start();
    }

    private static void setRandomNumber(int r) {
        randomNumber = r;
    }


    public static void checkNumber(int number) {
        if(number > randomNumber)
        {
            GameFrame.updateResultField(number + " is too high :<");
        }
        else if (number < randomNumber)
        {
            GameFrame.updateResultField(number + " is too low :<");
        }
        else {
            GameFrame.updateResultField(number + " is correct number :>");
            EndGame();
        }
    }

    public static void EndGame() {
        GameFrame.disableInputs();
    }

}