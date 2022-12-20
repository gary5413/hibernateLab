import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups_A")
public class Groups {
    @Id @Column(name = "groups_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grounpId;
    @Column(name = "groupName")
    private String groupName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "friend_groups",joinColumns = {@JoinColumn(name = "fk_groups_id",referencedColumnName = "groups_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_friend_id",referencedColumnName = "friends_id")})
    private Set<Friend> friends=new HashSet<Friend>();

    public Groups() {
    }

    public Integer getGrounpId() {
        return grounpId;
    }

    public void setGrounpId(Integer grounpId) {
        this.grounpId = grounpId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }
}
