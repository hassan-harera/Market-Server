SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP database market;
CREATE SCHEMA IF NOT EXISTS `market` DEFAULT CHARACTER SET utf8;
USE `market`;

CREATE TABLE IF NOT EXISTS `market`.`category`
(
    `category_name`       VARCHAR(50)  NOT NULL,
    `catergory_image_url` VARCHAR(500) NULL,
    PRIMARY KEY (`category_name`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`product`
(
    `product_id`    INT         NOT NULL,
    `name`          VARCHAR(80) NULL,
    `productcol`    VARCHAR(45) NULL,
    `caetgory_name` VARCHAR(50) NULL,
    `price`         DOUBLE      NULL,
    `amount`        DOUBLE      NULL,
    `unit`          VARCHAR(45) NULL,
    PRIMARY KEY (`product_id`),
    INDEX `product_category_idx` (`caetgory_name` ASC) VISIBLE,
    CONSTRAINT `product_category`
        FOREIGN KEY (`caetgory_name`)
            REFERENCES `market`.`category` (`category_name`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`user`
(
    `uid`          INT          NOT NULL,
    `phone_number` VARCHAR(45)  NULL,
    `anonymous`    TINYINT      NULL DEFAULT true,
    `lat`          LONGBLOB     NULL,
    `long`         LONGBLOB     NULL,
    `image_url`    VARCHAR(300) NULL,
    `first_name`   VARCHAR(45)  NULL,
    `last_name`    VARCHAR(45)  NULL,
    PRIMARY KEY (`uid`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`cart`
(
    `uid`        INT       NULL,
    `product_id` INT       NULL,
    `amount`     DOUBLE    NULL,
    `time`       TIMESTAMP NULL,
    INDEX `cart_product_idx` (`product_id` ASC) VISIBLE,
    INDEX `cart_user_idx` (`uid` ASC) VISIBLE,
    CONSTRAINT `cart_product`
        FOREIGN KEY (`product_id`)
            REFERENCES `market`.`product` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `cart_user`
        FOREIGN KEY (`uid`)
            REFERENCES `market`.`user` (`uid`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`wishlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`wishlist`
(
    `uid`        INT       NULL,
    `product_id` INT       NULL,
    `time`       TIMESTAMP NULL,
    INDEX `cart_product_idx` (`product_id` ASC) VISIBLE,
    INDEX `cart_user_idx` (`uid` ASC) VISIBLE,
    CONSTRAINT `wishlist_product`
        FOREIGN KEY (`product_id`)
            REFERENCES `market`.`product` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `wishlist_user`
        FOREIGN KEY (`uid`)
            REFERENCES `market`.`user` (`uid`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`offers_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`offers_group`
(
    `offers_group_id`   INT auto_increment,
    `offers_group_name` VARCHAR(60)  NULL,
    `imnage_url`        VARCHAR(300) NULL,
    PRIMARY KEY (`offers_group_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`offer`
(
    `offers_group_id` INT    NULL,
    `product_id`      INT    NULL,
    `new_price`       DOUBLE NULL,
    INDEX `offer_group_idx` (`offers_group_id` ASC) VISIBLE,
    INDEX `offer_product_idx` (`product_id` ASC) VISIBLE,
    CONSTRAINT `offer_group`
        FOREIGN KEY (`offers_group_id`)
            REFERENCES `market`.`offers_group` (`offers_group_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `offer_product`
        FOREIGN KEY (`product_id`)
            REFERENCES `market`.`product` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `market`.`product_images`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market`.`product_images`
(
    `product_id`        INT          NULL,
    `product_image_url` VARCHAR(300) NULL,
    INDEX `product_image_idx` (`product_id` ASC) VISIBLE,
    CONSTRAINT `product_image`
        FOREIGN KEY (`product_id`)
            REFERENCES `market`.`product` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
