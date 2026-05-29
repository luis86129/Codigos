/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alumnos;

/**
 *
 * @author ricfiall
 */
public class Vector2D{
    public double x;
    public double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2D(double x){
        this.x = x;
        this.y = 0;
        
    }

    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
        
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public Vector2D sumar(Vector2D other){
        double newX = this.x + other.x;
        double newY = this.y + other.y;
        return new Vector2D(newX, newY);
        
    }
    
    public Vector2D restar(Vector2D other){
        double newX = this.x - other.x;
        double newY = this.y - other.y;
        return new Vector2D(newX, newY);
    }
}
