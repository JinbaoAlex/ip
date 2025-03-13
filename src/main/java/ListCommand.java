public class ListCommand extends Commands {

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("\n     ").append(i + 1).append(".").append(tasks.getTask(i));
        }
        ui.formatResponse(sb.toString());
    }


}
