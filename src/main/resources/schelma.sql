CREATE TABLE `db_enfermeiro`.`tb_enfermeiro` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `nome` VARCHAR(255) NOT NULL ,
    `coren` VARCHAR(255) NOT NULL ,
    `email` VARCHAR(255) NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `db_enfermeiro`.`tb_ala` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `nome` VARCHAR (255) NOT NULL ,
    `andar` VARCHAR (255) NOT NULL ,
    PRIMARY KEY (`id_ala`)
) ENGINE = InnoDB;

CREATE TABLE `db_enfermeiro`.`tb_escala` (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `id_ala` INT NOT NULL ,
    `id_enfermeiro` INT NOT NULL ,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

ALTER TABLE `tb_escala` ADD FOREIGN KEY (`id_ala`) REFERENCES `tb_ala`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `tb_escala` ADD FOREIGN KEY (`id_enfermeiro`) REFERENCES `tb_enfermeiro`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;