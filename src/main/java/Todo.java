public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String txtSave() {
        return "[T]" + super.txtSave();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
