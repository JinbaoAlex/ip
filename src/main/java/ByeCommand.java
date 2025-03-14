/**
 * Represents the command to exit the program
 */
public class ByeCommand extends Commands {

    /**
     * Executes the exit command by displaying a farewell message to the user.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        new Ui().formatResponse("     Bye. Hope to see you again soon!");
    }

    /**
     * Returns boolean true to indicate the exiting of the program
     *
     * @return {@code true}
     */
    public boolean isExit() {
        return true;
    }
}
