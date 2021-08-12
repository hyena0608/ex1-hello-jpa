package hellojpa;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime enbDate;


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEnbDate() {
        return enbDate;
    }

    public void setEnbDate(LocalDateTime enbDate) {
        this.enbDate = enbDate;
    }
}
