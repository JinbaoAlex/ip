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
