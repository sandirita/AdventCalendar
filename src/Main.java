import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static boolean b;
    static int result;
    static int s;
    static int m;
    static HashSet<Integer> list = new HashSet<>();

    public static void main (String[] args) {
        try {
            File myObj = new File("input");
            Scanner myReader = new Scanner(myObj);
            while (true) {
                String data = myReader.nextLine();
                int number = Integer.parseInt(data);
                result = calibrate(number);
                if (b == true) break;
                if (myReader.hasNextLine() == false) {
                    myReader = new Scanner(myObj);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(m);
    }

    public static int calibrate(int input){
        s += input;
        if (!(list.add(s))) {
            m = s;
            b = true;
        };
        return s;
    }

}

