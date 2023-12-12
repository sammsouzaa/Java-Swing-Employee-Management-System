CREATE DATABASE lojaIFPR;

use lojaIFPR;

-- ---------------------------------------
-- TABELAS RELACIONADAS AO FUNCIONARIO; --
-- ---------------------------------------

-- Primeiro a tabela Funcionario com as informações basicas do funcionario;

CREATE TABLE Funcionario (
    codFuncionario int auto_increment primary key,
    nome VARCHAR(50) not null,
    email VARCHAR(50) not null,
    endereco VARCHAR(50) not null,
    fone VARCHAR(50) not null,
    cargo VARCHAR(50) not null,
    salario DOUBLE not null,
    usuario VARCHAR(50) not null,
    senha VARCHAR(50) not null
);

-- Aqui temos a tabela treinamentos, que tem um titulo e uma descrição de treinamentos que o funcionario tem;

CREATE TABLE Treinamentos (
    ID int auto_increment primary key,
    treinamento VARCHAR(50),
    codFuncionario INT,
    FOREIGN KEY (codFuncionario) REFERENCES Funcionario(codFuncionario)
);

-- Aqui um breve Titulo para nomear os Empregos que o Funcionario ja teve antes da empresa atual;

CREATE TABLE Empregos (
    ID int auto_increment primary key,
    emprego VARCHAR(50),
    codFuncionario INT,
    FOREIGN KEY (codFuncionario) REFERENCES Funcionario(codFuncionario)
);

-- Aqui temos uma tabela Feedbacks, que armazenará varias considerações do gerente ao funcionario ao decorrer de seu trabalho;

CREATE TABLE Feedbacks (
    ID int auto_increment primary key,
    feedback VARCHAR(100),
    codFuncionario INT,
    FOREIGN KEY (codFuncionario) REFERENCES Funcionario(codFuncionario)
);

-- -------------------------------------
-- TABELAS RELACIONADAS AO ASSOCIADO; --
-- -------------------------------------

-- Primeiramente temos os dados de paramento do Associado;

CREATE TABLE DadosPagamento (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    metodoPagamento VARCHAR(255) NOT NULL,
    numeroCartao VARCHAR(255) NOT NULL,
    validadeCartao VARCHAR(255) NOT NULL
);

-- Aqui encontramos as informações basicas do Associado;

CREATE TABLE Associado (
    codAssociado int auto_increment primary key,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    endereco VARCHAR(80) NOT NULL,
    fone VARCHAR(10) NOT NULL,
    dadosPagamentoID INT,
    FOREIGN KEY (dadosPagamentoID) REFERENCES DadosPagamento(ID)
);

-- Tabela com informações basicas pessoais dos dependentes do Associado;

CREATE TABLE Dependentes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    codAssociado INT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    fone VARCHAR(255) NOT NULL,
    FOREIGN KEY (codAssociado) REFERENCES Associado(codAssociado)
);

-- Aqui temos o nome de lanches que adicionaremos ao usuario todos os lanches que ele pegar ao longo  do tempo;

CREATE TABLE Lanches (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    codAssociado INT,
    lanche VARCHAR(255) NOT NULL,
    FOREIGN KEY (codAssociado) REFERENCES Associado(codAssociado)
);

SELECT * FROM Funcionario;