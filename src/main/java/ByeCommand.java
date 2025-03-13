public class ByeCommand extends Commands {

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        new Ui().formatResponse("     Bye. Hope to see you again soon!");
    }

    public boolean isExit() {
        return true;
    }
}
