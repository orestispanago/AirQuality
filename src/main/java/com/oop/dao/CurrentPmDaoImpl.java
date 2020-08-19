package com.oop.dao;

import com.oop.dtos.CurrentPmDTO;
import com.oop.models.Database;
import com.oop.services.CurrentPmServiceImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentPmDaoImpl implements ICurrentPmDao {

    private String query = "SELECT \n"
            + "    pm_measurements.timestamp,\n"
            + "    pm_measurements.pm1,\n"
            + "    pm_measurements.pm25,\n"
            + "    sensors_locations.lat,\n"
            + "    sensors_locations.lon,\n"
            + "    sensors_locations.id\n"
            + "FROM\n"
            + "    pm_measurements,\n"
            + "    (SELECT \n"
            + "        MAX(pm_measurements.id) maxId,\n"
            + "            pm_measurements.sensors_locations_id sensLocId\n"
            + "    FROM\n"
            + "        pm_measurements\n"
            + "    GROUP BY pm_measurements.sensors_locations_id) x,\n"
            + "    sensors_locations\n"
            + "WHERE\n"
            + "    pm_measurements.id = x.maxId\n"
            + "        AND sensors_locations.id = x.sensLocId;";
    public Database db = new Database();

    public List<CurrentPmDTO> getCurrentPmforAllSensors() {
        List<CurrentPmDTO> currentPms = new ArrayList();
        try {
            ResultSet rs = db.getResults(query);
            while (rs.next()) {
                CurrentPmDTO currentPm = new CurrentPmDTO();
                currentPm.setTimestamp(rs.getDate(1));
                currentPm.setPm1(rs.getLong(2));
                currentPm.setPm25(rs.getLong(3));
                currentPm.setLat(rs.getLong(4));
                currentPm.setLon(rs.getLong(5));
                currentPm.setSensorId(rs.getLong(6));
                currentPms.add(currentPm);
                System.out.println(currentPm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurrentPmServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentPms;
    }

}
