/**
 * Represents the command to list all tasks in the task list.
 * <p>
 * The {@code ListCommand} retrieves and displays all tasks currently stored in the {@code TaskList}.
 */
public class ListCommand extends Commands {

    /**
     * Executes the command by iterating through and printing every task in the {@code TaskList}.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("     These are all the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("\n     ").append(i + 1).append(".").append(tasks.getTask(i));
        }
        ui.formatResponse(sb.toString());
    }
}
