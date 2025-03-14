/**
 * Represents a command to add a new to-do task.
 * <p>
 * The {@code TodoCommand} creates a new to-do task with a specified description
 * and adds it to the task list.</p>
 */
public class TodoCommand extends Commands {
    private final String taskDesc;

    TodoCommand(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    /**
     * Executes the command by creating a new {@code Todo} object,
     * adds it to the task list, and displays a confirmation message.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo t = new Todo(taskDesc);
        tasks.addTask(t);
        ui.formatTaskMsg(t, tasks);
    }
}
