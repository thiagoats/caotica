INSERT INTO users (username, password, authority) VALUES ("admin@caotica.br", "$2a$10$WD8yeBjJ.1bJpmMcKP5MPe19Os/3ZQio3uZ8xOj0BJTxrPNYcWtaO", "ADMIN");

INSERT INTO associates (cpf, name, birth, gender) VALUES ("24757689080", "Joaquim José da Silva Xavier", "1792-11-12", "MAL");

INSERT INTO addresses (associates_id, place, complement, district) VALUES (1, "Rua da Inconfidência Mineira", "Casa 999-A", "Contagem");

INSERT INTO contacts (associates_id, cellphone, telephone, email) VALUES (1, "(99)99999-9999", "(99)9999-9999", "tiradentes@gmail.com");

INSERT INTO associations (register, start, end, amount, type, associates_id) VALUES ("2025-01-01", "2025-01-01", "2025-12-01", 60, "INST", 1);