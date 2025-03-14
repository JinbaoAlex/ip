/**
 * Represents a command for handling unrecognized or incomplete commands.
 * <p>
 * The {@code MissingCommand} is used when a user enters an invalid command
 * or lacks relevant parameters. It then displays an error message to
 * guide the user in correcting this.
 */
public class MissingCommand extends Commands{
    private final String reply;

    MissingCommand(String reply){
        this.reply = reply;
    }

    /**
     * Executes the command by displaying the provided error message to the user.
     *
     * @param tasks   The {@code TaskList} containing all tasks.
     * @param ui      The {@code Ui} for user interaction.
     * @param storage The {@code Storage} for file operations.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        new Ui().formatResponse("     " + reply);
    }
}
