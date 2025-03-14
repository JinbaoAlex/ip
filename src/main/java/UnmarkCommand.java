/**
 * Represents the command to mark a task as not done.
 * <p>
 * The {@code UnmarkCommand} updates the specified task number's
 * task's status as not done and displays a confirmation message to the user.
 */
public class UnmarkCommand extends Commands {
    private final int taskNo;

    UnmarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Executes the command by marking the specified task as not done.
     * Displays a confirmation message when successful, or an error
     * message if the task number is invalid.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.getTask(taskNo).unmarkAsDone();
            String reply = "     OK, I've marked this task as not done yet:\n"
                    + "       " + tasks.getTask(taskNo).toString();
            ui.formatResponse(reply);
        } catch (NullPointerException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        }
    }
}
