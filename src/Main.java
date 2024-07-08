import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();


            }
        });


        while (true)
        {
            MyFrame.updateTimer();
        }

//        Random rand = new Random();
//        Scanner sc = new Scanner(System.in);
//
//        int r = rand.nextInt(100);
//        System.out.println(r);
//
//        int input;
//        do {
//            input = sc.nextInt();
//            if (input < r) {
//                System.out.println("Too low");
//            }
//            else if (input > r) {
//                System.out.println("Too high");
//            }
//        } while (input != r);

    }


}
