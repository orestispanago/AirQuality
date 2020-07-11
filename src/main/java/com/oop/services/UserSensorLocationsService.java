package com.oop.services;

import com.oop.models.CurrentPm;
import com.oop.models.Database;
import com.oop.models.UserSensorLocation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orestis
 */
public class UserSensorLocationsService {

    private static String query = "SELECT \n"
            + "    registered, users_id,label, lat, lon\n"
            + "FROM\n"
            + "    sold_sensors_users,\n"
            + "    sensors_locations\n"
            + "WHERE\n"
            + "    sensors_locations.sold_sensors_id = sold_sensors_users.id\n"
            + "        AND sold_sensors_users.users_id = 1;";
    public static Database db = new Database();

    public static List<UserSensorLocation> getUserSensorLocations() {
        List<UserSensorLocation> userSensorLocations = new ArrayList();
        try {
            ResultSet rs = db.getResults(query);
            while (rs.next()) {
                UserSensorLocation userSensorLocation = new UserSensorLocation();
                userSensorLocation.setRegistered(rs.getString(1));
                userSensorLocation.setUserId(rs.getString(2));
                userSensorLocation.setLabel(rs.getString(3));
                userSensorLocation.setLat(rs.getString(4));
                userSensorLocation.setLon(rs.getString(5));
                userSensorLocations.add(userSensorLocation);
                System.out.println(userSensorLocation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSensorLocationsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userSensorLocations;
    }

}
