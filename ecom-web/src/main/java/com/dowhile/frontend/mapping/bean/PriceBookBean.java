/**
 * 
 */
package com.dowhile.frontend.mapping.bean;

import java.util.List;


/**
 * @author Yameen Bashir
 *
 */
public class PriceBookBean {
	
	private String priceBookId;
	private String companyId;
	private String companyName;
	private String contactGroupId;
	private String contactGroupName;
	private String outletId;
	private String outletName;
	private String priceBookName;
	private String validFrom;
	private String validTo;
	private String isValidOnStore;
	private String isValidOnEcom;
	private String createdDate;
	private String flatSale;
    private String flatDiscount; 
    private String active;
	private List<PriceBookDetailBean> PriceBookDetailBeans;
	private List<OutletBean> outletBeans;
	/**
	 * 
	 */
	public PriceBookBean() {
	}
	/**
	 * @param priceBookId
	 * @param companyId
	 * @param companyName
	 * @param contactGroupId
	 * @param contactGroupName
	 * @param outletId
	 * @param outletName
	 * @param priceBookName
	 * @param validFrom
	 * @param validTo
	 * @param isValidOnStore
	 * @param isValidOnEcom
	 * @param createdDate
	 * @param flatSale
	 * @param flatDiscount
	 * @param active
	 * @param priceBookDetailBeans
	 * @param outletBeans
	 */
	public PriceBookBean(String priceBookId, String companyId,
			String companyName, String contactGroupId, String contactGroupName,
			String outletId, String outletName, String priceBookName,
			String validFrom, String validTo, String isValidOnStore,
			String isValidOnEcom, String createdDate, String flatSale,
			String flatDiscount, String active,
			List<PriceBookDetailBean> priceBookDetailBeans,
			List<OutletBean> outletBeans) {
		this.priceBookId = priceBookId;
		this.companyId = companyId;
		this.companyName = companyName;
		this.contactGroupId = contactGroupId;
		this.contactGroupName = contactGroupName;
		this.outletId = outletId;
		this.outletName = outletName;
		this.priceBookName = priceBookName;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.isValidOnStore = isValidOnStore;
		this.isValidOnEcom = isValidOnEcom;
		this.createdDate = createdDate;
		this.flatSale = flatSale;
		this.flatDiscount = flatDiscount;
		this.active = active;
		PriceBookDetailBeans = priceBookDetailBeans;
		this.outletBeans = outletBeans;
	}
	public String getPriceBookId() {
		return priceBookId;
	}
	public void setPriceBookId(String priceBookId) {
		this.priceBookId = priceBookId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactGroupId() {
		return contactGroupId;
	}
	public void setContactGroupId(String contactGroupId) {
		this.contactGroupId = contactGroupId;
	}
	public String getContactGroupName() {
		return contactGroupName;
	}
	public void setContactGroupName(String contactGroupName) {
		this.contactGroupName = contactGroupName;
	}
	public String getOutletId() {
		return outletId;
	}
	public void setOutletId(String outletId) {
		this.outletId = outletId;
	}
	public String getOutletName() {
		return outletName;
	}
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}
	public String getPriceBookName() {
		return priceBookName;
	}
	public void setPriceBookName(String priceBookName) {
		this.priceBookName = priceBookName;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public String getIsValidOnStore() {
		return isValidOnStore;
	}
	public void setIsValidOnStore(String isValidOnStore) {
		this.isValidOnStore = isValidOnStore;
	}
	public String getIsValidOnEcom() {
		return isValidOnEcom;
	}
	public void setIsValidOnEcom(String isValidOnEcom) {
		this.isValidOnEcom = isValidOnEcom;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getFlatSale() {
		return flatSale;
	}
	public void setFlatSale(String flatSale) {
		this.flatSale = flatSale;
	}
	public String getFlatDiscount() {
		return flatDiscount;
	}
	public void setFlatDiscount(String flatDiscount) {
		this.flatDiscount = flatDiscount;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public List<PriceBookDetailBean> getPriceBookDetailBeans() {
		return PriceBookDetailBeans;
	}
	public void setPriceBookDetailBeans(
			List<PriceBookDetailBean> priceBookDetailBeans) {
		PriceBookDetailBeans = priceBookDetailBeans;
	}
	public List<OutletBean> getOutletBeans() {
		return outletBeans;
	}
	public void setOutletBeans(List<OutletBean> outletBeans) {
		this.outletBeans = outletBeans;
	}
}
