-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pikdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS pikdb ;

-- -----------------------------------------------------
-- Schema pikdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS pikdb DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `pikdb` ;

-- -----------------------------------------------------
-- Table `pikdb`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`categories` (
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2048) NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pikdb`.`games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`games` (
  `idgames` INT NOT NULL AUTO_INCREMENT,
  `short_description` VARCHAR(255) NOT NULL,
  `long_description` VARCHAR(2048) NULL,
  `price` DECIMAL(2) NOT NULL,
  `promotion_price` DECIMAL(2) NULL,
  `promotion_deadline` DATETIME NULL,
  `name` VARCHAR(45) NOT NULL,
  `categories_name` VARCHAR(45) NOT NULL,
  `snippet` VARCHAR(45) NULL,
  `designer` VARCHAR(45) NULL,
  `number_of_players` VARCHAR(45) NULL,
  `playing_time` VARCHAR(45) NULL,
  `subdomain` VARCHAR(45) NULL,
  `suggested_age` VARCHAR(45) NULL,
  `year_published` DATETIME NULL,
  PRIMARY KEY (`idgames`),
  CONSTRAINT `fk_games_categories1`
  FOREIGN KEY (`categories_name`)
  REFERENCES `pikdb`.`categories` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `fk_games_categories1_idx` ON `pikdb`.`games` (`categories_name` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`users` (
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pikdb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`orders` (
  `idorders` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `price` DECIMAL(2) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `users_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idorders`),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_email`)
    REFERENCES `pikdb`.`users` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_orders_users1_idx` ON `pikdb`.`orders` (`users_email` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`carts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`carts` (
  `users_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`users_email`),
  CONSTRAINT `fk_carts_users`
    FOREIGN KEY (`users_email`)
    REFERENCES `pikdb`.`users` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_carts_users_idx` ON `pikdb`.`carts` (`users_email` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`transactions` (
  `idtransactions` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `price` DECIMAL(2) NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`idtransactions`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pikdb`.`reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`reviews` (
  `idreviews` INT NOT NULL,
  `contents` VARCHAR(2048) NULL,
  `mark` INT NOT NULL,
  `users_email` VARCHAR(45) NOT NULL,
  `games_idgames` INT NOT NULL,
  PRIMARY KEY (`idreviews`),
  CONSTRAINT `fk_reviews_users1`
    FOREIGN KEY (`users_email`)
    REFERENCES `pikdb`.`users` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviews_games1`
    FOREIGN KEY (`games_idgames`)
    REFERENCES `pikdb`.`games` (`idgames`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_reviews_users1_idx` ON `pikdb`.`reviews` (`users_email` ASC);

CREATE INDEX `fk_reviews_games1_idx` ON `pikdb`.`reviews` (`games_idgames` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`carts_has_games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`carts_has_games` (
  `games_idgames` INT NOT NULL,
  `carts_users_email` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`games_idgames`, `carts_users_email`),
  CONSTRAINT `fk_games_has_carts_games1`
    FOREIGN KEY (`games_idgames`)
    REFERENCES `pikdb`.`games` (`idgames`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_games_has_carts_carts1`
    FOREIGN KEY (`carts_users_email`)
    REFERENCES `pikdb`.`carts` (`users_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_games_has_carts_carts1_idx` ON `pikdb`.`carts_has_games` (`carts_users_email` ASC);

CREATE INDEX `fk_games_has_carts_games1_idx` ON `pikdb`.`carts_has_games` (`games_idgames` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`orders_has_games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`orders_has_games` (
  `orders_idorders` INT NOT NULL,
  `games_idgames` INT NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`orders_idorders`, `games_idgames`),
  CONSTRAINT `fk_orders_has_games_orders1`
    FOREIGN KEY (`orders_idorders`)
    REFERENCES `pikdb`.`orders` (`idorders`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_games_games1`
    FOREIGN KEY (`games_idgames`)
    REFERENCES `pikdb`.`games` (`idgames`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_orders_has_games_games1_idx` ON `pikdb`.`orders_has_games` (`games_idgames` ASC);

CREATE INDEX `fk_orders_has_games_orders1_idx` ON `pikdb`.`orders_has_games` (`orders_idorders` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`users_has_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`users_has_transactions` (
  `users_email` VARCHAR(45) NOT NULL,
  `transactions_idtransactions` INT NOT NULL,
  PRIMARY KEY (`users_email`, `transactions_idtransactions`),
  CONSTRAINT `fk_users_has_transactions_users1`
    FOREIGN KEY (`users_email`)
    REFERENCES `pikdb`.`users` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_transactions_transactions1`
    FOREIGN KEY (`transactions_idtransactions`)
    REFERENCES `pikdb`.`transactions` (`idtransactions`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_users_has_transactions_transactions1_idx` ON `pikdb`.`users_has_transactions` (`transactions_idtransactions` ASC);

CREATE INDEX `fk_users_has_transactions_users1_idx` ON `pikdb`.`users_has_transactions` (`users_email` ASC);


-- -----------------------------------------------------
-- Table `pikdb`.`transactions_has_games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pikdb`.`transactions_has_games` (
  `transactions_idtransactions` INT NOT NULL,
  `games_idgames` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`transactions_idtransactions`, `games_idgames`),
  CONSTRAINT `fk_transactions_has_games_transactions1`
    FOREIGN KEY (`transactions_idtransactions`)
    REFERENCES `pikdb`.`transactions` (`idtransactions`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transactions_has_games_games1`
    FOREIGN KEY (`games_idgames`)
    REFERENCES `pikdb`.`games` (`idgames`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_transactions_has_games_games1_idx` ON `pikdb`.`transactions_has_games` (`games_idgames` ASC);

CREATE INDEX `fk_transactions_has_games_transactions1_idx` ON `pikdb`.`transactions_has_games` (`transactions_idtransactions` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Insert User example:
insert into users VALUES ('Olek', '3fb14d016ebe86');
insert into users VALUES ('admin', 'admin');
insert into users VALUES ('ccc', 'bbb');

-- categories
insert into categories VALUE  ('RPG', 'Bardzo krotki opis');
insert into categories VALUE  ('ekonomiczne', 'gra w ktorej liczy sie pieniadze');