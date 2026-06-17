/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapehierarchy;

/**
 *
 * @author HP DIL
 */
public class Circle extends Shape {private double radius;

    public Circle(double radius) throws InvalidShapeException {
        super();
        if (radius <= 0) {
            throw new InvalidShapeException("Circle radius must be positive. Given: " + radius);
        }
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException("Circle radius must be positive. Given: " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void resize(double factor) {
        if (factor <= 0) {
            System.out.println("  [!] Resize factor must be positive. Resize rejected.");
            return;
        }
        radius = radius * factor;
    }

    public String toString() {
        return "Circle" + super.toString() + " Radius=" + String.format("%.2f", radius);
    }
    
}
