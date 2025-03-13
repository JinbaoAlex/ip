public class EventCommand extends Commands {
    private final String taskDesc;
    private final String startDate;
    private final String endDate;

    EventCommand(String taskDesc, String startDate, String endDate) {
        this.taskDesc = taskDesc;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event t = new Event(taskDesc, startDate, endDate);
        tasks.addTask(t);
        ui.formatTaskMsg(t, tasks);
    }
}
