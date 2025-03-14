/**
 * Represents the command to add an event task.
 * <p>
 * The {@code EventCommand} creates a new {@code Event} task with
 * a specified description and a start and end date,
 * and adds it to the {@code TaskList}.
 */
public class EventCommand extends Commands {
    private final String taskDesc;
    private final String startDate;
    private final String endDate;

    EventCommand(String taskDesc, String startDate, String endDate) {
        this.taskDesc = taskDesc;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Executes the command by creating a new {@code Event} object,
     * adds it to the task list, and displays a confirmation message.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event t = new Event(taskDesc, startDate, endDate);
        tasks.addTask(t);
        ui.formatTaskMsg(t, tasks);
    }
}
