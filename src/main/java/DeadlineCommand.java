public class DeadlineCommand extends Commands {
    private final String taskDesc;
    private final String deadline;

    DeadlineCommand(String taskDesc, String deadline) {
        this.taskDesc = taskDesc;
        this.deadline = deadline;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline t = new Deadline(taskDesc, deadline);
        tasks.addTask(t);
        ui.formatTaskMsg(t, tasks);
    }
}
