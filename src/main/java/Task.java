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

    @Override
    public String toString() {
        String mark;
        if (isDone) {
            mark = "[X] ";
        } else {
            mark = "[ ] ";
        }
        return mark + description;
    }
}
