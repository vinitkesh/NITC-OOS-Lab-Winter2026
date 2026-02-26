
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Scanner sc = new Scanner(System.in);

       while(true){
            String input = sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            if(input.equals("oi")){
                throw new RuntimeException("That gay");
            }
            System.out.println("You entered: " + input);
       }
    }
}
