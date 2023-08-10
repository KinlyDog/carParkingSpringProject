# INSERT INTO brands (name, safety_rating, seating_capacity, fuel_capacity, average_lkm, type)
# VALUES
#     ('Brand A', 'High', 5, 60, 8.5, 'Sedan'),
#     ('Brand B', 'Medium', 7, 70, 9.8, 'SUV');
#
# -- Идентификаторы брендов соответствуют добавленным выше записям в таблице brands
# INSERT INTO vehicles (year, odometer, color, price, brand_id)
# VALUES
#     (2023, 15000, 'Blue', 25000.00, 1),  -- Машина принадлежит бренду Brand A
#     (2022, 20000, 'Red', 22000.00, 2);   -- Машина принадлежит бренду Brand B
