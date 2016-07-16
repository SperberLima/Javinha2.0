
DROP TABLE IF EXISTS "Usuario" CASCADE
;
DROP TABLE IF EXISTS "Professor_Disciplina" CASCADE
;
DROP TABLE IF EXISTS "Horario" CASCADE
;
DROP TABLE IF EXISTS "Grade_Disciplina" CASCADE
;
DROP TABLE IF EXISTS "Turma" CASCADE
; 
DROP TABLE IF EXISTS "Grade_Curricular" CASCADE
;
DROP TABLE IF EXISTS "Curriculo_em_Oferta" CASCADE
;
DROP TABLE IF EXISTS "Período_Letivo" CASCADE
;
DROP TABLE IF EXISTS "Professor" CASCADE
;
DROP TABLE IF EXISTS "Ambiente_Aprendizagem" CASCADE
;
DROP TABLE IF EXISTS "Curso" CASCADE
; 
DROP TABLE IF EXISTS "Disciplina" CASCADE
;
DROP TABLE IF EXISTS "Departamento" CASCADE
;
DROP TABLE IF EXISTS "Unidade de Ensino" CASCADE
;

-- Create tables section -------------------------------------------------

-- Table Unidade de Ensino

CREATE TABLE "Unidade de Ensino"(
 "id_unidade_de_ensino" Serial NOT NULL,
 "cod_sigla" Character(8) NOT NULL,
 "txt_nome" Character varying(60) NOT NULL,
 "txt_email" Character varying(80) NOT NULL,
 "nro_telefone" Character varying(15) NOT NULL,
 "cod_cep" Character varying(9) NOT NULL,
 "txt_site" Character varying(80)
)
;
COMMENT ON COLUMN "Unidade de Ensino"."nro_telefone" IS '15 é o máximo'
;

-- Add keys for table Unidade de Ensino

ALTER TABLE "Unidade de Ensino" ADD CONSTRAINT "Key1" PRIMARY KEY ("id_unidade_de_ensino")
;

-- Table Departamento

CREATE TABLE "Departamento"(
 "id_departamento" Serial NOT NULL,
 "id_unidade_de_ensino" Integer NOT NULL,
 "cod_sigla" Character(10) NOT NULL,
 "txt_nome" Character varying(40) NOT NULL,
 "txt_email" Character varying(80) NOT NULL,
 "nro_telefone" Character(8) NOT NULL,
 "cod_cep" Character varying(9) NOT NULL,
 "txt_site" Character varying(100)
)
;
COMMENT ON COLUMN "Departamento"."cod_cep" IS 'pode ser 8 ou 9'
;

-- Create indexes for table Departamento

CREATE INDEX "IX_Relationship51" ON "Departamento" ("id_unidade_de_ensino")
;

-- Add keys for table Departamento

ALTER TABLE "Departamento" ADD CONSTRAINT "Key7" PRIMARY KEY ("id_departamento")
;

-- Table Disciplina

CREATE TABLE "Disciplina"(
 "id_disciplina" Serial NOT NULL,
 "id_departamento" Integer,
 "txt_nome" Character varying(20) NOT NULL,
 "qtd_carga_horaria" Integer NOT NULL,
 "txt_ementa" Text
)
;

-- Create indexes for table Disciplina

CREATE INDEX "IX_Relationship69" ON "Disciplina" ("id_departamento")
;

-- Add keys for table Disciplina

ALTER TABLE "Disciplina" ADD CONSTRAINT "Key8" PRIMARY KEY ("id_disciplina")
;

-- Table Curso

CREATE TABLE "Curso"(
 "id_curso" Serial NOT NULL,
 "id_departamento" Integer NOT NULL,
 "idt_tipo" Character(1) NOT NULL,
 "txt_nome" Character varying(30) NOT NULL,
 "txt_sigla" Character varying(10) NOT NULL
)
;
COMMENT ON COLUMN "Curso"."idt_tipo" IS 'S - Superior
T - Técnico
F - Fundamental
'
;

-- Create indexes for table Curso

CREATE INDEX "IX_Relationship1" ON "Curso" ("id_departamento")
;

-- Add keys for table Curso

ALTER TABLE "Curso" ADD CONSTRAINT "id_curso" PRIMARY KEY ("id_curso")
;

-- Table Ambiente_Aprendizagem

CREATE TABLE "Ambiente_Aprendizagem"(
 "id_ambiente" Serial NOT NULL,
 "id_unidade_de_ensino" Integer NOT NULL,
 "des_ambiente" Varchar NOT NULL,
 "qtd_capacidade" Integer NOT NULL,
 "nro_sala" Integer
)
;

