package com.dowhile;
// Generated Aug 17, 2017 1:48:25 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TempSale generated by hbm2java
 */
@Entity
@Table(name="temp_sale"
    ,catalog="ecom"
)
public class TempSale  implements java.io.Serializable {


     private TempSaleId id;

    public TempSale() {
    }

    public TempSale(TempSaleId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="product", column=@Column(name="Product", length=500) ), 
        @AttributeOverride(name="outlet", column=@Column(name="Outlet", length=100) ), 
        @AttributeOverride(name="createdDate", column=@Column(name="CREATED_DATE", length=10) ), 
        @AttributeOverride(name="revenue", column=@Column(name="Revenue", precision=52) ), 
        @AttributeOverride(name="revenueTaxIncl", column=@Column(name="Revenue_tax_incl", precision=53) ), 
        @AttributeOverride(name="costOfGoods", column=@Column(name="Cost_of_Goods", precision=52) ), 
        @AttributeOverride(name="grossProfit", column=@Column(name="Gross_Profit", precision=53) ), 
        @AttributeOverride(name="margin", column=@Column(name="Margin", precision=52, scale=6) ), 
        @AttributeOverride(name="itemsSold", column=@Column(name="Items_Sold", precision=32, scale=0) ), 
        @AttributeOverride(name="tax", column=@Column(name="Tax", precision=42) ), 
        @AttributeOverride(name="companyAssociationId", column=@Column(name="COMPANY_ASSOCIATION_ID", nullable=false) ), 
        @AttributeOverride(name="outletAssocicationId", column=@Column(name="OUTLET_ASSOCICATION_ID") ) } )
    public TempSaleId getId() {
        return this.id;
    }
    
    public void setId(TempSaleId id) {
        this.id = id;
    }




}


