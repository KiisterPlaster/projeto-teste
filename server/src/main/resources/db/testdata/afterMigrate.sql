set foreign_key_checks = 0;

delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from produto;
delete from usuario_grupo;
delete from usuario_produto;

set foreign_key_checks = 1;


ALTER TABLE grupo ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE permissao ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE usuario ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE produto ALTER COLUMN ID RESTART WITH 1;




insert into permissao (id, nome, descricao) values (1, 'EDITAR_PRODUTOS', 'Permite cadastro e edição de produtos'); 
insert into permissao (id, nome, descricao) values (2, 'LANCAR_MOVIMENTACOES', 'Permite lançamento das movimentações de estoque');

insert into grupo (id, nome) values (1, 'GERENTE'), (2, 'OPERADOR');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 2); 

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'João da Silva', 'joao@varejonline.com.br', '$2a$12$OLbbe0EYWAhh0XlDNek1cuwUvKqgyYcYrvFecBZbq8B0lT7Rzatqy', current_timestamp),
(2, 'Rodrigo Lima', 'rodrigo@varejonline.com.br', '$2a$12$OLbbe0EYWAhh0XlDNek1cuwUvKqgyYcYrvFecBZbq8B0lT7Rzatqy', current_timestamp),
(3, 'Maria Joaquina', 'maria@varejonline.com.br', '$2a$12$OLbbe0EYWAhh0XlDNek1cuwUvKqgyYcYrvFecBZbq8B0lT7Rzatqy', current_timestamp);

insert into produto (id, codigo_de_barra, nome, quantidade_minima, saldo_inicial) values (1, '1532148794159', 'Coca-Cola 2L', 23, 342);
insert into produto (id, codigo_de_barra, nome, quantidade_minima, saldo_inicial) values (2, '5164843156417', 'Desodorante Monange 150ml', 65, 332);
insert into produto (id, codigo_de_barra, nome, quantidade_minima, saldo_inicial) values (3, '1651618919668', 'Veja 500ml', 14, 144);

insert into usuario_produto (usuario_id, produto_id) values (1, 1), (1, 2), (2, 3);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 1), (2, 2), (3, 2);

