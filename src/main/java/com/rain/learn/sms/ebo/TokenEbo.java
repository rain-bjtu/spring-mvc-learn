package com.rain.learn.sms.ebo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "token")
public class TokenEbo implements Serializable {

    public TokenEbo() {}

    public TokenEbo(String series, UserEbo user, String token, Date date) {
        super();
        this.series = series;
        this.user = user;
        this.token = token;
        this.lastUsed = date;
    }

    private static final long serialVersionUID = 1428826709464617859L;

    @NotEmpty
    @Id
    @Column(name = "series")
    private String series;

    @ManyToOne(targetEntity = UserEbo.class)
    @JoinColumn(name = "username", referencedColumnName = "name")
    private UserEbo user;

    @NotEmpty
    @Column(name = "token")
    private String token;

    // not empty can't be used to java.sql.timestamp
    // @NotEmpty
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_used", nullable = false)
    private Date lastUsed;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public UserEbo getUser() {
        return user;
    }

    public void setUser(UserEbo user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lastUsed == null) ? 0 : lastUsed.hashCode());
        result = prime * result + ((series == null) ? 0 : series.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        TokenEbo other = (TokenEbo) obj;
        if (lastUsed == null) {
            if (other.lastUsed != null)
                return false;
        } else if (!lastUsed.equals(other.lastUsed))
            return false;
        if (series == null) {
            if (other.series != null)
                return false;
        } else if (!series.equals(other.series))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }
}
