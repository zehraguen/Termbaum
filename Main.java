import java.util.*;

public class Main
{
    private static Scanner meinScanner;
    private static Termbaum meinTermbaum;

    public static void main(String[] args)
    {
        Scanner meinScanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Termbaum");
            System.out.println("------------------");
            System.out.println();
            System.out.println("1. Termbaum aus Term erstellen");
            System.out.println("2. Term aus Termbaum erstellen");
            System.out.println("3. PN aus Termbaum erstellen");
            System.out.println("4. UPN aus Termbaum erstellen");
            System.out.println("5. Programm beenden");
            System.out.println();
            System.out.println("Waehle einen Menuepunkt aus.");
            System.out.println();

            int eingabe = meinScanner.nextInt();
            System.out.println();

            if (eingabe == 1)
            {
                System.out.println();
                System.out.println("Welcher Term soll in einen Termbaum überführt werden?");
                System.out.println();
                String eingegebenerTerm = meinScanner.next();
                TermbaumPflanzer mTBP = new TermbaumPflanzer(eingegebenerTerm);
                meinTermbaum = new Termbaum(mTBP.baum());
                System.out.println();
            }
            if (eingabe == 2)
            {
                System.out.println();
                System.out.println("Der Term zu dem gespeicherten Termbaum lautet: "+meinTermbaum.alsTerm());
                System.out.println();
            }
            if (eingabe == 3)
            {

            }
            if (eingabe == 4)
            {
                System.out.println();
                System.out.println("Der Term zu dem gespeicherten Termbaum lautet: "+meinTermbaum.inUPN());
                System.out.println();
            }
            if (eingabe == 5)
            {
                System.exit(0);
            }
        }
    }
}
