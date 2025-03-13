import java.util.ArrayList;

public class TaskList {
    private static final ArrayList<Task> listOfTasks = new ArrayList<>();

    public ArrayList<Task> getList() {
        return listOfTasks;
    }

    public void addTask(Task task) {
        listOfTasks.add(task);
    }

    public void removeTask(int index) {
        listOfTasks.remove(index);
    }

    public Task getTask(int index) {
        return listOfTasks.get(index);
    }

    public int size() {
        return listOfTasks.size();
    }
}
