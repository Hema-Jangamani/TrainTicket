package com.TrainTickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TrainTickets")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class TrainTicket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    public TrainTicket(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
