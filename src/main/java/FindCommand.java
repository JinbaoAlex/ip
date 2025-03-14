/**
 * Represents the command to search for tasks
 * <p>
 * The {@code FindCommand} finds the task the user wishes to search for in the {@code TaskList}.
 */
public class FindCommand extends Commands {
    private final String searchTerm;

    FindCommand(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Executes the command by iterating through and printing every task in the {@code TaskList}
     * that matches the searchTerm.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("     These are the tasks that match you search query:");
        int count = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.getTask(i).find(searchTerm)) {
                sb.append("\n     ").append(count).append(".").append(tasks.getTask(i));
                count++;
            }
        }
        ui.formatResponse(sb.toString());
    }
}
