/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.dtos;

import java.io.Serializable;

/**
 *
 * @author Walter
 */
public class SubscriptionDTO implements Serializable {
    private long subscriptionId;
    private String username;
    private long planId;
    private int monthsToExtend;

    public SubscriptionDTO() {
    }

    public SubscriptionDTO(String username, long planId) {
        this.username = username;
        this.planId = planId;
    }

    public SubscriptionDTO(long subscriptionId, String username, long planId) {
        this.subscriptionId = subscriptionId;
        this.username = username;
        this.planId = planId;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public int getMonthsToExtend() {
        return monthsToExtend;
    }

    public void setMonthsToExtend(int monthsToExtend) {
        this.monthsToExtend = monthsToExtend;
    }

    @Override
    public String toString() {
        return "SubscriptionDTO{" + "subscriptionId=" + subscriptionId + ", username=" + username + ", planId=" + planId + ", monthsToExtend=" + monthsToExtend + '}';
    }
}
