--
-- Banco de dados: `db_hospital`
--
CREATE DATA BASE `db_hospital`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_ala`
--

CREATE TABLE `tb_ala` (
  `id` bigint(20) NOT NULL,
  `andar` varchar(10) NOT NULL,
  `nome` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_ala`
--

INSERT INTO `tb_ala` (`id`, `andar`, `nome`) VALUES
(1, '4', 'Pediatria');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_enfermeiro`
--

CREATE TABLE `tb_enfermeiro` (
  `id` bigint(20) NOT NULL,
  `coren` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `nome` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_enfermeiro`
--

INSERT INTO `tb_enfermeiro` (`id`, `coren`, `email`, `nome`) VALUES
(1, '123456', 'mulan@email.com', 'Mulan');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_escala`
--

CREATE TABLE `tb_escala` (
  `id` bigint(20) NOT NULL,
  `id_ala` bigint(20) DEFAULT NULL,
  `id_enfermeiro` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_escala`
--

INSERT INTO `tb_escala` (`id`, `id_ala`, `id_enfermeiro`) VALUES
(1, 1, 1);

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
  ADD KEY `FKs020gbxsqd4kkqvyw8e114ht4` (`id_ala`),
  ADD KEY `FKthx95rke04k01ci69pg66t3v5` (`id_enfermeiro`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_ala`
--
ALTER TABLE `tb_ala`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_enfermeiro`
--
ALTER TABLE `tb_enfermeiro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_escala`
--
ALTER TABLE `tb_escala`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_escala`
--
ALTER TABLE `tb_escala`
  ADD CONSTRAINT `FKs020gbxsqd4kkqvyw8e114ht4` FOREIGN KEY (`id_ala`) REFERENCES `tb_ala` (`id`),
  ADD CONSTRAINT `FKthx95rke04k01ci69pg66t3v5` FOREIGN KEY (`id_enfermeiro`) REFERENCES `tb_enfermeiro` (`id`);
COMMIT;
