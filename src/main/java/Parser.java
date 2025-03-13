public class Parser {
    private static final int MARK_CMD_LENGTH = 5;
    private static final int UNMARK_CMD_LENGTH = 7;
    private static final int DELETE_CMD_LENGTH = 7;

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
    private static final String DELETE_COMMAND = "delete";
    private static final String TODO_COMMAND = "todo";
    private static final String DEADLINE_COMMAND = "deadline";
    private static final String EVENT_COMMAND = "event";
    private static final String BY_KEYWORD = "/by";
    private static final String FROM_KEYWORD = "/from";
    private static final String TO_KEYWORD = "/to";

    public static Commands parse(String input) {
        if (input.startsWith(BYE_COMMAND)) {
            return new ByeCommand();
        } else if (input.startsWith(LIST_COMMAND)) {
            return new ListCommand();

        } else if (input.startsWith(MARK_COMMAND)) {
            int taskNo = Integer.parseInt(input.substring(MARK_CMD_LENGTH)) - 1;
            return new MarkCommand(taskNo);

        } else if (input.startsWith(UNMARK_COMMAND)) {
            int taskNo = Integer.parseInt(input.substring(UNMARK_CMD_LENGTH)) - 1;
            return new UnmarkCommand(taskNo);

        } else if (input.startsWith(DELETE_COMMAND)) {
            int taskNo = Integer.parseInt(input.substring(DELETE_CMD_LENGTH)) - 1;
            return new DeleteCommand(taskNo);

        } else if (input.startsWith(TODO_COMMAND)) {
            try {
                String taskDesc = input.substring(TODO_CMD_LENGTH);
                if (taskDesc.trim().isEmpty()) {
                    throw new MissingDescription("MISSING DESCRIPTION, reenter with description");
                }
                return new TodoCommand(taskDesc);
            } catch (MissingDescription e) {
                return new MissingCommand("     " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                return new MissingCommand("    " + "MISSING DESCRIPTION, reenter with description");
            }

        } else if (input.startsWith(DEADLINE_COMMAND)) {
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
                if (deadline.trim().isEmpty()) {
                    throw new MissingDescription("MISSING DEADLINE, reenter with deadline");
                }
                return new DeadlineCommand(taskDesc, deadline);
            } catch (MissingDescription | MissingKeyword e) {
                return new MissingCommand("     " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                return new MissingCommand("    " + "MISSING DESCRIPTION, reenter with description");
            }

        } else if (input.startsWith(EVENT_COMMAND)) {
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
                if (startDate.trim().isEmpty()) {
                    throw new MissingDescription("MISSING DESCRIPTION, reenter with description");
                }
                String endDate = input.substring(indexOfEndDate - 1 + EVENT_TO_LENGTH).trim();
                if (endDate.trim().isEmpty()) {
                    throw new MissingDescription("MISSING DESCRIPTION, reenter with description");
                }
                return new EventCommand(taskDesc, startDate, endDate);
            } catch (MissingDescription | MissingKeyword e) {
                return new MissingCommand("     " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                return new MissingCommand("    " + "MISSING DESCRIPTION, reenter with description");
            }

        } else {
            return new MissingCommand("Unknown command received, reenter command:");
        }
    }
}
