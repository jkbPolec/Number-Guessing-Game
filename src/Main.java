import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class Main {

    private static int randomNumber;
    private static boolean gameRunning = true;
    private static MenuFrame menuFrame;
    private static GameFrame gameFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuFrame();


            }
        });



        while (gameRunning)
        {
            GameFrame.updateTimer();
        }

    }

    public static void switchFrames() {
        if (menuFrame != null) {
            menuFrame.setVisible(false);
            menuFrame.dispose();
        }

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        setRandomNumber(rand.nextInt(MenuFrame.getBottomValue(), MenuFrame.getTopValue()));


        gameFrame = new GameFrame();
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
        gameRunning = false;
        GameFrame.disableInputs();
    }

}