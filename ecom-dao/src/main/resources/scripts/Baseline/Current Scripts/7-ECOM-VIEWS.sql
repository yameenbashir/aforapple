USE `ecom`;

-- -------------4-Views.SQL--------------------------------------




DROP VIEW IF EXISTS User_Sales_Report;
CREATE VIEW User_Sales_Report AS 

SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select CONCAT(FIRST_NAME, ' ',LAST_NAME) from ecom.user where ecom.user.USER_ID=ecom.invoice_detail.CREATED_BY) AS 'User',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) AS Revenue,(SUM(ITEM_SALE_PRICE* PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT* PRODUCT_QUANTITY ))  AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) AS 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) -SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY )) As 'Gross_Profit', 
(100-((SUM(ITEM_ORIGNAL_AMT))/(SUM(ITEM_SALE_PRICE)))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail
group by PRODUCT_ASSOCIATION_ID, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);


DROP VIEW IF EXISTS Outlet_Sales_Report;
CREATE VIEW Outlet_Sales_Report AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )  AS Revenue,(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT * PRODUCT_QUANTITY )) AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) AS 'Cost_of_Goods', 
((SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ))-(SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ))) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail
group by PRODUCT_ASSOCIATION_ID, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);

DROP VIEW IF EXISTS Brand_Sales_Report;
CREATE VIEW Brand_Sales_Report AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
(select BRAND_NAME from ecom.brand where BRAND_ID = (select BRAND_ASSOCICATION_ID from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID)) AS 'Brand',
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) AS Revenue,(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT * PRODUCT_QUANTITY )) AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) AS 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )-SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY )) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail
group by PRODUCT_ASSOCIATION_ID, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);



DROP VIEW IF EXISTS ProductType_Sales_Report;
CREATE VIEW ProductType_Sales_Report AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
(select PRODUCT_TYPE_NAME from ecom.product_type where PRODUCT_TYPE_ID = (select PRODUCT_TYPE_ASSOCICATION_ID from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID)) AS 'ProductType',
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )  AS Revenue,(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT * PRODUCT_QUANTITY )) AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) AS 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) -SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) ) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail
group by PRODUCT_ASSOCIATION_ID, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);




