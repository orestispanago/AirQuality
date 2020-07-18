SELECT sensors_locations.lat,sensors_locations.lon, maxT, sensors_locations_id
FROM
(SELECT max(timestamp) maxT,sensors_locations_id
	FROM
		(SELECT pm_measurements.timestamp,
				pm_measurements.sensors_locations_id,
				sensors_locations.lat,
				sensors_locations.lon
			FROM sensors_locations,pm_measurements
			ORDER BY pm_measurements.timestamp DESC) x
GROUP BY x.sensors_locations_id) y, sensors_locations
WHERE y.sensors_locations_id=sensors_locations.id
;
