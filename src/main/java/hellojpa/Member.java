package hellojpa;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;


//    @Column(name = "team_id") //테이블 연관관계
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "team_id") //객체 연관관계
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
