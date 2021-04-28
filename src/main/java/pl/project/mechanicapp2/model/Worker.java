package pl.project.mechanicapp2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private WorkerPersonalData workerPersonalData;

    @OneToMany
    private List<WorkerPayment> workerPayments;

    @OneToMany
    private List<WorkerAbsence> workerAbsences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkerPersonalData getUserPersonalData() {
        return workerPersonalData;
    }

    public void setUserPersonalData(WorkerPersonalData workerPersonalData) {
        this.workerPersonalData = workerPersonalData;
    }

    public WorkerPersonalData getWorkerPersonalData() {
        return workerPersonalData;
    }

    public void setWorkerPersonalData(WorkerPersonalData workerPersonalData) {
        this.workerPersonalData = workerPersonalData;
    }

    public List<WorkerPayment> getWorkerPayments() {
        return workerPayments;
    }

    public void setWorkerPayments(List<WorkerPayment> workerPayments) {
        this.workerPayments = workerPayments;
    }

    public List<WorkerAbsence> getWorkerAbsences() {
        return workerAbsences;
    }

    public void setWorkerAbsences(List<WorkerAbsence> workerAbsences) {
        this.workerAbsences = workerAbsences;
    }
}
