/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ordercombiner.model;

import java.util.List;

/**
 *
 * @author Wycliffe
 */
public class DistanceInfo {

    private List<DistanceElements> elements;

    public DistanceInfo(List<DistanceElements> elements) {
        this.elements = elements;
    }

    public DistanceInfo() {
    }

    public List<DistanceElements> getElements() {
        return elements;
    }

    public void setElements(List<DistanceElements> elements) {
        this.elements = elements;
    }

}
