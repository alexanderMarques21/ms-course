package br.com.hrworker.entities;

import org.hibernate.jdbc.Work;

import javax.persistence.*;

@Entity
@Table(name = "tb_worker")
public class Worker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double dailyIncome;

  @Deprecated
  public Worker() {};

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
