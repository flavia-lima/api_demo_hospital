-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27-Maio-2021 às 14:29
-- Versão do servidor: 10.4.16-MariaDB
-- versão do PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_enfermeiro`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_ala`
--

CREATE TABLE `tb_ala` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `andar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_ala`
--

INSERT INTO `tb_ala` (`id`, `nome`, `andar`) VALUES
(2, 'Pediatria', '4');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_enfermeiro`
--

CREATE TABLE `tb_enfermeiro` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `coren` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_enfermeiro`
--

INSERT INTO `tb_enfermeiro` (`id`, `nome`, `email`, `coren`) VALUES
(8, 'Mulan', 'mulan@email.com', '52536'),
(13, 'Chang', 'chang@email.com', '53614');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_escala`
--

CREATE TABLE `tb_escala` (
  `id` int(11) NOT NULL,
  `id_ala` int(11) NOT NULL,
  `id_enfermeiro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_escala`
--

INSERT INTO `tb_escala` (`id`, `id_ala`, `id_enfermeiro`) VALUES
(2, 2, 8);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_ala`
--
ALTER TABLE `tb_ala`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_enfermeiro`
--
ALTER TABLE `tb_enfermeiro`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tb_escala`
--
ALTER TABLE `tb_escala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ala` (`id_ala`),
  ADD KEY `id_enfermeiro` (`id_enfermeiro`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_ala`
--
ALTER TABLE `tb_ala`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tb_enfermeiro`
--
ALTER TABLE `tb_enfermeiro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `tb_escala`
--
ALTER TABLE `tb_escala`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_escala`
--
ALTER TABLE `tb_escala`
  ADD CONSTRAINT `tb_escala_ibfk_1` FOREIGN KEY (`id_ala`) REFERENCES `tb_ala` (`id`),
  ADD CONSTRAINT `tb_escala_ibfk_2` FOREIGN KEY (`id_enfermeiro`) REFERENCES `tb_enfermeiro` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
