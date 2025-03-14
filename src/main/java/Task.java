/**
 * Represents a generic task with a description and completion status.
 * <p>
 * The {@code Task} class provides methods to mark the task as done,
 * unmark it, retrieve its status, and formatting for displaying or saving.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }

    /**
     * Returns the string formatting that represents the completion status of the task.
     *
     * @return A string "[X] " if the task is done, "[ ] " if not.
     */
    public String getMark() {
        if (isDone) {
            return "[X] ";
        } else {
            return "[ ] ";
        }
    }

    /**
     * Returns the string formatting used for saving of the task's information
     *
     * @return A string representation of the task and its information
     */
    public String txtSave() {
        return getMark() + description;
    }

    /**
     * Returns a string representation of the task,
     * including its type, completion status and description.
     *
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        String mark = getMark();
        return mark + description;
    }
}
