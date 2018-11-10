package com.dowhile;
// Generated Aug 17, 2017 1:48:25 PM by Hibernate Tools 3.4.0.CR1


import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="ecom"
)
public class Product  implements java.io.Serializable {


    private Integer productId;
    private Outlet outlet;
    private ProductType productType;
    private User userByCreatedBy;
    private User userByUpdatedBy;
    private Company company;
    private Brand brand;
    private SalesTax salesTax;
    private Contact contact;
    private String productName;
    private String productUuid;
    private String productDesc;
    private String productHandler;
    private String salesAccountCode;
    private String purchaseAccountCode;
    private String productCanBeSold;
    private String standardProduct;
    private String trackingProduct;
    private String variantProducts;
    private Integer currentInventory;
    private Integer reorderPoint;
    private BigDecimal reorderAmount;
    private BigDecimal supplyPriceExclTax;
    private BigDecimal markupPrct;
    private String sku;
    private String imagePath;
    private Boolean display;
    private boolean activeIndicator;
    private Date createdDate;
    private Date lastUpdated;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private Set<ProductTag> productTags = new HashSet<ProductTag>(0);
    private Set<ProductVariant> productVariants = new HashSet<ProductVariant>(0);
    private Set<PriceBookDetail> priceBookDetails = new HashSet<PriceBookDetail>(0);
    private Set<VariantAttributeValues> variantAttributeValueses = new HashSet<VariantAttributeValues>(0);
    private Set<CompositeProduct> compositeProductsForSelectiveProductAssociationId = new HashSet<CompositeProduct>(0);
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
    private Set<StockOrderDetail> stockOrderDetails = new HashSet<StockOrderDetail>(0);
    private Set<InventoryCountDetail> inventoryCountDetails = new HashSet<InventoryCountDetail>(0);
    private Set<InvoiceDetail> invoiceDetails = new HashSet<InvoiceDetail>(0);
    private Set<CompositeProduct> compositeProductsForProductAssocicationId = new HashSet<CompositeProduct>(0);
    private Set<ProductHistory> productHistories = new HashSet<ProductHistory>(0);

