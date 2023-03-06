/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author Roxana
 */
public class Highway extends RoadType {
    private int numOfLanes;

    public void setNumOfLanes(int numOfLanes) {
        this.numOfLanes = numOfLanes;
    }

    public int getNumOfLanes() {
        return numOfLanes;
    }

    public Highway(String material, int numOfLanes) {
        this.setMaterial(material);
        this.numOfLanes = numOfLanes;
    } 
}
