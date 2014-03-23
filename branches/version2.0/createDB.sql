SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `gallery` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `gallery` ;

-- -----------------------------------------------------
-- Table `gallery`.`CLASS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gallery`.`CLASS` (
  `CLASS_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` MEDIUMTEXT NULL,
  `PATH` MEDIUMTEXT NULL,
  `SUCCESS` TINYINT(1) NOT NULL,
  `QUALIFIED_NAME` MEDIUMTEXT NULL,
  PRIMARY KEY (`CLASS_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gallery`.`TEST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gallery`.`TEST` (
  `TEST_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` MEDIUMTEXT NULL,
  `PATH` MEDIUMTEXT NULL,
  `CLASS_ID` INT NOT NULL,
  `EXECUTION_DATE` DATE NULL,
  PRIMARY KEY (`TEST_ID`),
  INDEX `CLASSID_idx` (`CLASS_ID` ASC),
  CONSTRAINT `CLASSID`
    FOREIGN KEY (`CLASS_ID`)
    REFERENCES `gallery`.`CLASS` (`CLASS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gallery`.`EXECUTION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gallery`.`EXECUTION` (
  `EXECUTION_ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` MEDIUMTEXT NULL,
  `PATH` MEDIUMTEXT NULL,
  `EXECUTION_DATE` DATETIME NULL,
  `TEST_ID` INT NOT NULL,
  `FAILURE_REASON` MEDIUMTEXT NULL,
  PRIMARY KEY (`EXECUTION_ID`),
  INDEX `TESTID_idx` (`TEST_ID` ASC),
  CONSTRAINT `TESTID`
    FOREIGN KEY (`TEST_ID`)
    REFERENCES `gallery`.`TEST` (`TEST_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gallery`.`PROJECT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gallery`.`PROJECT` (
  `PORJECT_ID` INT NOT NULL AUTO_INCREMENT,
  `TEST_JAR` BLOB NULL,
  `DEPENDENCY_JAR` BLOB NULL,
  `JAR_NAME` VARCHAR(45) NOT NULL,
  `DESCRIPTION` MEDIUMTEXT NULL,
  `DATE_CREATION` DATETIME NULL,
  `PROJECT_NAME` VARCHAR(45) NULL,
  `DEPENDENCY_JAR_NAME` VARCHAR(45) NULL,
  `JAR_PATH` MEDIUMTEXT NULL,
  `DEPENDENCY_JAR_PATH` MEDIUMTEXT NULL,
  PRIMARY KEY (`PORJECT_ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
