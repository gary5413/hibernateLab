import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "friends")
public class Friend {
    @Id @Column(name = "friends_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendId;
    @Column(name = "friendName")
    private String friendName;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "friends")
    private Set<Groups> groups=new HashSet<Groups>();

    public Friend() {
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }
}
