import java.util.Scanner;

public class Volkov {
    private static Task[] listOfTasks = new Task[100];
    private static int storeTaskIndex = 0;
    public static String formatResponse(String msg) {
        return "    ____________________________________________________________\n"
                + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    public static String formatTaskMsg(Task t) {
        listOfTasks[storeTaskIndex] = t;
        storeTaskIndex++;
        String msg = "     Got it. I've added this task:\n"
                + "       " + t.toString() + "\n"
                + "     Now you have " + storeTaskIndex + " tasks in the list.";
        return formatResponse(msg);
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
                sb.append("     Here are the tasks in your list:\n");
                for (int i = 0; i < storeTaskIndex; i++) {
                    if (first) {
                        first = false;
                    } else {
                        sb.append("\n");
                    }
                    sb.append("     ").append(i + 1).append(".").append(listOfTasks[i]);
                }
                System.out.println(formatResponse(sb.toString()));

            } else if (input.startsWith("mark")) {
                int taskNo = Integer.parseInt(input.substring(5)) - 1;
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

            } else if (input.startsWith("todo")) {
                String taskDesc = input.substring(5);
                Todo t = new Todo(taskDesc);
                System.out.println(formatTaskMsg(t));

            } else if (input.startsWith("deadline")) {
                int indexOfDeadline = input.indexOf(" /by");
                String taskDesc = input.substring(9, indexOfDeadline);
                String deadline = input.substring(indexOfDeadline + 4);
                Deadline t = new Deadline(taskDesc, deadline);
                System.out.println(formatTaskMsg(t));

            } else if (input.startsWith("event")) {
                int indexOfStartDate = input.indexOf(" /from");
                int indexOfEndDate = input.indexOf(" /to");
                String taskDesc = input.substring(6, indexOfStartDate);
                String startDate = input.substring(indexOfStartDate + 6, indexOfEndDate);
                String endDate = input.substring(indexOfEndDate + 4);
                Event t = new Event(taskDesc, startDate, endDate);
                System.out.println(formatTaskMsg(t));

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
