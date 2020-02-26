/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author hyoku
 */
@Entity
@Table(name = "agents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agents.findAll", query = "SELECT a FROM Agents a"),
    @NamedQuery(name = "Agents.findByAgentId", query = "SELECT a FROM Agents a WHERE a.agentId = :agentId"),
    @NamedQuery(name = "Agents.findByName", query = "SELECT a FROM Agents a WHERE a.name = :name"),
    @NamedQuery(name = "Agents.findByPhone", query = "SELECT a FROM Agents a WHERE a.phone = :phone"),
    @NamedQuery(name = "Agents.findByFax", query = "SELECT a FROM Agents a WHERE a.fax = :fax"),
    @NamedQuery(name = "Agents.findByEmail", query = "SELECT a FROM Agents a WHERE a.email = :email"),
    @NamedQuery(name = "Agents.findByUsername", query = "SELECT a FROM Agents a WHERE a.username = :username"),
    @NamedQuery(name = "Agents.findByAverageSalesThisYear", query = "SELECT a FROM Agents a WHERE a.averageSalesThisYear = :averageSalesThisYear"),
    @NamedQuery(name = "Agents.findByDateJoined", query = "SELECT a FROM Agents a WHERE a.dateJoined = :dateJoined")})
public class Agents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agentId")
    private Integer agentId;
    @Size(max = 50)
    @Column(name = "name")
    @NotBlank(message="NotBlank.agents.name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "phone")
    @NotBlank(message="NotBlank.agents.phone")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "fax")
    @NotBlank(message="NotBlank.agents.fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    @NotBlank(message="NotBlank.agents.email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    @NotBlank(message="NotBlank.agents.username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "password")
    @NotBlank(message="NotBlank.agents.password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "averageSalesThisYear")
    @NotBlank(message="NotBlank.agents.averageSalesThisYear")
    private double averageSalesThisYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateJoined")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotBlank(message="NotBlank.agents.dateJoined")
    @Temporal(TemporalType.DATE)
    private Date dateJoined;

    public Agents() {
    }

    public Agents(Integer agentId) {
        this.agentId = agentId;
    }
    
    
    public Agents(Integer agentId, String username, String password) {
        this.agentId = agentId;
        this.username = username;
        this.password = password;
    }

    public Agents(Integer agentId, String username, String password, double averageSalesThisYear, Date dateJoined) {
        this.agentId = agentId;
        this.username = username;
        this.password = password;
        this.averageSalesThisYear = averageSalesThisYear;
        this.dateJoined = dateJoined;
    }
    
    public Agents(Integer agentId, String name, String fax, String phone, String email, String username, String password, Date dateJoined, double averageSalesThisYear) {
        this.agentId = agentId;
        this.name = name;
        this.fax = fax;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.averageSalesThisYear = averageSalesThisYear;
        this.dateJoined = dateJoined;

    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAverageSalesThisYear() {
        return averageSalesThisYear;
    }

    public void setAverageSalesThisYear(double averageSalesThisYear) {
        this.averageSalesThisYear = averageSalesThisYear;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentId != null ? agentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agents)) {
            return false;
        }
        Agents other = (Agents) object;
        if ((this.agentId == null && other.agentId != null) || (this.agentId != null && !this.agentId.equals(other.agentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Agents[ agentId=" + agentId + " ]";
    }
    
}
