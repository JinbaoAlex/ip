import java.util.Scanner;

public class Volkov {
    public static String basicResponse(String msg) {
        return "    ____________________________________________________________\n"
                + "    " + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    public static void main(String[] args) {
        String opening = "    ____________________________________________________________\n"
                + "    Hello! I'm Volkov\n"
                + "    What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println(opening);

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while(!command.equals("bye")) {
            String reply = basicResponse(command);
            System.out.println(reply);
            command = sc.nextLine();
        }
        String end = basicResponse("Bye. Hope to see you again soon!");
        System.out.println(end);
    }
}
