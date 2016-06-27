-- CREATE DATABASE scm;

DROP TABLE IF EXISTS aluno CASCADE;
DROP TABLE IF EXISTS curso CASCADE;
DROP TABLE IF EXISTS turma CASCADE;
DROP TABLE IF EXISTS matricula CASCADE;

CREATE TABLE aluno (
    id bigserial CONSTRAINT aluno_pkey PRIMARY KEY,
    nome text,
    cpf bigint,
    endereco text,
    telefone text,
    CONSTRAINT unq_aluno_cpf UNIQUE(cpf)	
);

CREATE TABLE curso (
    id bigserial CONSTRAINT curso_pkey PRIMARY KEY,
    nome text,
    cargahoraria integer,
    CONSTRAINT unq_curso_nome UNIQUE(nome)
);

CREATE TABLE turma (
    id bigserial CONSTRAINT turma_pkey PRIMARY KEY,
    curso_id bigint,
    vagaslimite smallint,
    inicio date,
    termino date
);

ALTER TABLE turma ADD CONSTRAINT fk_turma_curso FOREIGN KEY (curso_id) 
      REFERENCES curso (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE matricula (
    id bigserial CONSTRAINT matricula_pkey PRIMARY KEY,
    turma_id bigint,
    aluno_id bigint,
    datainscricao date,
    notafinal smallint
);

ALTER TABLE matricula ADD CONSTRAINT fk_matricula_turma FOREIGN KEY (turma_id) 
      REFERENCES turma (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE matricula ADD CONSTRAINT fk_matricula_aluno FOREIGN KEY (aluno_id) 
      REFERENCES aluno (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;