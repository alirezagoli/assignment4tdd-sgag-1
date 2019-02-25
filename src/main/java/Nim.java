import java.util.Scanner;

public class Nim {


    public Nim() {

    }

    public boolean isInteger(String s) {
        Scanner sc = new Scanner(s.trim());
        if (!sc.hasNextInt(10)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(10);
        return !sc.hasNext();
    }
}