DROP VIEW IF EXISTS Inventory_Report;
CREATE VIEW Inventory_Report(ID,PRODUCT_NAME ,SKU ,SUPPLY_PRICE_EXCL_TAX,MARKUP_PRCT,REORDER_POINT,REORDER_AMOUNT,CURRENT_INVENTORY,NET_PRICE,OUTLET_NAME , OUTLET_ASSOCICATION_ID, CREATED_DATE, 
BRAND_NAME,PRODUCT_TYPE, CONTACT_NAME,COMPANY_ASSOCIATION_ID,STOCK_VALUE,RETAIL_VALUE) AS 
(SELECT PRODUCT_ID, PRODUCT_NAME,SKU,SUPPLY_PRICE_EXCL_TAX,MARKUP_PRCT,REORDER_POINT,REORDER_AMOUNT,CURRENT_INVENTORY
,(((SUPPLY_PRICE_EXCL_TAX*MARKUP_PRCT)/100)+SUPPLY_PRICE_EXCL_TAX) AS NET_PRICE,
(select OUTLET_NAME from  outlet WHERE OUTLET_ASSOCICATION_ID = OUTLET_ID) AS OUTLET_NAME ,
OUTLET_ASSOCICATION_ID , CREATED_DATE, (select BRAND_NAME from  brand WHERE BRAND_ASSOCICATION_ID = BRAND_ID) AS BRAND_NAME 
,(select PRODUCT_TYPE_NAME from  product_type WHERE PRODUCT_TYPE_ASSOCICATION_ID = PRODUCT_TYPE_ID) AS PRODUCT_TYPE
,(select CONTACT_NAME from  contact WHERE CONTACT_ASSOCICATION_ID = CONTACT_ID) AS CONTACT_NAME,  
COMPANY_ASSOCIATION_ID,(SUPPLY_PRICE_EXCL_TAX*CURRENT_INVENTORY) as STOCK_VALUE,
((((SUPPLY_PRICE_EXCL_TAX*MARKUP_PRCT)/100)+SUPPLY_PRICE_EXCL_TAX)*CURRENT_INVENTORY) As RETAIL_VALUE
FROM ecom.product where VARIANT_PRODUCTS='false' group by PRODUCT_UUID,OUTLET_ASSOCICATION_ID order by CREATED_DATE DESC )
UNION
(SELECT PRODUCT_VARIANT_ID, 
(CONCAT((select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCICATION_ID=PRODUCT_ID), ' ',VARIANT_ATTRIBUTE_NAME) )as VARIANT_ATTRIBUTE_NAME,
SKU,SUPPLY_PRICE_EXCL_TAX,MARKUP_PRCT,REORDER_POINT,REORDER_AMOUNT,CURRENT_INVENTORY
,(((SUPPLY_PRICE_EXCL_TAX*MARKUP_PRCT)/100)+SUPPLY_PRICE_EXCL_TAX) AS NET_PRICE,
(select OUTLET_NAME from  outlet WHERE OUTLET_ASSOCICATION_ID = OUTLET_ID) AS OUTLET_NAME ,
OUTLET_ASSOCICATION_ID , CREATED_DATE, 
(select BRAND_NAME from ecom.brand where BRAND_ID = (select BRAND_ASSOCICATION_ID from ecom.product where PRODUCT_ASSOCICATION_ID=PRODUCT_ID)) AS BRAND_NAME,
(select PRODUCT_TYPE_NAME from ecom.product_type where PRODUCT_TYPE_ID = (select PRODUCT_TYPE_ASSOCICATION_ID from ecom.product where PRODUCT_ASSOCICATION_ID=PRODUCT_ID)) AS PRODUCT_TYPE,
(select CONTACT_NAME from  contact WHERE CONTACT_ID = (select CONTACT_ASSOCICATION_ID from ecom.product where PRODUCT_ASSOCICATION_ID=PRODUCT_ID)) AS CONTACT_NAME,
COMPANY_ASSOCIATION_ID,(SUPPLY_PRICE_EXCL_TAX*CURRENT_INVENTORY) as STOCK_VALUE,
((((SUPPLY_PRICE_EXCL_TAX*MARKUP_PRCT)/100)+SUPPLY_PRICE_EXCL_TAX)*CURRENT_INVENTORY) As RETAIL_VALUE
FROM ecom.product_variant group by PRODUCT_VARIANT_UUID,OUTLET_ASSOCICATION_ID order by CREATED_DATE DESC);

DROP VIEW IF EXISTS Payment_Report;
CREATE VIEW Payment_Report AS 
SELECT 
OUTLET_ASSOCICATION_ID,(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) As 'OUTLET',

DATE(CREATED_DATE) AS CREATED_DATE, SUM(INVOICE_NET_AMT) AS AMOUNT,
COMPANY_ASSOCIATION_ID
FROM ecom.invoice_main 
group by COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);

DROP VIEW IF EXISTS Supplier_Sales_Report;
CREATE VIEW Supplier_Sales_Report AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
(select CONTACT_NAME from ecom.contact where CONTACT_TYPE LIKE '%SUPPLIER%' AND CONTACT_ID = (select CONTACT_ASSOCICATION_ID from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID)) AS 'Supplier',
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) AS Revenue,(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT * PRODUCT_QUANTITY )) AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) - SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY )) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail
group by Supplier, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);

