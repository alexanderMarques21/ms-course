package br.com.hrpayroll.entities;

public class Worker {

    private Long id;

    private String name;

    private Double dailyIncome;

    public Worker() {
    }


    public Worker(Long id, String name, Double dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }
}
