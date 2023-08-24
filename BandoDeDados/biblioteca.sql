-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 24-Ago-2023 às 22:47
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros`
--

DROP TABLE IF EXISTS `livros`;
CREATE TABLE IF NOT EXISTS `livros` (
  `id` varchar(255) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `livros`
--

INSERT INTO `livros` (`id`, `titulo`, `autor`, `quantidade`) VALUES
('0aeb27fd-8417-4501-b8ab-8e51aabe2b22', 'Dom Casmurro', 'Machado de Assis', 10),
('1', 'Harry Potter', 'J. K. Rowling', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livrosemprestimo`
--

DROP TABLE IF EXISTS `livrosemprestimo`;
CREATE TABLE IF NOT EXISTS `livrosemprestimo` (
  `id` varchar(255) NOT NULL,
  `livro` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`livro`,`usuario`),
  KEY `livro` (`livro`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `livrosemprestimo`
--

INSERT INTO `livrosemprestimo` (`id`, `livro`, `usuario`) VALUES
('0907f40f-15c8-42d7-8f2e-74088cc23b43', '0aeb27fd-8417-4501-b8ab-8e51aabe2b22', 'a1bc1c0c-f095-4806-b6c9-24bd21ed8480'),
('9b9750d1-1bdc-42bf-99c0-3724ec098cb6', '1', 'a1bc1c0c-f095-4806-b6c9-24bd21ed8480');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` varchar(255) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`) VALUES
('515524a1-113c-4dc5-8be3-34ed9b53848f', 'Célia'),
('a1bc1c0c-f095-4806-b6c9-24bd21ed8480', 'Célys');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `livrosemprestimo`
--
ALTER TABLE `livrosemprestimo`
  ADD CONSTRAINT `livrosemprestimo_ibfk_1` FOREIGN KEY (`livro`) REFERENCES `livros` (`id`),
  ADD CONSTRAINT `livrosemprestimo_ibfk_2` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