DROP VIEW IF EXISTS Customer_Sales_Report;
CREATE VIEW Customer_Sales_Report AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
COALESCE((select CONTACT_NAME  from ecom.contact where CONTACT_TYPE LIKE '%CUSTOMER%' AND CONTACT_ID = (select CONTACT_ASSOCIATION_ID from ecom.invoice_main where INVOICE_MAIN_ASSOCICATION_ID=INVOICE_MAIN_ID)),'-') AS 'Customer' ,
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) AS Revenue,(SUM(ITEM_SALE_PRICE* PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT* PRODUCT_QUANTITY )) 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY )  AS 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )  - SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) ) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail 
group by Customer, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);


DROP VIEW IF EXISTS Customer_Group_Sales_Report;
CREATE VIEW Customer_Group_Sales_Report AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
COALESCE((select CONTACT_GROUP_NAME from contact_group where CONTACT_GROUP_ID  = (select CONTACT_GROUP_ASSOCIATION_ID  from ecom.contact where CONTACT_TYPE LIKE '%CUSTOMER%' AND CONTACT_ID = (select CONTACT_ASSOCIATION_ID from ecom.invoice_main where INVOICE_MAIN_ASSOCICATION_ID=INVOICE_MAIN_ID))),'-') AS 'Group_Name' ,
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY ) AS Revenue,(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT) * PRODUCT_QUANTITY )  AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT* PRODUCT_QUANTITY )  AS 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )  -SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) ) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail 
group by Group_Name, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);




DROP VIEW IF EXISTS Temp_Sale;
CREATE VIEW Temp_Sale AS 
SELECT 
(select PRODUCT_NAME from ecom.product where PRODUCT_ASSOCIATION_ID=PRODUCT_ID) AS 'Product',
(select OUTLET_NAME from ecom.outlet where OUTLET_ASSOCICATION_ID=OUTLET_ID) AS 'Outlet',
DATE(CREATED_DATE) AS CREATED_DATE, SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY)  AS Revenue,(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )+SUM(ITEM_TAX_AMOUNT * PRODUCT_QUANTITY )) AS 'Revenue_tax_incl', SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY ) AS 'Cost_of_Goods', 
(SUM(ITEM_SALE_PRICE * PRODUCT_QUANTITY )-SUM(ITEM_ORIGNAL_AMT * PRODUCT_QUANTITY )) As 'Gross_Profit', 
(100-(SUM(ITEM_ORIGNAL_AMT)/SUM(ITEM_SALE_PRICE))*100) As Margin,
SUM(PRODUCT_QUANTITY) AS 'Items_Sold',
SUM(ITEM_TAX_AMOUNT) AS Tax,
COMPANY_ASSOCIATION_ID,OUTLET_ASSOCICATION_ID
FROM ecom.invoice_detail
group by PRODUCT_ASSOCIATION_ID, DATE(CREATED_DATE)
Order by  DATE(CREATED_DATE);

DELIMITER $$

DROP VIEW IF EXISTS `ecom`.`register_report`$$

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `register_report` AS select `daily_register`.`OUTLET_ASSOCICATION_ID` AS `OUTLET_ASSOCICATION_ID`,(select `outlet`.`OUTLET_NAME` from `outlet` where (`daily_register`.`OUTLET_ASSOCICATION_ID` = `outlet`.`OUTLET_ID`)) AS `OUTLET_NAME`,ifnull(`daily_register`.`CASH_AMT_ACTUAL`,0) AS `CASH_AMT_ACTUAL`,ifnull(`daily_register`.`CREDIT_CARD_AMT_ACTUAL`,0) AS `CREDIT_CARD_AMT_ACTUAL`,date_format(`daily_register`.`CREATED_DATE`,'%b %d %Y %h:%i %p') AS `OPENING_DATE`,date_format(`daily_register`.`CLOSED_DATE`,'%b %d %Y %h:%i %p') AS `CLOSING_DATE`,(select concat(`user`.`FIRST_NAME`,' ',`user`.`LAST_NAME`) from `user` where (`user`.`USER_ID` = `daily_register`.`CREATED_BY`)) AS `Open_By`,coalesce((select concat(`user`.`FIRST_NAME`,' ',`user`.`LAST_NAME`) from `user` where (`user`.`USER_ID` = `daily_register`.`UPDATED_BY`)),`daily_register`.`CREATED_BY`) AS `Close_By`,(select `status`.`STATUS_DESC` from `status` where (`status`.`STATUS_ID` = `daily_register`.`STATUS_ASSOCICATION_ID`)) AS `Status`,`daily_register`.`COMPANY_ASSOCIATION_ID` AS `COMPANY_ASSOCIATION_ID`,`daily_register`.`DAILY_REGISTER_ID` AS `DAILY_REGISTER_ID`,coalesce(`daily_register`.`REGISTER_CLOSING_NOTES`,'-') AS `REGISTER_CLOSING_NOTES`,coalesce(`daily_register`.`REGISTER_OPENING_NOTES`,'-') AS `REGISTER_OPENING_NOTES` from `daily_register` order by cast(`daily_register`.`CREATED_DATE` as date)$$

