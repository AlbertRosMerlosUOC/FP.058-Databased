-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `online_store` ;

-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_store` DEFAULT CHARACTER SET utf8mb4 ;
-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `online_store` ;

-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_store` DEFAULT CHARACTER SET utf8mb4 ;

USE `online_store` ;

-- -----------------------------------------------------
-- Table `online_store`.`Articulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `online_store`.`Articulo` ;

CREATE TABLE IF NOT EXISTS `online_store`.`Articulo` (
  `codigo` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `precio_venta` DECIMAL(10,2) NULL DEFAULT NULL,
  `gastos_envio` DECIMAL(5,2) NULL DEFAULT NULL,
  `tiempo_preparacion` INT NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `online_store`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `online_store`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `online_store`.`Cliente` (
  `email` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `domicilio` VARCHAR(125) NULL DEFAULT NULL,
  `tipo_cliente` ENUM('ClienteStandard','ClientePremium'),
  PRIMARY KEY (`email`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `online_store`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `online_store`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `online_store`.`Pedido` (
  `num_pedido` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(100) NOT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `local_date_time` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`num_pedido`),
  UNIQUE INDEX `id_pedido_UNIQUE` (`num_pedido` ASC) VISIBLE,
  INDEX `email` (`email` ASC) VISIBLE,
  INDEX `codigo` (`codigo` ASC) VISIBLE,
  CONSTRAINT `codigo`
    FOREIGN KEY (`codigo`)
    REFERENCES `online_store`.`Articulo` (`codigo`),
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `online_store`.`Cliente` (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;



