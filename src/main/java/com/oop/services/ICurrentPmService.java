package com.oop.services;

import java.sql.ResultSet;

/**
 *
 * @author orestis
 */
public interface ICurrentPmService {
    ResultSet getCurrentPmBySensorLocationId(long id);
}
