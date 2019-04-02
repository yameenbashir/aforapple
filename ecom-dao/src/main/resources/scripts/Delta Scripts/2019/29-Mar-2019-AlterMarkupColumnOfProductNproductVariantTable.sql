USE `ecom`;
ALTER TABLE product
MODIFY COLUMN MARKUP_PRCT decimal(12,5) not null;

ALTER TABLE product_variant
MODIFY COLUMN MARKUP_PRCT decimal(12,5) not null;