import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static boolean b;
    static int result;
    static int s;
    static int m;
    static HashSet<Integer> list = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
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
        System.out.println(checksum());
        System.out.println(differByOne());
    }

    public static int calibrate(int input) {
        s += input;
        if (!(list.add(s))) {
            m = s;
            b = true;
        }
        ;
        return s;
    }

    public static int checksum() throws FileNotFoundException {
        File myObjID = new File("inputIDs");
        Scanner myReader = new Scanner(myObjID);
        int a = 0;
        int d = 0;
        while (myReader.hasNextLine()) {
            HashMap<Character, Integer> characterCount = new HashMap<>();
            String data = myReader.nextLine();
            for (char c : data.toCharArray()) {
                if (characterCount.containsKey(c)) {
                    characterCount.put(c, (characterCount.get(c)) + 1);
                } else {
                    characterCount.put(c, 1);
                }
            }
            if (characterCount.containsValue(2)) {
                a += 1;
            }
            if (characterCount.containsValue(3)) {
                d += 1;
            }

        }
        return a * d;
    }

    public static String differByOne() throws FileNotFoundException {
        File myObjID = new File("inputIDs");
        Scanner myReader = new Scanner(myObjID);

        while (myReader.hasNextLine()) {

            String dataA = myReader.nextLine();
            Scanner Reader = new Scanner(myObjID);

            while (Reader.hasNextLine()) {

                String dataB = Reader.nextLine();
                int number = 0;
                String result = "";

                for (int i = 0; i < dataA.length(); i++) {
                    if (dataA.charAt(i) != dataB.charAt(i)) {
                        number += 1;
                    } else {
                        result += dataA.charAt(i);
                    }
                }
                if (number == 1) {
                    return result;
                }
            }
        } return "not found";
    }
}
