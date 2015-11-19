-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 19/11/2015 às 05:26
-- Versão do servidor: 10.0.17-MariaDB
-- Versão do PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bibliotecadb`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Aluno`
--

CREATE TABLE `Aluno` (
  `idAluno` int(11) NOT NULL,
  `matriculaAluno` int(11) DEFAULT NULL,
  `nomeAluno` varchar(45) DEFAULT NULL,
  `nCPF` varchar(45) DEFAULT NULL,
  `Telefone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `Aluno`
--

INSERT INTO `Aluno` (`idAluno`, `matriculaAluno`, `nomeAluno`, `nCPF`, `Telefone`) VALUES
(6, 140500008, 'Thiago Oliveira', '123.456.789-10', '33-1234-5678'),
(7, 140500004, 'Marlon Santos', '1112.1314.1516-17', '(33)-3511-2222'),
(8, 140500043, 'Lázaro Dutra', '143.414.568-26', '33-3333-4444'),
(9, 123, 'JUCA', '999.999.999-99', '12-4444-5555');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Itens`
--

CREATE TABLE `Itens` (
  `id_Itens` int(11) NOT NULL,
  `id_Livro` int(11) DEFAULT NULL,
  `id_reserva` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `Itens`
--

INSERT INTO `Itens` (`id_Itens`, `id_Livro`, `id_reserva`) VALUES
(1, 2, 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Livro`
--

CREATE TABLE `Livro` (
  `idLivro` int(11) NOT NULL,
  `nomeLivro` varchar(45) DEFAULT NULL,
  `nomeAutor` varchar(45) DEFAULT NULL,
  `qtdeLivro` int(11) DEFAULT NULL,
  `disponivel` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `Livro`
--

INSERT INTO `Livro` (`idLivro`, `nomeLivro`, `nomeAutor`, `qtdeLivro`, `disponivel`) VALUES
(1, 'Introdução e boas praticas em UX Design', 'Fabricio Teixeira', 11, 1),
(2, 'Google Android', 'João Bosco Monteiro ', 3, 1),
(3, 'A Guerra dos Tronos - Livro Um', 'George R.R. Martin', 5, 1),
(4, 'A Guerra dos Tronos - Livro Dois', 'George R.R. Martin', 4, 1),
(5, 'A Guerra dos Tronos - Livro Três', 'George R.R. Martin', 7, 1),
(6, 'A Guerra dos Tronos - Livro Quatro', 'George R.R. Martin', 8, 1),
(7, 'A Guerra dos Tronos - Livro Cinco', 'George R.R. Martin', 3, 1),
(8, 'Os Senhores dos Dinossauros', 'Victor Milan', 12, 1),
(9, 'Java SE 8 Programer 1', 'Guilherme Silveira - Mário Amaral ', 10, 1),
(10, 'A Cabana', 'William P. Young', 5, 1),
(11, 'O Facinante Império de Steve Jobs ', 'Michael Moritz', 4, 1),
(12, 'O Guia do Mochileiro das Galáxias - 1', 'Douglas Adams', 20, 1),
(13, 'O Restaurante bo Fim do Universo - 2', 'Douglas Adams', 6, 1),
(14, 'A vida, o universo e tudo mais - 3', 'Douglas Adams', 3, 1),
(15, 'Até mais, e obrigado pelos peixes! - 4', 'Douglas Adams', 11, 1),
(16, 'Praticamente Inofensiva - 5', 'Douglas Adams', 5, 1),
(17, 'Star Wars - Herdeiro do Império', 'Timothy Zahn', 8, 1),
(18, 'De Gênio e Louco todo mundo tem um pouco', 'Augusto Cury', 3, 1),
(19, 'O Vendedor de Sonhos - O Chamado', 'Augusto Cury', 3, 1),
(20, 'O Semeador de Ideias ', 'Augusto Cury', 10, 1),
(21, 'Harry Potter e a Pedra Filosofal', 'J. K. Rowling', 7, 1),
(22, 'Swift - Programe para IPhone e IPad', 'Guilherme Silveira e Joviane Jardim', 11, 1),
(23, 'Nostradamus e o Inquietante Futuro', 'Ettore Cheynet', 3, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Reserva`
--

CREATE TABLE `Reserva` (
  `idReserva` int(11) NOT NULL,
  `idAluno` int(11) DEFAULT NULL,
  `dataRetirada` date DEFAULT NULL,
  `dataEntrega` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `Reserva`
--

INSERT INTO `Reserva` (`idReserva`, `idAluno`, `dataRetirada`, `dataEntrega`) VALUES
(3, 7, '2015-11-16', '2015-11-17'),
(4, 6, '2015-11-17', '2015-11-24');

-- --------------------------------------------------------

--
-- Estrutura stand-in para view `reservas`
--
CREATE TABLE `reservas` (
`Item` int(11)
,`Reserva` int(11)
,`Aluno` varchar(45)
,`Livro` int(11)
,`NomeLivro` varchar(45)
,`DataSaida` date
,`DataEntrega` date
);

-- --------------------------------------------------------

--
-- Estrutura para view `reservas`
--
DROP TABLE IF EXISTS `reservas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservas`  AS  select `itens`.`id_Itens` AS `Item`,`itens`.`id_reserva` AS `Reserva`,`aluno`.`nomeAluno` AS `Aluno`,`itens`.`id_Livro` AS `Livro`,`livro`.`nomeLivro` AS `NomeLivro`,`reserva`.`dataRetirada` AS `DataSaida`,`reserva`.`dataEntrega` AS `DataEntrega` from (((`itens` join `reserva` on((`itens`.`id_reserva` = `reserva`.`idReserva`))) join `aluno` on((`reserva`.`idAluno` = `aluno`.`idAluno`))) join `livro` on((`livro`.`idLivro` = `itens`.`id_Livro`))) ;

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Aluno`
--
ALTER TABLE `Aluno`
  ADD PRIMARY KEY (`idAluno`);

--
-- Índices de tabela `Itens`
--
ALTER TABLE `Itens`
  ADD PRIMARY KEY (`id_Itens`),
  ADD KEY `FKreserva_idx` (`id_reserva`),
  ADD KEY `FKLivro_idx` (`id_Livro`);

--
-- Índices de tabela `Livro`
--
ALTER TABLE `Livro`
  ADD PRIMARY KEY (`idLivro`);

--
-- Índices de tabela `Reserva`
--
ALTER TABLE `Reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `AlunoReserva_idx` (`idAluno`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `Aluno`
--
ALTER TABLE `Aluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de tabela `Itens`
--
ALTER TABLE `Itens`
  MODIFY `id_Itens` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `Livro`
--
ALTER TABLE `Livro`
  MODIFY `idLivro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT de tabela `Reserva`
--
ALTER TABLE `Reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Itens`
--
ALTER TABLE `Itens`
  ADD CONSTRAINT `FKLivro` FOREIGN KEY (`id_Livro`) REFERENCES `Livro` (`idLivro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FKreserva` FOREIGN KEY (`id_reserva`) REFERENCES `Reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `Reserva`
--
ALTER TABLE `Reserva`
  ADD CONSTRAINT `FKAluno` FOREIGN KEY (`idAluno`) REFERENCES `Aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