   public Product() {
   }

	
   public Product(Outlet outlet, ProductType productType, User userByCreatedBy, User userByUpdatedBy, Company company, Brand brand, SalesTax salesTax, Contact contact, String productName, String productUuid, String productHandler, String productCanBeSold, String standardProduct, String trackingProduct, String variantProducts, BigDecimal supplyPriceExclTax, BigDecimal markupPrct, String sku, boolean activeIndicator, Date createdDate, Date lastUpdated) {
       this.outlet = outlet;
       this.productType = productType;
       this.userByCreatedBy = userByCreatedBy;
       this.userByUpdatedBy = userByUpdatedBy;
       this.company = company;
       this.brand = brand;
       this.salesTax = salesTax;
       this.contact = contact;
       this.productName = productName;
       this.productUuid = productUuid;
       this.productHandler = productHandler;
       this.productCanBeSold = productCanBeSold;
       this.standardProduct = standardProduct;
       this.trackingProduct = trackingProduct;
       this.variantProducts = variantProducts;
       this.supplyPriceExclTax = supplyPriceExclTax;
       this.markupPrct = markupPrct;
       this.sku = sku;
       this.activeIndicator = activeIndicator;
       this.createdDate = createdDate;
       this.lastUpdated = lastUpdated;
   }
   public Product(Outlet outlet, ProductType productType, User userByCreatedBy, User userByUpdatedBy, Company company, Brand brand, SalesTax salesTax, Contact contact, String productName, String productUuid, String productDesc, String productHandler, String salesAccountCode, String purchaseAccountCode, String productCanBeSold, String standardProduct, String trackingProduct, String variantProducts, Integer currentInventory, Integer reorderPoint, BigDecimal reorderAmount, BigDecimal supplyPriceExclTax, BigDecimal markupPrct, String sku, String imagePath, Boolean display, boolean activeIndicator, Date createdDate, Date lastUpdated, String attribute1, String attribute2, String attribute3, Set<ProductTag> productTags, Set<ProductVariant> productVariants, Set<PriceBookDetail> priceBookDetails, Set<VariantAttributeValues> variantAttributeValueses, Set<CompositeProduct> compositeProductsForSelectiveProductAssociationId, Set<OrderDetail> orderDetails, Set<StockOrderDetail> stockOrderDetails, Set<InventoryCountDetail> inventoryCountDetails, Set<InvoiceDetail> invoiceDetails, Set<CompositeProduct> compositeProductsForProductAssocicationId, Set<ProductHistory> productHistories) {
      this.outlet = outlet;
      this.productType = productType;
      this.userByCreatedBy = userByCreatedBy;
      this.userByUpdatedBy = userByUpdatedBy;
      this.company = company;
      this.brand = brand;
      this.salesTax = salesTax;
      this.contact = contact;
      this.productName = productName;
      this.productUuid = productUuid;
      this.productDesc = productDesc;
      this.productHandler = productHandler;
      this.salesAccountCode = salesAccountCode;
      this.purchaseAccountCode = purchaseAccountCode;
      this.productCanBeSold = productCanBeSold;
      this.standardProduct = standardProduct;
      this.trackingProduct = trackingProduct;
      this.variantProducts = variantProducts;
      this.currentInventory = currentInventory;
      this.reorderPoint = reorderPoint;
      this.reorderAmount = reorderAmount;
      this.supplyPriceExclTax = supplyPriceExclTax;
      this.markupPrct = markupPrct;
      this.sku = sku;
      this.imagePath = imagePath;
      this.display = display;
      this.activeIndicator = activeIndicator;
      this.createdDate = createdDate;
      this.lastUpdated = lastUpdated;
      this.attribute1 = attribute1;
      this.attribute2 = attribute2;
      this.attribute3 = attribute3;
      this.productTags = productTags;
      this.productVariants = productVariants;
      this.priceBookDetails = priceBookDetails;
      this.variantAttributeValueses = variantAttributeValueses;
      this.compositeProductsForSelectiveProductAssociationId = compositeProductsForSelectiveProductAssociationId;
      this.orderDetails = orderDetails;
      this.stockOrderDetails = stockOrderDetails;
      this.inventoryCountDetails = inventoryCountDetails;
      this.invoiceDetails = invoiceDetails;
      this.compositeProductsForProductAssocicationId = compositeProductsForProductAssocicationId;
      this.productHistories = productHistories;
   }
  
    @Id @GeneratedValue(strategy=IDENTITY)

   
   @Column(name="PRODUCT_ID", unique=true, nullable=false)
   public Integer getProductId() {
       return this.productId;
   }
   
