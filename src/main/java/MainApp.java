import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nod nod = new Nod(sc.nextInt(), sc.nextInt());
        System.out.println(nod.getNod());

    }
}
