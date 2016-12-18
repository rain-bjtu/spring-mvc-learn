package com.rain.learn.sms.ebo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "groups")
public class GroupEbo implements Serializable {

    private static final long serialVersionUID = 6088188927068547825L;

    public static final String NAME_PATH = "name";

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // delete group will delete related authorities?
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = AuthorityEbo.class)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinTable(name = "group_authorities", joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "authority_id", referencedColumnName = "id") })
    private Set<AuthorityEbo> authorities;

    public Set<AuthorityEbo> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityEbo> authorities) {
        this.authorities = authorities;
    }

    @OneToMany(targetEntity = UserEbo.class, fetch = FetchType.LAZY, mappedBy = "group")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<UserEbo> users;

    public Set<UserEbo> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEbo> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GroupEbo other = (GroupEbo) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GroupEbo [id=" + id + ", name=" + name + "]";
    }

}
