/**
 * Represents the command to delete a task based on its taskNo from the tasklist
 */
public class DeleteCommand extends Commands {
    private final int taskNo;

    DeleteCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Executes the delete command by removing the specified task from the task list.
     * Displays a confirmation message when successfully deleted.
     * If the task number is invalid, an error message is displayed instead.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            String reply = "     Noted. I've removed this task::\n"
                + "       " + tasks.getTask(taskNo).toString()
                + "     Now you have " + (tasks.size()-1) + " tasks in the list.";
            ui.formatResponse(reply);
            tasks.removeTask(taskNo);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        }

    }
}
