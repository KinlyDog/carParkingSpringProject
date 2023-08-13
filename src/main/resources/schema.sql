CREATE TABLE IF NOT EXISTS brands
(
    id               INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100)   NOT NULL,
    safety_rating    VARCHAR(50)    NOT NULL,
    seating_capacity INT            NOT NULL,
    fuel_capacity    INT            NOT NULL,
    average_lkm      DECIMAL(10, 2) NOT NULL,
    type             VARCHAR(50)    NOT NULL
);

CREATE TABLE IF NOT EXISTS vehicles
(
    id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    year     INT         NOT NULL,
    odometer INT         NOT NULL,
    color    VARCHAR(50) NOT NULL,
    price    DECIMAL     NOT NULL,
    brand_id INT         NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brands (id)
);

CREATE TABLE IF NOT EXISTS all_brands
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
--
-- CREATE TABLE IF NOT EXISTS enterprise
-- (
--     id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(50) NOT NULL
-- );
--
-- CREATE TABLE IF NOT EXISTS driver
-- (
--     id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(50) NOT NULL
-- );
