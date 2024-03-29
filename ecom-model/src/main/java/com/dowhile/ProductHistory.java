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
 * ProductHistory generated by hbm2java
 */
@Entity
@Table(name="product_history"
    ,catalog="ecom"
)
public class ProductHistory  implements java.io.Serializable {


     private Integer productHistoryId;
     private ProductVariant productVariant;
     private Outlet outlet;
     private CompositeProduct compositeProduct;
     private User user;
     private Product product;
     private Company company;
     private String productHistoryUuid;
     private Date actionDate;
     private int quantity;
     private int changeQuantity;
     private int outletQuantity;
     private String action;
     private boolean activeIndicator;

    public ProductHistory() {
    }

	
    public ProductHistory(Outlet outlet, User user, Product product, Company company, String productHistoryUuid, Date actionDate, int quantity, int changeQuantity, int outletQuantity, String action, boolean activeIndicator) {
        this.outlet = outlet;
        this.user = user;
        this.product = product;
        this.company = company;
        this.productHistoryUuid = productHistoryUuid;
        this.actionDate = actionDate;
        this.quantity = quantity;
        this.changeQuantity = changeQuantity;
        this.outletQuantity = outletQuantity;
        this.action = action;
        this.activeIndicator = activeIndicator;
    }
    public ProductHistory(ProductVariant productVariant, Outlet outlet, CompositeProduct compositeProduct, User user, Product product, Company company, String productHistoryUuid, Date actionDate, int quantity, int changeQuantity, int outletQuantity, String action, boolean activeIndicator) {
       this.productVariant = productVariant;
       this.outlet = outlet;
       this.compositeProduct = compositeProduct;
       this.user = user;
       this.product = product;
       this.company = company;
       this.productHistoryUuid = productHistoryUuid;
       this.actionDate = actionDate;
       this.quantity = quantity;
       this.changeQuantity = changeQuantity;
       this.outletQuantity = outletQuantity;
       this.action = action;
       this.activeIndicator = activeIndicator;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="PRODUCT_HISTORY_ID", unique=true, nullable=false)
    public Integer getProductHistoryId() {
        return this.productHistoryId;
    }
    
    public void setProductHistoryId(Integer productHistoryId) {
        this.productHistoryId = productHistoryId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_VARIANT_ASSOCICATION_ID")
    public ProductVariant getProductVariant() {
        return this.productVariant;
    }
    
    public void setProductVariant(ProductVariant productVariant) {
        this.productVariant = productVariant;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OUTLET_ASSOCICATION_ID", nullable=false)
    public Outlet getOutlet() {
        return this.outlet;
    }
    
    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMPOSITE_PRODUCT_ASSOCIATION_ID")
    public CompositeProduct getCompositeProduct() {
        return this.compositeProduct;
    }
    
    public void setCompositeProduct(CompositeProduct compositeProduct) {
        this.compositeProduct = compositeProduct;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CREATED_BY", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ASSOCICATION_ID", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMPANY_ASSOCIATION_ID", nullable=false)
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }

    
    @Column(name="PRODUCT_HISTORY_UUID", nullable=false, length=500)
    public String getProductHistoryUuid() {
        return this.productHistoryUuid;
    }
    
    public void setProductHistoryUuid(String productHistoryUuid) {
        this.productHistoryUuid = productHistoryUuid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ACTION_DATE", nullable=false, length=19)
    public Date getActionDate() {
        return this.actionDate;
    }
    
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    
    @Column(name="QUANTITY", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="CHANGE_QUANTITY", nullable=false)
    public int getChangeQuantity() {
        return this.changeQuantity;
    }
    
    public void setChangeQuantity(int changeQuantity) {
        this.changeQuantity = changeQuantity;
    }

    
    @Column(name="OUTLET_QUANTITY", nullable=false)
    public int getOutletQuantity() {
        return this.outletQuantity;
    }
    
    public void setOutletQuantity(int outletQuantity) {
        this.outletQuantity = outletQuantity;
    }

    
    @Column(name="ACTION", nullable=false, length=50)
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    
    @Column(name="ACTIVE_INDICATOR", nullable=false)
    public boolean isActiveIndicator() {
        return this.activeIndicator;
    }
    
    public void setActiveIndicator(boolean activeIndicator) {
        this.activeIndicator = activeIndicator;
    }




}