-- Create indexes for table Ambiente_Aprendizagem

CREATE INDEX "IX_Relationship47" ON "Ambiente_Aprendizagem" ("id_unidade_de_ensino")
;

-- Add keys for table Ambiente_Aprendizagem

ALTER TABLE "Ambiente_Aprendizagem" ADD CONSTRAINT "Key11" PRIMARY KEY ("id_ambiente")
;

-- Table Professor

CREATE TABLE "Professor"(
 "id_professor" Serial NOT NULL,
 "id_departamento" Integer NOT NULL,
 "txt_nome" Character varying(60) NOT NULL,
 "nro_telefone" Character varying(9) NOT NULL,
 "cod_cpf" Character varying(14) NOT NULL,
 "txt_descricao" Text
)
;

-- Create indexes for table Professor

CREATE INDEX "IX_Relationship43" ON "Professor" ("id_departamento")
;

-- Add keys for table Professor

ALTER TABLE "Professor" ADD CONSTRAINT "Key12" PRIMARY KEY ("id_professor")
;

-- Table Período_Letivo

CREATE TABLE "Período_Letivo"(
 "id_periodo" Serial NOT NULL,
 "dat_inicio" Date NOT NULL,
 "dat_fim" Date NOT NULL,
 "txt_descricao" Character varying(20) NOT NULL
)
;
COMMENT ON COLUMN "Período_Letivo"."txt_descricao" IS 'Se é semestre ou Bimenstre'
;

-- Add keys for table Período_Letivo

ALTER TABLE "Período_Letivo" ADD CONSTRAINT "Key13" PRIMARY KEY ("id_periodo")
;

-- Table Curriculo_em_Oferta

CREATE TABLE "Curriculo_em_Oferta"(
 "id_curriculo_oferta" Serial NOT NULL,
 "id_periodo" Integer NOT NULL,
 "id_grade" Integer NOT NULL
)
;

-- Create indexes for table Curriculo_em_Oferta

CREATE INDEX "IX_Relationship8" ON "Curriculo_em_Oferta" ("id_periodo")
;

CREATE INDEX "IX_Relationship57" ON "Curriculo_em_Oferta" ("id_grade")
;

-- Add keys for table Curriculo_em_Oferta

ALTER TABLE "Curriculo_em_Oferta" ADD CONSTRAINT "Key18" PRIMARY KEY ("id_curriculo_oferta")
;

-- Table Grade_Curricular

CREATE TABLE "Grade_Curricular"(
 "id_grade" Serial NOT NULL,
 "id_curso" Integer,
 "nro_serie" Integer NOT NULL,
 "txt_descricao" Text NOT NULL
)
;

-- Create indexes for table Grade_Curricular

CREATE INDEX "IX_Relationship58" ON "Grade_Curricular" ("id_curso")
;

-- Add keys for table Grade_Curricular

ALTER TABLE "Grade_Curricular" ADD CONSTRAINT "Key27" PRIMARY KEY ("id_grade")
;

-- Table Turma

CREATE TABLE "Turma"(
 "id_turma" Serial NOT NULL,
 "id_curriculo_oferta" Integer NOT NULL,
 "txt_nome" Character varying(30) NOT NULL
)
;

-- Create indexes for table Turma

CREATE INDEX "IX_Relationship70" ON "Turma" ("id_curriculo_oferta")
;

-- Add keys for table Turma

ALTER TABLE "Turma" ADD CONSTRAINT "Key32" PRIMARY KEY ("id_turma")
;

-- Table Grade_Disciplina

CREATE TABLE "Grade_Disciplina"(
 "id_grade_disc" Serial NOT NULL,
 "id_grade" Integer NOT NULL,
 "id_disciplina" Integer
)
;

-- Create indexes for table Grade_Disciplina

CREATE INDEX "IX_Relationship76" ON "Grade_Disciplina" ("id_grade")
;

CREATE INDEX "IX_Relationship83" ON "Grade_Disciplina" ("id_disciplina")
;

-- Add keys for table Grade_Disciplina

ALTER TABLE "Grade_Disciplina" ADD CONSTRAINT "Key34" PRIMARY KEY ("id_grade_disc")
;

-- Table Horario

CREATE TABLE "Horario"(
 "id_horario" Serial NOT NULL,
 "id_ambiente" Integer NOT NULL,
 "id_turma" Integer NOT NULL,
 "id_prof_disc" Integer NOT NULL,
 "dat_inicio" Time NOT NULL,
 "dat_fim" Time NOT NULL
)
;

