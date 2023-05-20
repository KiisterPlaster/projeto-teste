set foreign_key_checks = 0;

delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from usuario_grupo;

set foreign_key_checks = 1;

ALTER TABLE grupo ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE permissao ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE usuario ALTER COLUMN ID RESTART WITH 1;



insert into permissao (id, nome, descricao) values (1, 'EDITAR_PRODUTOS', 'Permite cadastro e edição de produtos'); 
insert into permissao (id, nome, descricao) values (2, 'LANCAR_MOVIMENTACOES', 'Permite lançamento das movimentações de estoque');

insert into grupo (id, nome) values (1, 'GERENTE'), (2, 'OPERADOR');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 2); 

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'João da Silva', 'joao@varejonline.com.br', '123', current_timestamp),
(2, 'Maria Joaquina', 'maria@varejonline.com.br', '123', current_timestamp);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2);

