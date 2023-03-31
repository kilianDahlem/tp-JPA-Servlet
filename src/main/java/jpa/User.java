package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private Long id;

    private String name;

    private List<Fiche> ticketsReported;

    private List<Fiche> ticketsConv;

    public User(){}

    public User(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
    public List<Fiche> getTicketsReported() {
        return ticketsReported;
    }

    public void setTicketsReported(List<Fiche> ticketsReported) {
        this.ticketsReported = ticketsReported;
    }

    @ManyToMany
    public List<Fiche> getTicketsConv() {
        return ticketsConv;
    }

    public void setTicketsConv(List<Fiche> ticketsConv) {
        this.ticketsConv = ticketsConv;
    }

}
