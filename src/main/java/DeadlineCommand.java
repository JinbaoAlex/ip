/**
 * Represents the command to add a deadline task
 * <p>
 * The {@code DeadlineCommand} creates a new {@code Deadline} task
 * with a specified description and a deadline date,
 * and adds it to the {@code TaskList}.
 */
public class DeadlineCommand extends Commands {
    private final String taskDesc;
    private final String deadline;

    DeadlineCommand(String taskDesc, String deadline) {
        this.taskDesc = taskDesc;
        this.deadline = deadline;
    }

    /**
     * Executes the deadline command by creating a {@code Deadline} object,
     * adds it to the taskList and displays a confirmation message.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline t = new Deadline(taskDesc, deadline);
        tasks.addTask(t);
        ui.formatTaskMsg(t, tasks);
    }
}
