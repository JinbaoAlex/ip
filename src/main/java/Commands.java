/**
 * Represents an abstract command to be executed in the main body.
 * Subclasses of {@code Commands} implements methods with specific behavior
 * relevant to their respective commands
 */
public abstract class Commands {
    /**
     * Executes the command with the task list, user interface, and storage.
     * <p>
     * Exact implementations depends on the relevant command.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} object handling user interactions.
     * @param storage The {@code Storage} object for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {}

    /**
     * Determines whether this command is an exit command.
     * <p>
     * Defaults to {@code false}, and only exit commands
     * would override this method to return {@code true}.
     *
     * @return {@code true} if the command should terminate the program, otherwise {@code false}.
     */
    public boolean isExit() {
        return false;
    }
}