-- Create indexes for table Horario

CREATE INDEX "IX_Relationship79" ON "Horario" ("id_turma")
;

CREATE INDEX "IX_Relationship78" ON "Horario" ("id_ambiente")
;

CREATE INDEX "IX_Relationship87" ON "Horario" ("id_prof_disc")
;

-- Add keys for table Horario

ALTER TABLE "Horario" ADD CONSTRAINT "Key35" PRIMARY KEY ("id_horario")
;

-- Table Professor_Disciplina

CREATE TABLE "Professor_Disciplina"(
 "id_prof_disc" Serial NOT NULL,
 "id_professor" Integer NOT NULL,
 "id_disciplina" Integer NOT NULL
)
;

-- Create indexes for table Professor_Disciplina

CREATE INDEX "IX_Relationship80" ON "Professor_Disciplina" ("id_professor")
;

CREATE INDEX "IX_Relationship81" ON "Professor_Disciplina" ("id_disciplina")
;

-- Add keys for table Professor_Disciplina

ALTER TABLE "Professor_Disciplina" ADD CONSTRAINT "Key36" PRIMARY KEY ("id_prof_disc")
;

-- Table Usuario

CREATE TABLE "Usuario"(
 "txt_nome" Character varying(40) NOT NULL,
 "txt_senha" Varchar NOT NULL
)
;

-- Add keys for table Usuario

ALTER TABLE "Usuario" ADD CONSTRAINT "Key37" PRIMARY KEY ("txt_nome")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "Curso" ADD CONSTRAINT "tem_Dpto" FOREIGN KEY ("id_departamento") REFERENCES "Departamento" ("id_departamento") ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE "Curriculo_em_Oferta" ADD CONSTRAINT "Relationship8" FOREIGN KEY ("id_periodo") REFERENCES "Período_Letivo" ("id_periodo") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Professor" ADD CONSTRAINT "Relationship43" FOREIGN KEY ("id_departamento") REFERENCES "Departamento" ("id_departamento") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Ambiente_Aprendizagem" ADD CONSTRAINT "Relationship47" FOREIGN KEY ("id_unidade_de_ensino") REFERENCES "Unidade de Ensino" ("id_unidade_de_ensino") ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE "Departamento" ADD CONSTRAINT "Relationship51" FOREIGN KEY ("id_unidade_de_ensino") REFERENCES "Unidade de Ensino" ("id_unidade_de_ensino") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Curriculo_em_Oferta" ADD CONSTRAINT "Relationship57" FOREIGN KEY ("id_grade") REFERENCES "Grade_Curricular" ("id_grade") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Grade_Curricular" ADD CONSTRAINT "Relationship58" FOREIGN KEY ("id_curso") REFERENCES "Curso" ("id_curso") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Disciplina" ADD CONSTRAINT "Relationship69" FOREIGN KEY ("id_departamento") REFERENCES "Departamento" ("id_departamento") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Turma" ADD CONSTRAINT "Relationship70" FOREIGN KEY ("id_curriculo_oferta") REFERENCES "Curriculo_em_Oferta" ("id_curriculo_oferta") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Grade_Disciplina" ADD CONSTRAINT "Relationship76" FOREIGN KEY ("id_grade") REFERENCES "Grade_Curricular" ("id_grade") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Horario" ADD CONSTRAINT "Relationship78" FOREIGN KEY ("id_ambiente") REFERENCES "Ambiente_Aprendizagem" ("id_ambiente") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Horario" ADD CONSTRAINT "Relationship79" FOREIGN KEY ("id_turma") REFERENCES "Turma" ("id_turma") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Professor_Disciplina" ADD CONSTRAINT "Relationship80" FOREIGN KEY ("id_professor") REFERENCES "Professor" ("id_professor") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Professor_Disciplina" ADD CONSTRAINT "Relationship81" FOREIGN KEY ("id_disciplina") REFERENCES "Disciplina" ("id_disciplina") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Grade_Disciplina" ADD CONSTRAINT "Relationship83" FOREIGN KEY ("id_disciplina") REFERENCES "Disciplina" ("id_disciplina") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Horario" ADD CONSTRAINT "Relationship87" FOREIGN KEY ("id_prof_disc") REFERENCES "Professor_Disciplina" ("id_prof_disc") ON DELETE NO ACTION ON UPDATE NO ACTION
;


