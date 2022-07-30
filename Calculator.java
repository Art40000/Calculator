import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws CalcException {

        Scanner In = new Scanner(System.in);
        String expr;

        while (true) {
            System.out.println("Input:");
            expr = In.nextLine();
            Proc prc = new Proc(expr);
            System.out.println("Output:");
            if(prc.roman)
                System.out.println(prc.sRes);
            else
                System.out.println(prc.iRes);

        }
    }
}


