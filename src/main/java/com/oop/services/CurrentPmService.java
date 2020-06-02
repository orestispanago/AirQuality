package com.oop.services;

import com.oop.models.CurrentPm;
import com.oop.models.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orestis
 */
public class CurrentPmService {

    private static String query = "SELECT "
            + "pm_measurements.timestamp, "
            + "pm_measurements.pm1, "
            + "pm_measurements.pm25, "
            + "sensors_locations.lat, "
            + "sensors_locations.lon, "
            + "sensors_locations.id "
            + "FROM "
            + "sensors_locations, "
            + "pm_measurements "
            + "WHERE "
            + "sensors_locations.id= pm_measurements.sensors_locations_id "
            + "AND "
            + "sensors_locations.id=1 "
            + "ORDER BY "
            + "pm_measurements.timestamp "
            + "DESC "
            + "LIMIT 1";
    public static Database db = new Database();

    public static CurrentPm getCurrent1() {
        CurrentPm currentPm = new CurrentPm();
        try {
            ResultSet rs = db.getResults(query);
            while (rs.next()) {
                currentPm.setTimestamp(rs.getString(1));
                currentPm.setPm1(rs.getString(2));
                currentPm.setPm25(rs.getString(3));
                currentPm.setLat(rs.getString(4));
                currentPm.setLon(rs.getString(5));
                currentPm.setSensorId(rs.getString(6));
                System.out.println(currentPm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurrentPmService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentPm;
    }

}
