package pl.project.mechanicapp2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WorkerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Worker worker;
    private Date paymentDate;
    private String month;
    private Double sicknessInsurance;
    private Double taxes;
    private Double totalGross;
    private Double paymentNet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getSicknessInsurance() {
        return sicknessInsurance;
    }

    public void setSicknessInsurance(Double sicknessInsurance) {
        this.sicknessInsurance = sicknessInsurance;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getTotalGross() {
        return totalGross;
    }

    public void setTotalGross(Double totalGross) {
        this.totalGross = totalGross;
    }

    public Double getPaymentNet() {
        return paymentNet;
    }

    public void setPaymentNet(Double paymentNet) {
        this.paymentNet = paymentNet;
    }
}
