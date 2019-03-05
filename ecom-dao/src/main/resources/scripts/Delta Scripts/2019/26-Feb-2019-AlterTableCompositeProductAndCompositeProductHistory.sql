USE `ecom`;
ALTER TABLE composite_product
ADD COLUMN UNIT_QUANTITY int(11) not null AFTER PRODUCT_UUID;

ALTER TABLE composite_product_history
ADD COLUMN UNIT_QUANTITY int(11) not null AFTER PRODUCT_UUID;