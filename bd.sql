/*
Script gerado por Aqua Data Studio 16.0.5-9 em mar-01-2017 09:24:26 PM
Banco de Dados: graoDeCevada
Esquema: <Todos os Esquemas>
Objetos: TABLE
*/
CREATE TABLE "categoria"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "cerveja"  ( 
	"id"              	bigint(20) AUTO_INCREMENT NOT NULL,
	"marca"           	varchar(255) NOT NULL,
	"categoria_id"    	bigint(20) NOT NULL,
	"embalagem_id"    	bigint(20) NOT NULL,
	"faixa_preco_id"  	bigint(20) NOT NULL,
	"fermentacao_id"  	bigint(20) NOT NULL,
	"litragem_id"     	bigint(20) NOT NULL,
	"nacionalidade_id"	bigint(20) NOT NULL,
	"pais_origem_id"  	bigint(20) NOT NULL,
	"sabor_id"        	bigint(20) NOT NULL,
	"tipo_id"         	bigint(20) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "embalagem"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "faixa_preco"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "fermentacao"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "litragem"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "nacionalidade"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "pais"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "sabor"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO
CREATE TABLE "tipo_cerveja"  ( 
	"id"       	bigint(20) AUTO_INCREMENT NOT NULL,
	"descricao"	varchar(255) NOT NULL,
	PRIMARY KEY("id")
)
GO

INSERT INTO "categoria"("id", "descricao")
  VALUES(1, 'Premium')
GO
INSERT INTO "categoria"("id", "descricao")
  VALUES(2, 'Especiais')
GO
INSERT INTO "embalagem"("id", "descricao")
  VALUES(1, 'Lata')
GO
INSERT INTO "embalagem"("id", "descricao")
  VALUES(2, 'Litrão')
GO
INSERT INTO "embalagem"("id", "descricao")
  VALUES(3, 'Litrinho')
GO
INSERT INTO "embalagem"("id", "descricao")
  VALUES(4, 'Long neck')
GO
INSERT INTO "embalagem"("id", "descricao")
  VALUES(5, 'Garrafa')
GO
INSERT INTO "faixa_preco"("id", "descricao")
  VALUES(1, 'Até R$29,99')
GO
INSERT INTO "faixa_preco"("id", "descricao")
  VALUES(2, 'De R$30,00 a R$ 59,99')
GO
INSERT INTO "faixa_preco"("id", "descricao")
  VALUES(3, 'Acima de R$60,00')
GO
INSERT INTO "fermentacao"("id", "descricao")
  VALUES(1, 'Ale')
GO
INSERT INTO "fermentacao"("id", "descricao")
  VALUES(2, 'Lager')
GO
INSERT INTO "litragem"("id", "descricao")
  VALUES(1, 'Até 335ml')
GO
INSERT INTO "litragem"("id", "descricao")
  VALUES(2, 'Entre 335 e 600ml')
GO
INSERT INTO "litragem"("id", "descricao")
  VALUES(3, 'Acima de 600ml')
GO
INSERT INTO "nacionalidade"("id", "descricao")
  VALUES(1, 'Nacional')
GO
INSERT INTO "nacionalidade"("id", "descricao")
  VALUES(2, 'Internacional')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(1, 'Alemanha')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(2, 'Argentina')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(3, 'Bélgica')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(4, 'Brasil')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(5, 'EUA')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(6, 'Inglaterra')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(7, 'México')
GO
INSERT INTO "pais"("id", "descricao")
  VALUES(8, 'Uruguai')
GO
INSERT INTO "sabor"("id", "descricao")
  VALUES(1, 'Adocicada')
GO
INSERT INTO "sabor"("id", "descricao")
  VALUES(2, 'Amarga')
GO
INSERT INTO "sabor"("id", "descricao")
  VALUES(3, 'Forte')
GO
INSERT INTO "sabor"("id", "descricao")
  VALUES(4, 'Frutada')
GO
INSERT INTO "sabor"("id", "descricao")
  VALUES(5, 'Suave')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(1, 'Amber Lager')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(2, 'Cerveja de trigo')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(3, 'Dark Lager')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(4, 'India Pale Ale(IPA)')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(5, 'Pale Ale')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(6, 'Pale Lager')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(7, 'Pilsner')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(8, 'Porter')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(9, 'Specialty Beer')
GO
INSERT INTO "tipo_cerveja"("id", "descricao")
  VALUES(10, 'Stout')
GO
CREATE INDEX "FK3s1pl0nnkj7evf8gshpbsul3i" USING BTREE 
	ON "cerveja"("pais_origem_id")
GO
CREATE INDEX "FK6clunx3pi8upp5js7ufxeb043" USING BTREE 
	ON "cerveja"("faixa_preco_id")
GO
CREATE INDEX "FK6inujpir79tobs54f90dm70yt" USING BTREE 
	ON "cerveja"("embalagem_id")
GO
CREATE INDEX "FK9qqin6lsbuake6bki4is6yers" USING BTREE 
	ON "cerveja"("fermentacao_id")
GO
CREATE INDEX "FKh6hnu0ir657uv20sx2fg2uxce" USING BTREE 
	ON "cerveja"("categoria_id")
GO
CREATE INDEX "FKi77rymnyvuncena4qb3qp3470" USING BTREE 
	ON "cerveja"("nacionalidade_id")
GO
CREATE INDEX "FKlaf612v7exj8y9v7rsc034shu" USING BTREE 
	ON "cerveja"("litragem_id")
GO
CREATE INDEX "FKoyt5ugldkuqr8gj36b9tkdfqo" USING BTREE 
	ON "cerveja"("sabor_id")
GO
CREATE INDEX "FKr0sv9t6s4hf7xhb6fradnef4k" USING BTREE 
	ON "cerveja"("tipo_id")
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FKr0sv9t6s4hf7xhb6fradnef4k"
	FOREIGN KEY("tipo_id")
	REFERENCES "tipo_cerveja"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FKoyt5ugldkuqr8gj36b9tkdfqo"
	FOREIGN KEY("sabor_id")
	REFERENCES "sabor"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FKlaf612v7exj8y9v7rsc034shu"
	FOREIGN KEY("litragem_id")
	REFERENCES "litragem"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FKi77rymnyvuncena4qb3qp3470"
	FOREIGN KEY("nacionalidade_id")
	REFERENCES "nacionalidade"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FKh6hnu0ir657uv20sx2fg2uxce"
	FOREIGN KEY("categoria_id")
	REFERENCES "categoria"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FK9qqin6lsbuake6bki4is6yers"
	FOREIGN KEY("fermentacao_id")
	REFERENCES "fermentacao"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FK6inujpir79tobs54f90dm70yt"
	FOREIGN KEY("embalagem_id")
	REFERENCES "embalagem"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FK6clunx3pi8upp5js7ufxeb043"
	FOREIGN KEY("faixa_preco_id")
	REFERENCES "faixa_preco"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
ALTER TABLE "cerveja"
	ADD CONSTRAINT "FK3s1pl0nnkj7evf8gshpbsul3i"
	FOREIGN KEY("pais_origem_id")
	REFERENCES "pais"("id")
	ON DELETE RESTRICT 
	ON UPDATE RESTRICT 
GO
