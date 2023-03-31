package jpa;

import javax.persistence.*;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Type")
abstract class Fiche {
    private Long ticket_id;

    private String content;

    private String date;

    private Boolean submit;

    private User user;

    private Membre membre;

    private List<String> status; //Tags of the ticket

    public Fiche(){}

    public Fiche(String content, String date, User u, Membre m, List<String> s){
        this.content = content;
        this.date = date;
        this.user = u;
        this.membre = m;
        this.status = s;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getSubmit() {
        return submit;
    }

    public void setSubmit(Boolean submit) {
        this.submit = submit;
    }

    @ManyToOne
    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
