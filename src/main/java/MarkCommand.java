/**
 * Represents the command to mark a task as done.
 * <p>
 * The {@code MarkCommand} updates the specified task number's
 * task's status as done and displays a confirmation message to the user.
 */
public class MarkCommand extends Commands {
    private final int taskNo;

    MarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Executes the command by marking the specified task as done.
     * Displays a confirmation message when successful, or an error
     * message if the task number is invalid.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.getTask(taskNo).markAsDone();
            String reply = "     Roger. This task has been marked as done:\n"
                    + "       " + tasks.getTask(taskNo).toString();
            ui.formatResponse(reply);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        }
    }


}
