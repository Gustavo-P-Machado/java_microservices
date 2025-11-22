ALTER TABLE tb_product ADD COLUMN type VARCHAR(50);

UPDATE tb_product SET type = 'OTHER' WHERE type IS NULL;