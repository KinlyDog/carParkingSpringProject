package com.kinlydog.carparking.repositoryes;

import com.kinlydog.carparking.models.Vehicle;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    // Maybe not working
    @Modifying
    @Query("INSERT INTO vehicle VALUES (NULL, :year, :odometer, :color, :price)")
    void addVenicle(int year, int odometer, String color, BigDecimal price);

    @Modifying
    @Query("DELETE FROM vehicle WHERE id = :id")
    void deleteVehicleById(int id);


//    private final JdbcTemplate jdbc;
//
//    public VehicleRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public List<Vehicle> findAllVehicle() {
//        String sql = "SELECT * FROM vehicle";
//
//        RowMapper<Vehicle> vehicleRowMapper = (r, i) -> {
//            Vehicle rowObject = new Vehicle();
//            rowObject.setId(r.getInt("id"));
//            rowObject.setOdometer(r.getInt("odometer"));
//            rowObject.setColor(r.getString("color"));
//            rowObject.setYearOfManufacture(r.getInt("yearOfManufacture"));
//            rowObject.setPrice(r.getBigDecimal("price"));
//
//            return rowObject;
//        };
//
//        return jdbc.query(sql, vehicleRowMapper);

}
