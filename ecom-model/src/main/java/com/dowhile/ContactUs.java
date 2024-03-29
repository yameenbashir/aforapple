package com.dowhile;
// Generated Aug 17, 2017 1:48:25 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ContactUs generated by hbm2java
 */
@Entity
@Table(name="contact_us"
    ,catalog="ecom"
)
public class ContactUs  implements java.io.Serializable {


     private Integer contactUsId;
     private WebActivityDetail webActivityDetail;
     private String name;
     private String email;
     private String message;
     private String contactNumber;
     private String requestStatus;
     private Date createdDate;
     private Date lastUpdated;

    public ContactUs() {
    }

	
    public ContactUs(WebActivityDetail webActivityDetail, String name, String email, String requestStatus, Date createdDate, Date lastUpdated) {
        this.webActivityDetail = webActivityDetail;
        this.name = name;
        this.email = email;
        this.requestStatus = requestStatus;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }
    public ContactUs(WebActivityDetail webActivityDetail, String name, String email, String message, String contactNumber, String requestStatus, Date createdDate, Date lastUpdated) {
       this.webActivityDetail = webActivityDetail;
       this.name = name;
       this.email = email;
       this.message = message;
       this.contactNumber = contactNumber;
       this.requestStatus = requestStatus;
       this.createdDate = createdDate;
       this.lastUpdated = lastUpdated;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="CONTACT_US_ID", unique=true, nullable=false)
    public Integer getContactUsId() {
        return this.contactUsId;
    }
    
    public void setContactUsId(Integer contactUsId) {
        this.contactUsId = contactUsId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WEB_ACTIVITY_DETAIL_ID", nullable=false)
    public WebActivityDetail getWebActivityDetail() {
        return this.webActivityDetail;
    }
    
    public void setWebActivityDetail(WebActivityDetail webActivityDetail) {
        this.webActivityDetail = webActivityDetail;
    }

    
    @Column(name="NAME", nullable=false, length=256)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="EMAIL", nullable=false, length=256)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="MESSAGE", length=256)
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    
    @Column(name="CONTACT_NUMBER", length=256)
    public String getContactNumber() {
        return this.contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    
    @Column(name="REQUEST_STATUS", nullable=false, length=256)
    public String getRequestStatus() {
        return this.requestStatus;
    }
    
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", nullable=false, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATED", nullable=false, length=19)
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }




}


