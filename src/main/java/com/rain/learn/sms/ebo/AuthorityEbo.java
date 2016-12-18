package com.rain.learn.sms.ebo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "authorities")
public class AuthorityEbo implements Serializable {

    private static final long serialVersionUID = 5615737264023781393L;

    public static final String AUTHORITY_PATH = "authority";

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
    @Column(name = "authority", nullable = false, unique = true)
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    // mapped by the GroupEbo's field "authorities"
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY, targetEntity = GroupEbo.class)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<GroupEbo> groups;

    public Set<GroupEbo> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEbo> groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authority == null) ? 0 : authority.hashCode());
        result = prime * result + id;
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
        AuthorityEbo other = (AuthorityEbo) obj;
        if (authority == null) {
            if (other.authority != null)
                return false;
        } else if (!authority.equals(other.authority))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AuthorityEbo [id=" + id + ", authority=" + authority + "]";
    }

}
