import java.util.Scanner;
/**
 * The {@code Ui} class deals with interactions with the
 * user by handling the formatting of responses,
 * reading user input, and displaying greeting messages.
 */
public class Ui {
    private Scanner sc = new Scanner(System.in);

    private final String newUserOpening = "    ____________________________________________________________\n"
            + "     Greetings user. I'm Volkov, your task manager\n"
            + "     What can I do for you?\n"
            + "    ____________________________________________________________\n";

    private final String returnUserOpening = "    ____________________________________________________________\n"
            + "     Welcome back!\n"
            + "     What can Volkov do for you?\n"
            + "    ____________________________________________________________\n";

    /**
     * Prints a formatted response.
     *
     * @param msg The message to be displayed after formatting.
     */
    public void formatResponse(String msg) {
        System.out.println(formatResponseString(msg));
    }

    /**
     * Formats a given message.
     *
     * @param msg The message to be formatted.
     * @return A formatted string of the given message
     */
    public String formatResponseString(String msg) {
        return "    ____________________________________________________________\n"
                + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    /**
     * Prints the formatted message for when a new task is added.
     * <p>
     * @param t The task that was added.
     * @param tasks The task list that the task is added to.
     */
    public void formatTaskMsg(Task t, TaskList tasks) {
        String msg = "     Roger. Task has been added to the list:\n"
                + "       " + t.toString() + "\n"
                + "     You now have " + tasks.size() + " tasks in the list.";
        System.out.println(formatResponseString(msg));
    }

    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Displays the new user greeting message.
     */
    public void newUserGreet() {
        System.out.println(newUserOpening);
    }

    /**
     * Displays the returning user greeting message.
     */
    public void returnUserGreet() {
        System.out.println(returnUserOpening);
    }
}
