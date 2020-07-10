//package com.oop.dao;
//
//import com.oop.models.CurrentPm;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;


//public interface ICurrentPmDao{
////    @Query("from Auction a join a.category c where c.name=:categoryName")
//    @Query("SELECT "
//            + "`pm_measurements.timestamp time`, "
//            + "`pm_measurements.pm1`, "
//            + "`pm_measurements.pm25`, "
//            + "`sensors_locations.lat`, "
//            + "`sensors_locations.lon`, "
//            + "`sensors_locations.id`, "
//            + "`sensorLocationId` "
//            + "FROM "
//            + "`sensors_locations`, "
//            + "`pm_measurements` "
//            + "WHERE "
//            + "`sensors_locations.id`= `pm_measurements.sensors_locations_id` "
//            + "AND "
//            + "`sensors_locations.id`=1 "
//            + "ORDER BY "
//            + "`pm_measurements.timestamp` "
//            + "DESC "
//            + "LIMIT 1")
//CurrentPm findCurrentPmBySensorLocationId(long sensorLocationId);
//}
