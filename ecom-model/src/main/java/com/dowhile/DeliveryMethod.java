package com.dowhile;
// Generated Aug 17, 2017 1:48:25 PM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DeliveryMethod generated by hbm2java
 */
@Entity
@Table(name="delivery_method"
    ,catalog="ecom"
)
public class DeliveryMethod  implements java.io.Serializable {


     private Integer deliveryMethodId;
     private String deliveryMethodName;
     private BigDecimal shippingRate;
     private boolean activeIndicator;
     private Date createdDate;
     private Date lastUpdated;
     private Integer createdBy;
     private Integer updatedBy;
     private Set<OrderMain> orderMains = new HashSet<OrderMain>(0);

    public DeliveryMethod() {
    }

	
    public DeliveryMethod(String deliveryMethodName, BigDecimal shippingRate, boolean activeIndicator, Date createdDate, Date lastUpdated) {
        this.deliveryMethodName = deliveryMethodName;
        this.shippingRate = shippingRate;
        this.activeIndicator = activeIndicator;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }
    public DeliveryMethod(String deliveryMethodName, BigDecimal shippingRate, boolean activeIndicator, Date createdDate, Date lastUpdated, Integer createdBy, Integer updatedBy, Set<OrderMain> orderMains) {
       this.deliveryMethodName = deliveryMethodName;
       this.shippingRate = shippingRate;
       this.activeIndicator = activeIndicator;
       this.createdDate = createdDate;
       this.lastUpdated = lastUpdated;
       this.createdBy = createdBy;
       this.updatedBy = updatedBy;
       this.orderMains = orderMains;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="DELIVERY_METHOD_ID", unique=true, nullable=false)
    public Integer getDeliveryMethodId() {
        return this.deliveryMethodId;
    }
    
    public void setDeliveryMethodId(Integer deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    
    @Column(name="DELIVERY_METHOD_NAME", nullable=false, length=100)
    public String getDeliveryMethodName() {
        return this.deliveryMethodName;
    }
    
    public void setDeliveryMethodName(String deliveryMethodName) {
        this.deliveryMethodName = deliveryMethodName;
    }

    
    @Column(name="SHIPPING_RATE", nullable=false, precision=5)
    public BigDecimal getShippingRate() {
        return this.shippingRate;
    }
    
    public void setShippingRate(BigDecimal shippingRate) {
        this.shippingRate = shippingRate;
    }

    
    @Column(name="ACTIVE_INDICATOR", nullable=false)
    public boolean isActiveIndicator() {
        return this.activeIndicator;
    }
    
    public void setActiveIndicator(boolean activeIndicator) {
        this.activeIndicator = activeIndicator;
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

    
    @Column(name="CREATED_BY")
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    
    @Column(name="UPDATED_BY")
    public Integer getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="deliveryMethod")
    public Set<OrderMain> getOrderMains() {
        return this.orderMains;
    }
    
    public void setOrderMains(Set<OrderMain> orderMains) {
        this.orderMains = orderMains;
    }




}

