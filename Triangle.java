/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapehierarchy;

/**
 *
 * @author HP DIL
 */
public class Triangle extends Shape {private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) throws InvalidShapeException {
        super();
        validateSides(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(double sideA, double sideB, double sideC, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        validateSides(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Validates that all sides are positive and satisfy the triangle inequality:
     * the sum of any two sides must be greater than the third side.
     */
    private void validateSides(double a, double b, double c) throws InvalidShapeException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidShapeException("Triangle sides must all be positive.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new InvalidShapeException(
                "Triangle sides " + a + ", " + b + ", " + c + " violate the triangle inequality.");
        }
    }

    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }

    public double getArea() {
        // Heron's formula
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public void resize(double factor) {
        if (factor <= 0) {
            System.out.println("  [!] Resize factor must be positive. Resize rejected.");
            return;
        }
        sideA = sideA * factor;
        sideB = sideB * factor;
        sideC = sideC * factor;
    }

    public String toString() {
        return "Triangle" + super.toString()
                + " Sides=(" + String.format("%.2f", sideA) + ", "
                + String.format("%.2f", sideB) + ", "
                + String.format("%.2f", sideC) + ")";
    }
    
}
