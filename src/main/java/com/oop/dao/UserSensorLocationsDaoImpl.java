package com.oop.dao;

import com.oop.models.Database;
import com.oop.dtos.UserSensorLocationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserSensorLocationsDaoImpl implements IUserSensorLocationDao{

    public Database db = new Database();

    public List<UserSensorLocationDTO> getUserSensorLocations(long userId) {
        String query = String.format("SELECT \n"
                + "    registered, users_id,label, lat, lon, sensors_locations.id\n"
                + "FROM\n"
                + "    sold_sensors_users,\n"
                + "    sensors_locations\n"
                + "WHERE\n"
                + "    sensors_locations.sold_sensors_id = sold_sensors_users.id\n"
                + "        AND sold_sensors_users.users_id = %d;", userId);
        List<UserSensorLocationDTO> userSensorLocations = new ArrayList();
        try {
            ResultSet rs = Database.getResults(query);
            while (rs.next()) {
                UserSensorLocationDTO userSensorLocation = new UserSensorLocationDTO();
                userSensorLocation.setRegistered(rs.getBoolean(1));
                userSensorLocation.setUserId(rs.getLong(2));
                userSensorLocation.setLabel(rs.getString(3));
                userSensorLocation.setLat(rs.getFloat(4));
                userSensorLocation.setLon(rs.getFloat(5));
                userSensorLocation.setSensorLocationId(rs.getLong(6));
                userSensorLocations.add(userSensorLocation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSensorLocationsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userSensorLocations;
    }

}
