create table produto (
	id bigint not null auto_increment,
	nome varchar(80) not null,
	quantidade_minima bigint not null,
	saldo_inicial bigint not null,
	
	primary key (id)
);

alter table produto add codigo_de_barra varchar(13) not null after id;
update produto set codigo_de_barra = rand();
alter table produto add constraint uk_produto_codigo_de_barra unique(codigo_de_barra);
 

create table usuario_produto (
	usuario_id bigint not null,
	produto_id bigint not null,
	
	primary key (usuario_id, produto_id)
);