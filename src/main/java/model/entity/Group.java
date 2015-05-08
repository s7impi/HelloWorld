package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author asmolik
 */
@Entity(name = "groups")
public class Group {
    @Id
    @Column(name = "group_name")
    String groupname;
    @Column(name = "user_name")
    String username;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
