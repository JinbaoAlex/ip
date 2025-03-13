import java.util.Scanner;

public class Ui {
    private Scanner sc = new Scanner(System.in);

    private final String newUserOpening = "    ____________________________________________________________\n"
            + "     Hello! I'm Volkov\n"
            + "     What can I do for you?\n"
            + "    ____________________________________________________________\n";

    private final String returnUserOpening = "    ____________________________________________________________\n"
            + "     Welcome back!\n"
            + "     What can Volkov do for you?\n"
            + "    ____________________________________________________________\n";

    public void formatResponse(String msg) {
        System.out.println(formatResponseString(msg));
    }

    public String formatResponseString(String msg) {
        return "    ____________________________________________________________\n"
                + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    public void formatTaskMsg(Task t, TaskList tasks) {
        String msg = "     Got it. I've added this task:\n"
                + "       " + t.toString() + "\n"
                + "     Now you have " + tasks.size() + " tasks in the list.";
        System.out.println(formatResponseString(msg));
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void newUserGreet() {
        System.out.println(newUserOpening);
    }

    public void returnUserGreet() {
        System.out.println(returnUserOpening);
    }
}