DELIMITER ;

DELIMITER $$

DROP VIEW IF EXISTS `ecom`.`cash_sale`$$

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cash_sale` AS

SELECT 
         ( 
                SELECT `product`.`product_name` AS `product_name` 
                FROM   `product` 
                WHERE  ( 
                              `invoice_detail`.`product_association_id` = `product`.`product_id`)) AS `product`,
         ( 
                SELECT `outlet`.`outlet_name` AS `outlet_name` 
                FROM   `outlet` 
                WHERE  ( 
                              `invoice_main`.`outlet_assocication_id` = `outlet`.`outlet_id`)) AS `outlet`,
         cast(`invoice_main`.`created_date` AS date)                                           AS `created_date`,
         sum(((`invoice_detail`.`item_sale_price` * `invoice_detail`.`product_quantity`) - (COALESCE(`invoice_main`.`invoice_discount_amt`,0) /
         ( 
                SELECT count(`invoice_detail`.`invoice_main_assocication_id`) AS `count(``invoice_detail``.``invoice_main_assocication_id``)`
                FROM   `invoice_detail` 
                WHERE  ( 
                              `invoice_detail`.`invoice_main_assocication_id` = `invoice_main`.`invoice_main_id`))))) AS `revenue`,
         (sum(((`invoice_detail`.`item_sale_price` * `invoice_detail`.`product_quantity`) - (COALESCE(`invoice_main`.`invoice_discount_amt`,0) /
         ( 
                SELECT count(`invoice_detail`.`invoice_main_assocication_id`) AS `count(``invoice_detail``.``invoice_main_assocication_id``)`
                FROM   `invoice_detail` 
                WHERE  ( 
                              `invoice_detail`.`invoice_main_assocication_id` = `invoice_main`.`invoice_main_id`))))) + sum((`invoice_detail`.`item_tax_amount` * `invoice_detail`.`product_quantity`))) AS `revenue_tax_incl`,
         sum((`invoice_detail`.`item_orignal_amt` * `invoice_detail`.`product_quantity`))                                                                                                                AS `cost_of_goods`,
         (sum((`invoice_detail`.`item_sale_price` * `invoice_detail`.`product_quantity`)) - sum((`invoice_detail`.`item_orignal_amt` * `invoice_detail`.`product_quantity`)))                            AS `gross_profit`,
         COALESCE((100 - ((sum(`invoice_detail`.`item_orignal_amt`) / sum(`invoice_detail`.`item_sale_price`)) * 100)),0)                                                                                AS `margin`,
         sum(`invoice_detail`.`product_quantity`)                                                                                                                                                        AS `items_sold`,
         sum(`invoice_detail`.`item_tax_amount`)                                                                                                                                                         AS `tax`,
         `invoice_main`.`company_association_id`                                                                                                                                                         AS `company_association_id`,
         `invoice_main`.`outlet_assocication_id` AS `outlet_assocication_id` 
      ,receipt.PAYMENT_TYPE_ASSOCICATION_ID                                                                                                                                                        
FROM     `invoice_detail` 
JOIN     `invoice_main` 
ON      
                           `invoice_main`.`invoice_main_id` = `invoice_detail`.`invoice_main_assocication_id`

inner  join receipt on receipt.INVOICE_MAIN_ASSOCICATION_ID = invoice_main.INVOICE_MAIN_ID and  receipt.PAYMENT_TYPE_ASSOCICATION_ID = 1
WHERE     `invoice_main`.`status_assocication_id` <> 11 
GROUP BY `invoice_detail`.`product_association_id`, 
         cast(`invoice_main`.`created_date` AS date) 
ORDER BY cast(`invoice_main`.`created_date` AS date)$$
DELIMITER ;



DELIMITER $$

DROP VIEW IF EXISTS `ecom`.`credit_sale`$$

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `credit_sale` AS

SELECT 
         ( 
                SELECT `product`.`product_name` AS `product_name` 
                FROM   `product` 
                WHERE  ( 
                              `invoice_detail`.`product_association_id` = `product`.`product_id`)) AS `product`,
         ( 
                SELECT `outlet`.`outlet_name` AS `outlet_name` 
                FROM   `outlet` 
                WHERE  ( 
                              `invoice_main`.`outlet_assocication_id` = `outlet`.`outlet_id`)) AS `outlet`,
         cast(`invoice_main`.`created_date` AS date)                                           AS `created_date`,
         sum(((`invoice_detail`.`item_sale_price` * `invoice_detail`.`product_quantity`) - (COALESCE(`invoice_main`.`invoice_discount_amt`,0) /
         ( 
                SELECT count(`invoice_detail`.`invoice_main_assocication_id`) AS `count(``invoice_detail``.``invoice_main_assocication_id``)`
                FROM   `invoice_detail` 
                WHERE  ( 
                              `invoice_detail`.`invoice_main_assocication_id` = `invoice_main`.`invoice_main_id`))))) AS `revenue`,
         (sum(((`invoice_detail`.`item_sale_price` * `invoice_detail`.`product_quantity`) - (COALESCE(`invoice_main`.`invoice_discount_amt`,0) /
         ( 
                SELECT count(`invoice_detail`.`invoice_main_assocication_id`) AS `count(``invoice_detail``.``invoice_main_assocication_id``)`
                FROM   `invoice_detail` 
                WHERE  ( 
                              `invoice_detail`.`invoice_main_assocication_id` = `invoice_main`.`invoice_main_id`))))) + sum((`invoice_detail`.`item_tax_amount` * `invoice_detail`.`product_quantity`))) AS `revenue_tax_incl`,
         sum((`invoice_detail`.`item_orignal_amt` * `invoice_detail`.`product_quantity`))                                                                                                                AS `cost_of_goods`,
         (sum((`invoice_detail`.`item_sale_price` * `invoice_detail`.`product_quantity`)) - sum((`invoice_detail`.`item_orignal_amt` * `invoice_detail`.`product_quantity`)))                            AS `gross_profit`,
         COALESCE((100 - ((sum(`invoice_detail`.`item_orignal_amt`) / sum(`invoice_detail`.`item_sale_price`)) * 100)),0)                                                                                AS `margin`,
         sum(`invoice_detail`.`product_quantity`)                                                                                                                                                        AS `items_sold`,
         sum(`invoice_detail`.`item_tax_amount`)                                                                                                                                                         AS `tax`,
         `invoice_main`.`company_association_id`                                                                                                                                                         AS `company_association_id`,
         `invoice_main`.`outlet_assocication_id` AS `outlet_assocication_id` 
      ,receipt.PAYMENT_TYPE_ASSOCICATION_ID                                                                                                                                                        
FROM     `invoice_detail` 
JOIN     `invoice_main` 
ON      
                           `invoice_main`.`invoice_main_id` = `invoice_detail`.`invoice_main_assocication_id`

inner  join receipt on receipt.INVOICE_MAIN_ASSOCICATION_ID = invoice_main.INVOICE_MAIN_ID and  receipt.PAYMENT_TYPE_ASSOCICATION_ID = 2
WHERE     `invoice_main`.`status_assocication_id` <> 11 
GROUP BY `invoice_detail`.`product_association_id`, 
         cast(`invoice_main`.`created_date` AS date) 
ORDER BY cast(`invoice_main`.`created_date` AS date)$$
DELIMITER ;

DELIMITER $$

DROP VIEW IF EXISTS `ecom`.`sale_details`$$

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sale_details` AS select `product`.`PRODUCT_NAME` AS `Product`,COALESCE(product_variant.variant_attribute_name, product.PRODUCT_NAME) AS `Variant`,COALESCE( product_variant.SKU, product.PRODUCT_NAME) as SKU,(select `outlet`.`OUTLET_NAME` AS `OUTLET_NAME` from `outlet` where (`invoice_detail`.`OUTLET_ASSOCICATION_ID` = `outlet`.`OUTLET_ID`)) AS `Outlet`,cast(`invoice_detail`.`CREATED_DATE` as date) AS `CREATED_DATE`,sum((`invoice_detail`.`ITEM_SALE_PRICE` * `invoice_detail`.`PRODUCT_QUANTITY`)) AS `Revenue`,(sum((`invoice_detail`.`ITEM_SALE_PRICE` * `invoice_detail`.`PRODUCT_QUANTITY`)) + sum((`invoice_detail`.`ITEM_TAX_AMOUNT` * `invoice_detail`.`PRODUCT_QUANTITY`))) AS `Revenue_tax_incl`,sum((`invoice_detail`.`ITEM_ORIGNAL_AMT` * `invoice_detail`.`PRODUCT_QUANTITY`)) AS `Cost_of_Goods`,(sum((`invoice_detail`.`ITEM_SALE_PRICE` * `invoice_detail`.`PRODUCT_QUANTITY`)) - sum((`invoice_detail`.`ITEM_ORIGNAL_AMT` * `invoice_detail`.`PRODUCT_QUANTITY`))) AS `Gross_Profit`,(100 - ((sum(`invoice_detail`.`ITEM_ORIGNAL_AMT`) / sum(`invoice_detail`.`ITEM_SALE_PRICE`)) * 100)) AS `Margin`,sum(`invoice_detail`.`PRODUCT_QUANTITY`) AS `Items_Sold`,sum(`invoice_detail`.`ITEM_TAX_AMOUNT`) AS `Tax`,`invoice_detail`.`COMPANY_ASSOCIATION_ID` AS `COMPANY_ASSOCIATION_ID`,`invoice_detail`.`OUTLET_ASSOCICATION_ID` AS `OUTLET_ASSOCICATION_ID` from ((`invoice_detail` left join `product_variant` on((`product_variant`.`PRODUCT_VARIANT_ID` = `invoice_detail`.`PRODUCT_VARIENT_ASSOCIATION_ID`))) left join `product` on((`product`.`PRODUCT_ID` = `invoice_detail`.`PRODUCT_ASSOCIATION_ID`))) group by `invoice_detail`.`PRODUCT_ASSOCIATION_ID`,`invoice_detail`.`PRODUCT_VARIENT_ASSOCIATION_ID`,cast(`invoice_detail`.`CREATED_DATE` as date) order by cast(`invoice_detail`.`CREATED_DATE` as date)$$