   public void setProductId(Integer productId) {
       this.productId = productId;
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
   @JoinColumn(name="PRODUCT_TYPE_ASSOCICATION_ID", nullable=false)
   public ProductType getProductType() {
       return this.productType;
   }
   
   public void setProductType(ProductType productType) {
       this.productType = productType;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="CREATED_BY", nullable=false)
   public User getUserByCreatedBy() {
       return this.userByCreatedBy;
   }
   
   public void setUserByCreatedBy(User userByCreatedBy) {
       this.userByCreatedBy = userByCreatedBy;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="UPDATED_BY", nullable=false)
   public User getUserByUpdatedBy() {
       return this.userByUpdatedBy;
   }
   
   public void setUserByUpdatedBy(User userByUpdatedBy) {
       this.userByUpdatedBy = userByUpdatedBy;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="COMPANY_ASSOCIATION_ID", nullable=false)
   public Company getCompany() {
       return this.company;
   }
   
   public void setCompany(Company company) {
       this.company = company;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="BRAND_ASSOCICATION_ID", nullable=false)
   public Brand getBrand() {
       return this.brand;
   }
   
   public void setBrand(Brand brand) {
       this.brand = brand;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="SALES_TAX_ASSOCICATION_ID", nullable=false)
   public SalesTax getSalesTax() {
       return this.salesTax;
   }
   
   public void setSalesTax(SalesTax salesTax) {
       this.salesTax = salesTax;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="CONTACT_ASSOCICATION_ID", nullable=false)
   public Contact getContact() {
       return this.contact;
   }
   
   public void setContact(Contact contact) {
       this.contact = contact;
   }

   
   @Column(name="PRODUCT_NAME", nullable=false, length=500)
   public String getProductName() {
       return this.productName;
   }
   
   public void setProductName(String productName) {
       this.productName = productName;
   }

   
   @Column(name="PRODUCT_UUID", nullable=false, length=500)
   public String getProductUuid() {
       return this.productUuid;
   }
   
   public void setProductUuid(String productUuid) {
       this.productUuid = productUuid;
   }

   
   @Column(name="PRODUCT_DESC", length=1000)
   public String getProductDesc() {
       return this.productDesc;
   }
   
   public void setProductDesc(String productDesc) {
       this.productDesc = productDesc;
   }

   
   @Column(name="PRODUCT_HANDLER", nullable=false, length=45)
   public String getProductHandler() {
       return this.productHandler;
   }
   
   public void setProductHandler(String productHandler) {
       this.productHandler = productHandler;
   }

   
   @Column(name="SALES_ACCOUNT_CODE", length=45)
   public String getSalesAccountCode() {
       return this.salesAccountCode;
   }
   
   public void setSalesAccountCode(String salesAccountCode) {
       this.salesAccountCode = salesAccountCode;
   }

   
   @Column(name="PURCHASE_ACCOUNT_CODE", length=45)
   public String getPurchaseAccountCode() {
       return this.purchaseAccountCode;
   }
   
   public void setPurchaseAccountCode(String purchaseAccountCode) {
       this.purchaseAccountCode = purchaseAccountCode;
   }

   
   @Column(name="PRODUCT_CAN_BE_SOLD", nullable=false, length=10)
   public String getProductCanBeSold() {
       return this.productCanBeSold;
   }
   
   public void setProductCanBeSold(String productCanBeSold) {
       this.productCanBeSold = productCanBeSold;
   }

   
   @Column(name="STANDARD_PRODUCT", nullable=false, length=10)
   public String getStandardProduct() {
       return this.standardProduct;
   }
   
   public void setStandardProduct(String standardProduct) {
       this.standardProduct = standardProduct;
   }

   
   @Column(name="TRACKING_PRODUCT", nullable=false, length=10)
   public String getTrackingProduct() {
       return this.trackingProduct;
   }
   
   public void setTrackingProduct(String trackingProduct) {
       this.trackingProduct = trackingProduct;
   }

   
   @Column(name="VARIANT_PRODUCTS", nullable=false, length=10)
   public String getVariantProducts() {
       return this.variantProducts;
   }
   
   public void setVariantProducts(String variantProducts) {
       this.variantProducts = variantProducts;
   }

   
   @Column(name="CURRENT_INVENTORY")
   public Integer getCurrentInventory() {
       return this.currentInventory;
   }
   
   public void setCurrentInventory(Integer currentInventory) {
       this.currentInventory = currentInventory;
   }

   
   @Column(name="REORDER_POINT")
   public Integer getReorderPoint() {
       return this.reorderPoint;
   }
   
   public void setReorderPoint(Integer reorderPoint) {
       this.reorderPoint = reorderPoint;
   }

   
   @Column(name="REORDER_AMOUNT", precision=20)
   public BigDecimal getReorderAmount() {
       return this.reorderAmount;
   }
   
   public void setReorderAmount(BigDecimal reorderAmount) {
       this.reorderAmount = reorderAmount;
   }

   
   @Column(name="SUPPLY_PRICE_EXCL_TAX", nullable=false, precision=20)
   public BigDecimal getSupplyPriceExclTax() {
       return this.supplyPriceExclTax;
   }
   
   public void setSupplyPriceExclTax(BigDecimal supplyPriceExclTax) {
       this.supplyPriceExclTax = supplyPriceExclTax;
   }

   
   @Column(name="MARKUP_PRCT", nullable=false, precision=8, scale=5)
   public BigDecimal getMarkupPrct() {
       return this.markupPrct;
   }
   
   public void setMarkupPrct(BigDecimal markupPrct) {
       this.markupPrct = markupPrct;
   }

   
   @Column(name="SKU", nullable=false, length=500)
   public String getSku() {
       return this.sku;
   }
   
   public void setSku(String sku) {
       this.sku = sku;
   }

   
   @Column(name="IMAGE_PATH", length=250)
   public String getImagePath() {
       return this.imagePath;
   }
   
   public void setImagePath(String imagePath) {
       this.imagePath = imagePath;
   }

   
   @Column(name="DISPLAY")
   public Boolean getDisplay() {
       return this.display;
   }
   
   public void setDisplay(Boolean display) {
       this.display = display;
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

   
   @Column(name="attribute1", length=500)
   public String getAttribute1() {
       return this.attribute1;
   }
   
   public void setAttribute1(String attribute1) {
       this.attribute1 = attribute1;
   }

   
   @Column(name="attribute2", length=500)
   public String getAttribute2() {
       return this.attribute2;
   }
   
   public void setAttribute2(String attribute2) {
       this.attribute2 = attribute2;
   }

   
   @Column(name="attribute3", length=500)
   public String getAttribute3() {
       return this.attribute3;
   }
   
   public void setAttribute3(String attribute3) {
       this.attribute3 = attribute3;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<ProductTag> getProductTags() {
       return this.productTags;
   }
   
   public void setProductTags(Set<ProductTag> productTags) {
       this.productTags = productTags;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<ProductVariant> getProductVariants() {
       return this.productVariants;
   }
   
   public void setProductVariants(Set<ProductVariant> productVariants) {
       this.productVariants = productVariants;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<PriceBookDetail> getPriceBookDetails() {
       return this.priceBookDetails;
   }
   
   public void setPriceBookDetails(Set<PriceBookDetail> priceBookDetails) {
       this.priceBookDetails = priceBookDetails;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<VariantAttributeValues> getVariantAttributeValueses() {
       return this.variantAttributeValueses;
   }
   
   public void setVariantAttributeValueses(Set<VariantAttributeValues> variantAttributeValueses) {
       this.variantAttributeValueses = variantAttributeValueses;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productBySelectiveProductAssociationId")
   public Set<CompositeProduct> getCompositeProductsForSelectiveProductAssociationId() {
       return this.compositeProductsForSelectiveProductAssociationId;
   }
   
   public void setCompositeProductsForSelectiveProductAssociationId(Set<CompositeProduct> compositeProductsForSelectiveProductAssociationId) {
       this.compositeProductsForSelectiveProductAssociationId = compositeProductsForSelectiveProductAssociationId;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<OrderDetail> getOrderDetails() {
       return this.orderDetails;
   }
   
   public void setOrderDetails(Set<OrderDetail> orderDetails) {
       this.orderDetails = orderDetails;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<StockOrderDetail> getStockOrderDetails() {
       return this.stockOrderDetails;
   }
   
   public void setStockOrderDetails(Set<StockOrderDetail> stockOrderDetails) {
       this.stockOrderDetails = stockOrderDetails;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<InventoryCountDetail> getInventoryCountDetails() {
       return this.inventoryCountDetails;
   }
   
   public void setInventoryCountDetails(Set<InventoryCountDetail> inventoryCountDetails) {
       this.inventoryCountDetails = inventoryCountDetails;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<InvoiceDetail> getInvoiceDetails() {
       return this.invoiceDetails;
   }
   
   public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
       this.invoiceDetails = invoiceDetails;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="productByProductAssocicationId")
   public Set<CompositeProduct> getCompositeProductsForProductAssocicationId() {
       return this.compositeProductsForProductAssocicationId;
   }
   
   public void setCompositeProductsForProductAssocicationId(Set<CompositeProduct> compositeProductsForProductAssocicationId) {
       this.compositeProductsForProductAssocicationId = compositeProductsForProductAssocicationId;
   }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
   public Set<ProductHistory> getProductHistories() {
       return this.productHistories;
   }
   
   public void setProductHistories(Set<ProductHistory> productHistories) {
       this.productHistories = productHistories;
   }




}


