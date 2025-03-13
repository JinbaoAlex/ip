public class TodoCommand extends Commands {
    private final String taskDesc;

    TodoCommand(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo t = new Todo(taskDesc);
        tasks.addTask(t);
        ui.formatTaskMsg(t, tasks);
    }
}
