-- Создание таблицы brands
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

-- Создание таблицы enterprises
CREATE TABLE IF NOT EXISTS enterprises
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL
);

-- Создание таблицы vehicles
CREATE TABLE IF NOT EXISTS vehicles
(
    id               INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    year             INT         NOT NULL,
    odometer         INT         NOT NULL,
    color            VARCHAR(50) NOT NULL,
    price            DECIMAL     NOT NULL,
    brand_id         INT         NOT NULL,
    enterprise_id    INT         NOT NULL,
    active_driver_id INT,
    FOREIGN KEY (brand_id) REFERENCES brands (id),
    FOREIGN KEY (enterprise_id) REFERENCES enterprises (id),
    FOREIGN KEY (active_driver_id) REFERENCES drivers (id)
);

-- Создание таблицы drivers
CREATE TABLE IF NOT EXISTS drivers
(
    id                INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(50) NOT NULL,
    age               INT         NOT NULL,
    salary            INT         NOT NULL,
    enterprise_id     INT         NOT NULL,
    active_vehicle_id INT,
    FOREIGN KEY (enterprise_id) REFERENCES enterprises (id),
    FOREIGN KEY (active_vehicle_id) REFERENCES vehicles (id)
);

-- Создание таблицы driver_vehicle
CREATE TABLE IF NOT EXISTS driver_vehicle
(
    id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    driver_id  INT NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (driver_id) REFERENCES drivers (id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles (id)
);