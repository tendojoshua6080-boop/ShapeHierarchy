/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapehierarchy;

/**
 *
 * @author HP DIL
 */
public class Rectangle extends Shape {private double width;
    private double height;

    public Rectangle(double width, double height) throws InvalidShapeException {
        super();
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException("Rectangle width and height must be positive.");
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException("Rectangle width and height must be positive.");
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth()  { return width; }
    public double getHeight() { return height; }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void resize(double factor) {
        if (factor <= 0) {
            System.out.println("  [!] Resize factor must be positive. Resize rejected.");
            return;
        }
        width = width * factor;
        height = height * factor;
    }

    public String toString() {
        return "Rectangle" + super.toString()
                + " Width=" + String.format("%.2f", width)
                + "s Height=" + String.format("%.2f", height);
    }
    
}
