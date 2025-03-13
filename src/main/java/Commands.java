public abstract class Commands {
    public void execute(TaskList tasks, Ui ui, Storage storage) {}

    public boolean isExit() {
        return false;
    }
}
