import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected String startDate;
    protected String endDate;
    protected LocalDate startLocalDate;
    protected LocalDate endLocalDate;

    public Event(String description, String startDate, String endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
        try {
            this.startLocalDate = LocalDate.parse(startDate);
            this.endLocalDate = LocalDate.parse(endDate);
        } catch (DateTimeParseException e) {
            this.startLocalDate = null;
            this.endLocalDate = null;
        }
    }

    public String txtSave() {
        return "[E]" + super.txtSave() + "|" + startDate + "|" + endDate;
    }

    @Override
    public String toString() {
        if (startLocalDate != null && endLocalDate != null) {
            String startDateFormatted = startLocalDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            String endDateFormatted = endLocalDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            return "[E]" + super.toString() + " (from: " + startDateFormatted + " to: " + endDateFormatted + ")";
        } else {
            return "[E]" + super.toString() + " (from: " + startDate + " to: " + endDate + ")";
        }
    }
}