DELIMITER ;

DELIMITER $$

DROP VIEW IF EXISTS `ecom`.`salereport_withsale`$$

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `salereport_withsale` 
AS select (select `product`.`PRODUCT_NAME` AS `PRODUCT_NAME` from `product` where (`invoice_detail`.`PRODUCT_ASSOCIATION_ID` = `product`.`PRODUCT_ID`)) AS `Product`,
(select `outlet`.`OUTLET_NAME` AS `OUTLET_NAME` from `outlet` where (`invoice_main`.`OUTLET_ASSOCICATION_ID` = `outlet`.`OUTLET_ID`)) AS `Outlet`,
cast(`invoice_main`.`CREATED_DATE` as date) AS `CREATED_DATE`,ITEM_DISCOUNT_PRCT,
sum(((`invoice_detail`.`ITEM_SALE_PRICE` * `invoice_detail`.`PRODUCT_QUANTITY`) - (coalesce(`invoice_main`.`INVOICE_DISCOUNT_AMT`,0) / (select count(`invoice_detail`.`INVOICE_MAIN_ASSOCICATION_ID`) AS `count(``invoice_detail``.``INVOICE_MAIN_ASSOCICATION_ID``)` from `invoice_detail` where (`invoice_detail`.`INVOICE_MAIN_ASSOCICATION_ID` = `invoice_main`.`INVOICE_MAIN_ID`))))) AS `Revenue`,
(sum(((`invoice_detail`.`ITEM_SALE_PRICE` * `invoice_detail`.`PRODUCT_QUANTITY`) - (coalesce(`invoice_main`.`INVOICE_DISCOUNT_AMT`,0) / (select count(`invoice_detail`.`INVOICE_MAIN_ASSOCICATION_ID`) AS `count(``invoice_detail``.``INVOICE_MAIN_ASSOCICATION_ID``)` from `invoice_detail` where (`invoice_detail`.`INVOICE_MAIN_ASSOCICATION_ID` = `invoice_main`.`INVOICE_MAIN_ID`))))) + sum((`invoice_detail`.`ITEM_TAX_AMOUNT` * `invoice_detail`.`PRODUCT_QUANTITY`))) AS `Revenue_tax_incl`,
sum((`invoice_detail`.`ITEM_ORIGNAL_AMT` * `invoice_detail`.`PRODUCT_QUANTITY`)) AS `Cost_of_Goods`,(sum((`invoice_detail`.`ITEM_SALE_PRICE` * `invoice_detail`.`PRODUCT_QUANTITY`)) - sum((`invoice_detail`.`ITEM_ORIGNAL_AMT` * `invoice_detail`.`PRODUCT_QUANTITY`))) AS `Gross_Profit`,coalesce((100 - ((sum(`invoice_detail`.`ITEM_ORIGNAL_AMT`) / sum(`invoice_detail`.`ITEM_SALE_PRICE`)) * 100)),0) AS `Margin`,
sum(`invoice_detail`.`PRODUCT_QUANTITY`) AS `Items_Sold`,sum(`invoice_detail`.`ITEM_TAX_AMOUNT`) AS `Tax`,`invoice_main`.`COMPANY_ASSOCIATION_ID` AS `COMPANY_ASSOCIATION_ID`,`invoice_main`.`OUTLET_ASSOCICATION_ID` AS `OUTLET_ASSOCICATION_ID` from (`invoice_detail` join `invoice_main` on((`invoice_main`.`INVOICE_MAIN_ID` = `invoice_detail`.`INVOICE_MAIN_ASSOCICATION_ID`))) where (((`invoice_main`.`STATUS_ASSOCICATION_ID` <> 11) 
and (`invoice_detail`.`ITEM_DISCOUNT_PRCT` > 0)) or ((`invoice_main`.`STATUS_ASSOCICATION_ID` <> 11) 
and (`invoice_main`.`INVOICE_DISCOUNT` > 0))) 
group by `invoice_detail`.`PRODUCT_ASSOCIATION_ID`,cast(`invoice_main`.`CREATED_DATE` as date) 
order by cast(`invoice_main`.`CREATED_DATE` as date)$$

DELIMITER ;