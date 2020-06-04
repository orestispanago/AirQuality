-- SELECT sensors_locations.lat,sensors_locations.lon, maxT,y.sensors_locations_id
-- FROM 
-- (SELECT max(timestamp) maxT,sensors_locations_id
-- 	FROM 
-- 		(SELECT pm_measurements.timestamp, 
-- 				pm_measurements.sensors_locations_id
-- 			FROM pm_measurements) x
-- GROUP BY x.sensors_locations_id) y, sensors_locations
-- WHERE y.sensors_locations_id=sensors_locations.id;
--              
-- 
-- SELECT sensors_locations.lat,sensors_locations.lon
-- FROM sensors_locations
-- INNER JOIN
-- 	(SELECT max(pm_measurements.id) maxId,pm_measurements.sensors_locations_id sensLocId
-- 	FROM pm_measurements
-- 	GROUP BY pm_measurements.sensors_locations_id) x
-- ON sensors_locations.id=x.sensLocId;
-- 
-- 
-- SELECT pm_measurements.pm1
-- FROM pm_measurements
-- INNER JOIN
-- 	(SELECT max(pm_measurements.id) maxId,pm_measurements.sensors_locations_id sensLocId
-- 	FROM pm_measurements
-- 	GROUP BY pm_measurements.sensors_locations_id) x
-- ON pm_measurements.id=x.maxId;
-- 



SELECT 
    pm_measurements.timestamp,
    pm_measurements.pm1,
    pm_measurements.pm25,
    sensors_locations.lat,
    sensors_locations.lon,
    sensors_locations.id sensorLocationId
FROM
    pm_measurements,
    (SELECT 
        MAX(pm_measurements.id) maxId,
            pm_measurements.sensors_locations_id sensLocId
    FROM
        pm_measurements
    GROUP BY pm_measurements.sensors_locations_id) x,
    sensors_locations
WHERE
    pm_measurements.id = x.maxId
        AND sensors_locations.id = x.sensLocId;