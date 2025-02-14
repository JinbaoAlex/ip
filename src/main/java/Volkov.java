import java.util.Scanner;

public class Volkov {
    private static Task[] listOfTasks = new Task[100];
    private static int listOfTasksIndex = 0;

    private static final int MARK_CMD_LENGTH = 5;
    private static final int UNMARK_CMD_LENGTH = 7;
    private static final int TODO_CMD_LENGTH = 5;
    private static final int DEADLINE_CMD_LENGTH = 8;
    private static final int EVENT_CMD_LENGTH = 5;
    private static final int DEADLINE_BY_LENGTH = 4;
    private static final int EVENT_FROM_LENGTH = 6;
    private static final int EVENT_TO_LENGTH = 4;

    private static final String BYE_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";
    private static final String MARK_COMMAND = "mark";
    private static final String UNMARK_COMMAND = "unmark";
    private static final String TODO_COMMAND = "todo";
    private static final String DEADLINE_COMMAND = "deadline";
    private static final String EVENT_COMMAND = "event";
    private static final String BY_KEYWORD = "/by";
    private static final String FROM_KEYWORD = "/from";
    private static final String TO_KEYWORD = "/to";

    public static String formatResponse(String msg) {
        return "    ____________________________________________________________\n"
                + msg + "\n"
                + "    ____________________________________________________________\n";
    }

    public static String formatTaskMsg(Task t) {
        listOfTasks[listOfTasksIndex] = t;
        listOfTasksIndex++;
        String msg = "     Got it. I've added this task:\n"
                + "       " + t.toString() + "\n"
                + "     Now you have " + listOfTasksIndex + " tasks in the list.";
        return formatResponse(msg);
    }

    public static void doByeCommand() {
        System.out.println(formatResponse("     Bye. Hope to see you again soon!"));
    }

    public static void doListCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("     Here are the tasks in your list:");
        for (int i = 0; i < listOfTasksIndex; i++) {
            sb.append("\n     ").append(i + 1).append(".").append(listOfTasks[i]);
        }
        System.out.println(formatResponse(sb.toString()));
    }

    public static void doMarkCommand(String input) {
        try {
            int taskNo = Integer.parseInt(input.substring(MARK_CMD_LENGTH)) - 1;
            listOfTasks[taskNo].markAsDone();
            String reply = "     Nice! I've marked this task as done:\n"
                    + "       " + listOfTasks[taskNo].toString();
            System.out.println(formatResponse(reply));
        } catch (NullPointerException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            System.out.println(formatResponse(reply));
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            System.out.println(formatResponse(reply));
        }
    }

    public static void doUnmarkCommand(String input) {
        try {
            int taskNo = Integer.parseInt(input.substring(UNMARK_CMD_LENGTH)) - 1;
            listOfTasks[taskNo].unmarkAsDone();
            String reply = "     OK, I've marked this task as not done yet:\n"
                    + "       " + listOfTasks[taskNo].toString();
            System.out.println(formatResponse(reply));
        } catch (NullPointerException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            System.out.println(formatResponse(reply));
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            System.out.println(formatResponse(reply));
        }
    }

    public static void doTodoCommand(String input) {
        try {
            String taskDesc = input.substring(TODO_CMD_LENGTH);
            if (taskDesc.trim().isEmpty()) {
                throw new MissingDescription("MISSING DESCRIPTION, reenter with description");
            }
            Todo t = new Todo(taskDesc);
            System.out.println(formatTaskMsg(t));
        } catch (MissingDescription e) {
            System.out.println(formatResponse("     " + e.getMessage()));
        }
    }

    public static void doDeadlineCommand(String input) {
        try {
            int indexOfDeadline = input.indexOf(BY_KEYWORD);
            if (indexOfDeadline == -1) {
                throw new MissingKeyword("MISSING '/by' keyword");
            }
            String taskDesc = input.substring(DEADLINE_CMD_LENGTH, indexOfDeadline - 1).trim();
            if (taskDesc.trim().isEmpty()) {
                throw new MissingDescription("MISSING DESCRIPTION, reenter with description");
            }
            String deadline = input.substring(indexOfDeadline - 1 + DEADLINE_BY_LENGTH).trim();
            Deadline t = new Deadline(taskDesc, deadline);
            System.out.println(formatTaskMsg(t));
        } catch (MissingDescription | MissingKeyword e) {
            System.out.println(formatResponse("     " + e.getMessage()));
        }
    }

    public static void doEventCommand(String input) {
        try {
            int indexOfStartDate = input.indexOf(FROM_KEYWORD);
            if (indexOfStartDate == -1) {
                throw new MissingKeyword("MISSING '/from' keyword");
            }
            int indexOfEndDate = input.indexOf(TO_KEYWORD);
            if (indexOfEndDate == -1) {
                throw new MissingKeyword("MISSING '/to' keyword");
            }
            String taskDesc = input.substring(EVENT_CMD_LENGTH, indexOfStartDate - 1).trim();

            if (taskDesc.trim().isEmpty()) {
                throw new MissingDescription("MISSING DESCRIPTION, reenter with description");
            }

            String startDate = input.substring(indexOfStartDate - 1 + EVENT_FROM_LENGTH, indexOfEndDate - 1).trim();
            String endDate = input.substring(indexOfEndDate - 1 + EVENT_TO_LENGTH).trim();
            Event t = new Event(taskDesc, startDate, endDate);
            System.out.println(formatTaskMsg(t));
        } catch (MissingDescription | MissingKeyword e) {
            System.out.println(formatResponse("     " + e.getMessage()));
        }
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

            if (input.equals(BYE_COMMAND)) {
                doByeCommand();
                break;

            } else if (input.equals(LIST_COMMAND)) {
                doListCommand();

            } else if (input.startsWith(MARK_COMMAND)) {
                doMarkCommand(input);

            } else if (input.startsWith(UNMARK_COMMAND)) {
                doUnmarkCommand(input);

            } else if (input.startsWith(TODO_COMMAND)) {
                doTodoCommand(input);

            } else if (input.startsWith(DEADLINE_COMMAND)) {
                doDeadlineCommand(input);

            } else if (input.startsWith(EVENT_COMMAND)) {
                doEventCommand(input);

            } else {
                String reply = "     Unknown command received, reenter command:";
                System.out.println(formatResponse(reply));
            }
        }
    }
}
