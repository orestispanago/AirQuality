SELECT   
pm_measurements.timestamp,   
pm_measurements.pm1,   
pm_measurements.pm25,   
sensors_locations.lat,   
sensors_locations.lon,   
sensors_locations.id   
FROM   
sensors_locations,   
pm_measurements   
WHERE   
sensors_locations.id= pm_measurements.sensors_locations_id   
AND   
sensors_locations.id=1   
ORDER BY pm_measurements.timestamp
DESC
LIMIT 1
;
             
