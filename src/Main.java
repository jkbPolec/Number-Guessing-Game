import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class Main {

    private static int randomNumber;
    private static boolean gameRunning = true;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();

            }
        });

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        setRandomNumber(rand.nextInt(100));

        while (gameRunning)
        {
            MyFrame.updateTimer();
        }

    }

    private static void setRandomNumber(int r)
    {
        randomNumber = r;
    }

    public static void checkNumber(int number) {
        if(number > randomNumber)
        {
            MyFrame.updateResultField(number + " is too high :<");
        }
        else if (number < randomNumber)
        {
            MyFrame.updateResultField(number + " is too low :<");
        }
        else {
            MyFrame.updateResultField(number + " is correct number :>");
            EndGame();
        }
    }

    public static void EndGame() {
        gameRunning = false;
        MyFrame.disableInputs();
    }

}
