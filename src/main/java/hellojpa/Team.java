package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    //연관관계의 주인 - 양방향 매핑 규칙 객체의 두 관계중 하나를 연관관계의 주인으로 지정, 주인만 외래 키 관리, 주인이 아닌쪽은 Read Only, 주인은 mappedBy 속성 사용 X 주인이 아니면 mappedBy 속성으로 주인 지정
    //mappedBy = 주인 아님 주인-> Member의 team에 의해서 관리됨
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
