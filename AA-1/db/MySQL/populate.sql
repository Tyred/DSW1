CREATE DATABASE AA1;
USE AA1;

CREATE TABLE usuario (id INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(128) NOT NULL, nome VARCHAR(256) NOT NULL, senha VARCHAR(128) NOT NULL);
CREATE TABLE profissional (id INT PRIMARY KEY AUTO_INCREMENT, id_usuario INT NOT NULL, cpf VARCHAR(11) NOT NULL, telefone VARCHAR(11) NOT NULL, sexo VARCHAR(12), data_nascimento DATE NOT NULL, FOREIGN KEY (id_usuario) REFERENCES usuario(id));
CREATE TABLE empresa (id INT PRIMARY KEY AUTO_INCREMENT, id_usuario INT NOT NULL, cnpj VARCHAR(14) NOT NULL, descricao VARCHAR(2048) NOT NULL, cidade VARCHAR(128) NOT NULL, FOREIGN KEY (id_usuario) REFERENCES usuario(id));
CREATE TABLE vaga (id INT PRIMARY KEY AUTO_INCREMENT, id_empresa INT NOT NULL, descricao VARCHAR(2048) NOT NULL, remuneracao DECIMAL(6,2) NOT NULL, data_limite DATE NOT NULL, FOREIGN KEY (id_empresa) REFERENCES empresa(id));
CREATE TABLE candidatura (id INT PRIMARY KEY AUTO_INCREMENT, id_profissional INT NOT NULL, id_vaga INT NOT NULL, curriculo VARCHAR(256) NOT NULL, status VARCHAR(64) NOT NULL, data_entrevista DATE, link_entrevista VARCHAR(256), FOREIGN KEY(id_profissional) REFERENCES profissional(id), FOREIGN KEY (id_vaga) REFERENCES vaga(id));

INSERT INTO usuario (email, nome, senha) VALUES ('admin@gmail.com', 'admin', 'admin');