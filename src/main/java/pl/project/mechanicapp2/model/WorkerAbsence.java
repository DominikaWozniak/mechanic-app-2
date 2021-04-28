package pl.project.mechanicapp2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WorkerAbsence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date beginAbsence;
    private Date endAbsence;
    private String reason;
    @ManyToOne
    @JoinColumn
    private Worker worker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginAbsence() {
        return beginAbsence;
    }

    public void setBeginAbsence(Date beginAbsence) {
        this.beginAbsence = beginAbsence;
    }

    public Date getEndAbsence() {
        return endAbsence;
    }

    public void setEndAbsence(Date endAbsence) {
        this.endAbsence = endAbsence;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
