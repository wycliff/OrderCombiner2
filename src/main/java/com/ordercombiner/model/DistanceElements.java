/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordercombiner.model;

/**
 *
 * @author Wycliffe
 */
public class DistanceElements {

    private Distance distance;
    private Duration duration;
    private String status;

    public DistanceElements(Distance distance, Duration duration, String status) {
        this.distance = distance;
        this.duration = duration;

        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DistanceElements() {
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

}
