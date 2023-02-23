import java.util.Scanner;

public class Lab4 {

    static String ACNO = "";
    static String ACNAME = "";
    static String BAL = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] transact = new String[1024]; // Stores 1. if deposit 2. if credit
        Character choice;
        Character yes = 'y';
        Character no = 'n';
        int i;
        int j = 0;
        double startbal=0.0;

        for (i = 0;; i++) {

            System.out.println("1. To initialize the customer");
            System.out.println("2. To deposit money");
            System.out.println("3. To withdraw money");
            System.out.println("4. To print the transactions");
            System.out.println("5. To print account summary");
            int k = Integer.parseInt(sc.next());

            switch (k) {
                case 1:
                    String[] output = initialise();
                    startbal=Double.parseDouble(BAL);
                    break;

                case 2:
                    double[] baldep = deposit();
                    BAL = Double.toString(baldep[0]);
                    System.out.println("New Balance: " + BAL);

                    transact[j] = Double.toString(baldep[1]);
                    j++;

                    // for (;;i++){
                    // transact[i]=Double.toString(baldep[1]) ;
                    // }

                    break;

                case 3:
                    double[] balwit = withdraw();
                    BAL = Double.toString(balwit[0]);
                    System.out.println("New Balance: " + BAL);
                    String withdraw = "";
                    withdraw = "-" + Double.toString(balwit[1]);
                    transact[j] = withdraw;
                    j++;
                    break;

                case 4:
                    transaction(transact, j, startbal);

                    // for (int l = 0; l < j; l++) {

                    // System.out.println(transact[l]);

                    // }

                    break;

                case 5:
                    summary();

                    break;

                default:
                    System.out.println("Invalid Choice. Please Enter the coorect option");

            }
            System.out.println("Press 'Y' to continue, 'N' to Exit: ");
            choice = sc.next().charAt(0);

            if (choice.equals(yes)) {
                continue;
            } else if (choice.equals(no)) {
                break;
            }
        }
    }

    public static String[] initialise() {

        System.out.println("Enter Account Name: ");
        ACNAME = sc.next();
        System.out.println("Enter Account Number: ");
        ACNO = sc.next();
        System.out.println("Enter Account Balance: ");
        BAL = sc.next();

        String[] init = { ACNAME, ACNO, BAL };

        return init;
    }

    public static double[] deposit() {

        // changing BAL from String to Numeric for easier mathematical Operation

        double balance = Double.parseDouble(BAL);

        System.out.println("Enter the amount you want to deposit: ");
        double dep = Double.parseDouble(sc.next());

        balance = balance + dep;

        double[] summ = { balance, dep };

        return summ;

    }

    public static double[] withdraw() {

        double balance = Double.parseDouble(BAL);
        System.out.println("Enter the amount you want to withdraw");
        double wit = Double.parseDouble(sc.next());

        balance = balance - wit;
        double[] summ = { balance, wit };

        return summ;

    }

    public static void transaction(String b[], int p, double z) {

        for (int e = 0; e < p; e++) {
            double element = Double.parseDouble(b[e]);
            if (element < 0) {
                element=-element;
                System.out.println("Transaction: " + (e + 1));
                System.out.println("Debit: " + element);
                z=z-element;
                System.out.println("New Balance: "+z);
                // System.out.println("New Balance: " + Double.parseDouble(BAL));
            } else if (element > 0) {
                System.out.println("Transaction: " + (e + 1));
                System.out.println("Credit: " + element);
                z=z+element;
                System.out.println("New Balance: "+z);

            }
        }

    }

    public static void summary() {
        System.out.println("Account Name: " + ACNAME);
        System.out.println("Account Number: " + ACNO);
        System.out.println("Account Balance: " + BAL);
    }

}
