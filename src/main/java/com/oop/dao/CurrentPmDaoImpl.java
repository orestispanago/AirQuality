package com.oop.dao;

import com.oop.models.CurrentPm;
import com.oop.models.Database;
import com.oop.services.CurrentPmService;
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

    public List<CurrentPm> getCurrentPmforAllSensors() {
        List<CurrentPm> currentPms = new ArrayList();
        try {
            ResultSet rs = db.getResults(query);
            while (rs.next()) {
                CurrentPm currentPm = new CurrentPm();
                currentPm.setTimestamp(rs.getString(1));
                currentPm.setPm1(rs.getString(2));
                currentPm.setPm25(rs.getString(3));
                currentPm.setLat(rs.getString(4));
                currentPm.setLon(rs.getString(5));
                currentPm.setSensorId(rs.getString(6));
                currentPms.add(currentPm);
                System.out.println(currentPm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurrentPmService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentPms;
    }

}
