package com.dowhile;
// Generated May 8, 2019 8:28:21 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * InventoryCountV generated by hbm2java
 */
@Entity
@Table(name="inventory_count_v"
    ,catalog="ecom"
)
public class InventoryCountV  implements java.io.Serializable {


     private InventoryCountVId id;

    public InventoryCountV() {
    }

    public InventoryCountV(InventoryCountVId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="inventoryCountId", column=@Column(name="INVENTORY_COUNT_ID", nullable=false) ), 
        @AttributeOverride(name="inventoryCountRefNo", column=@Column(name="INVENTORY_COUNT_REF_NO", length=45) ), 
        @AttributeOverride(name="statusAssocicationId", column=@Column(name="STATUS_ASSOCICATION_ID", nullable=false) ), 
        @AttributeOverride(name="outletAssocicationId", column=@Column(name="OUTLET_ASSOCICATION_ID", nullable=false) ), 
        @AttributeOverride(name="expectedProdQty", column=@Column(name="EXPECTED_PROD_QTY") ), 
        @AttributeOverride(name="countedProdQty", column=@Column(name="COUNTED_PROD_QTY") ), 
        @AttributeOverride(name="countDiff", column=@Column(name="COUNT_DIFF") ), 
        @AttributeOverride(name="supplyPriceExp", column=@Column(name="SUPPLY_PRICE_EXP", precision=20) ), 
        @AttributeOverride(name="retailPriceExp", column=@Column(name="RETAIL_PRICE_EXP", precision=20) ), 
        @AttributeOverride(name="priceDiff", column=@Column(name="PRICE_DIFF", precision=20) ), 
        @AttributeOverride(name="supplyPriceCounted", column=@Column(name="SUPPLY_PRICE_COUNTED", precision=20) ), 
        @AttributeOverride(name="retailPriceCounted", column=@Column(name="RETAIL_PRICE_COUNTED", precision=20) ), 
        @AttributeOverride(name="remarks", column=@Column(name="REMARKS", length=500) ), 
        @AttributeOverride(name="inventoryCountTypeAssocicationId", column=@Column(name="INVENTORY_COUNT_TYPE_ASSOCICATION_ID", nullable=false) ), 
        @AttributeOverride(name="activeIndicator", column=@Column(name="ACTIVE_INDICATOR", nullable=false) ), 
        @AttributeOverride(name="createdDate", column=@Column(name="CREATED_DATE", nullable=false) ), 
        @AttributeOverride(name="lastUpdated", column=@Column(name="LAST_UPDATED", nullable=false) ), 
        @AttributeOverride(name="createdBy", column=@Column(name="CREATED_BY") ), 
        @AttributeOverride(name="updatedBy", column=@Column(name="UPDATED_BY") ), 
        @AttributeOverride(name="companyAssociationId", column=@Column(name="COMPANY_ASSOCIATION_ID", nullable=false) ), 
        @AttributeOverride(name="statusDesc", column=@Column(name="STATUS_DESC", length=45) ), 
        @AttributeOverride(name="outlet", column=@Column(name="OUTLET", length=100) ), 
        @AttributeOverride(name="company", column=@Column(name="COMPANY", length=256) ) } )
    public InventoryCountVId getId() {
        return this.id;
    }
    
    public void setId(InventoryCountVId id) {
        this.id = id;
    }




}


