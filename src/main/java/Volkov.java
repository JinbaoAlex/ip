import java.util.Scanner;

public class Volkov {
    private static Task[] listOfTasks = new Task[100];
    private static int storeTaskIndex = 0;
    public static String formatResponse(String msg) {
        return "    ____________________________________________________________\n"
                + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    public static void main(String[] args) {
        String opening = "    ____________________________________________________________\n"
                + "     Hello! I'm Volkov\n"
                + "     What can I do for you?\n"
                + "    ____________________________________________________________\n";
        System.out.println(opening);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println(formatResponse("     Bye. Hope to see you again soon!"));
                break;
            } else if (input.equals("list")) {
                StringBuilder sb = new StringBuilder();
                boolean first = true;
                for (int i = 0; i < storeTaskIndex; i++) {
                    if (first) {
                        first = false;
                    } else {
                        sb.append("\n");
                    }
                    sb.append("    " + listOfTasks[i]);
                }
                System.out.println(formatResponse(sb.toString()));
            } else if (input.startsWith("mark")) {
                int taskNo = Integer.parseInt(input.substring(5));
                listOfTasks[taskNo].markAsDone();
                String reply = "     Nice! I've marked this task as done:\n"
                        + "       " + listOfTasks[taskNo].toString();
                System.out.println(formatResponse(reply));
            } else if (input.startsWith("unmark")) {
                int taskNo = Integer.parseInt(input.substring(7));
                listOfTasks[taskNo].unmarkAsDone();
                String reply = "     OK, I've marked this task as not done yet:\n"
                        + "       " + listOfTasks[taskNo].toString();
                System.out.println(formatResponse(reply));
            } else {
                String reply = formatResponse("     " + input);
                System.out.println(reply);
                Task t = new Task(input);
                listOfTasks[storeTaskIndex] = t;
                storeTaskIndex++;
            }
        }
    }
}
