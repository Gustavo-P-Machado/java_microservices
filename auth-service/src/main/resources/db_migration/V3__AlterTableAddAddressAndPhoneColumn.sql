ALTER TABLE tb_user ADD COLUMN phone_number VARCHAR(255);
ALTER TABLE tb_user ADD COLUMN address VARCHAR(255);

UPDATE tb_user SET phone_number = '(54) 9 9999-9999';

UPDATE tb_user SET address = 'Endereço Teste';