package ru.kpfu.itis.genatulin.hw5.entities;

import javax.persistence.*;

@Entity
@Table
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer arg1;

    @Column(nullable = false)
    private Integer arg2;

    @Enumerated
    @Column(nullable = false)
    private Operation operation;

    @Column(nullable = false)
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Integer getArg2() {
        return arg2;
    }

    public void setArg2(Integer arg2) {
        this.arg2 = arg2;
    }

    public Integer getArg1() {
        return arg1;
    }

    public void setArg1(Integer arg1) {
        this.arg1 = arg1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}