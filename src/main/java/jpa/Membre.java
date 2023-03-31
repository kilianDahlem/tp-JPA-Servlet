package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Membre {
    private Long id;

    private String name;

    private List<Fiche> ticketsDiscussed;

    public Membre(){}

    public Membre(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
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

    @OneToMany
    public List<Fiche> getTicketsDiscussed() {
        return ticketsDiscussed;
    }

    public void setTicketsDiscussed(List<Fiche> ticketsDiscussed) {
        this.ticketsDiscussed = ticketsDiscussed;
    }
}
