# -- Создание таблицы brands
# CREATE TABLE IF NOT EXISTS brands
# (
#     id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     name             VARCHAR(100),
#     type             VARCHAR(50),
#     safety_rating    VARCHAR(50),
#     seating_capacity INT,
#     fuel_capacity    INT,
#     average_lkm      DECIMAL(10, 2)
# );
#
# -- Создание таблицы enterprises
# CREATE TABLE IF NOT EXISTS enterprises
# (
#     id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     name VARCHAR(50) NOT NULL,
#     city VARCHAR(50) NOT NULL
# );
#
# -- Создание таблицы vehicles
# CREATE TABLE IF NOT EXISTS vehicles
# (
#     id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     brand_id         INT,
#     color            VARCHAR(50),
#     year             INT,
#     odometer         INT,
#     price            DECIMAL,
#     enterprise_id    INT,
#     active_driver_id INT
# );
#
# -- Создание таблицы drivers
# CREATE TABLE IF NOT EXISTS drivers
# (
#     id                INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     name              VARCHAR(50),
#     age               INT,
#     salary            INT,
#     enterprise_id     INT,
#     active_vehicle_id INT
# );
#
# -- Добавление внешних ключей в таблицу vehicles
# ALTER TABLE vehicles
# ADD FOREIGN KEY (brand_id) REFERENCES brands (id),
# ADD FOREIGN KEY (enterprise_id) REFERENCES enterprises (id),
# ADD FOREIGN KEY (active_driver_id) REFERENCES drivers (id);
#
# -- Добавление внешних ключей в таблицу drivers
# ALTER TABLE drivers
# ADD FOREIGN KEY (enterprise_id) REFERENCES enterprises (id),
# ADD FOREIGN KEY (active_vehicle_id) REFERENCES vehicles (id);