-- INSERT INTO brands (name, type, safety_rating, seating_capacity, fuel_capacity, average_lkm)
-- VALUES
--     ('Toyota', 'Sedan', '5 Stars', 5, 60, 8.5),
--     ('Ford', 'SUV', '4 Stars', 7, 70, 10.2),
--     ('Honda', 'Hatchback', '4 Stars', 5, 55, 7.8),
--     ('Chevrolet', 'Truck', '3 Stars', 3, 80, 12.5);
--
-- INSERT INTO enterprises (name, city)
-- VALUES
--     ('CarCo', 'New York'),
--     ('AutoGroup', 'Los Angeles'),
--     ('DriveTech', 'Chicago'),
--     ('MotoMasters', 'Houston');
--
-- INSERT INTO vehicles (brand_id, color, year, odometer, price, enterprise_id, active_driver_id)
-- VALUES
--     (1, 'Blue', 2022, 15000, 25000.00, 1, NULL),
--     (2, 'Red', 2021, 20000, 32000.00, 2, NULL),
--     (3, 'Silver', 2023, 10000, 18000.00, 3, NULL),
--     (4, 'Black', 2020, 30000, 28000.00, 4, NULL);
--
-- INSERT INTO drivers (name, age, salary, enterprise_id, active_vehicle_id)
-- VALUES
--     ('John Doe', 30, 50000, 1, NULL),
--     ('Jane Smith', 28, 48000, 2, NULL),
--     ('Michael Johnson', 35, 55000, 3, NULL),
--     ('Emily Davis', 29, 52000, 4, NULL);
