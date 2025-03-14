/**
 * Represents a todo task with a description and completion status.
 * <p>
 * The {@code Todo} class provides methods to mark the task as done,
 * unmark it, retrieve its status, and formatting for displaying or saving.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /**
     * {@inheritDoc}
     * This method is inherited from {@link Task}.
     * @return A string representation of the task and its description
     */
    public String txtSave() {
        return "[T]" + super.txtSave();
    }

    /**
     * {@inheritDoc}
     * This method is inherited from {@link Task}.
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
