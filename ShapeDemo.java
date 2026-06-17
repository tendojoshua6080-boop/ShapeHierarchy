/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapehierarchy;

/**
 *
 * @author HP DIL
 */
public class ShapeDemo {public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("         SHAPE HIERARCHY DEMONSTRATION       ");
        System.out.println("============================================\n");

        java.util.ArrayList<Shape> shapeList = new java.util.ArrayList<Shape>();

        // Create valid shapes
        try {
            Circle circle = new Circle(5, "red", true);
            Rectangle rectangle = new Rectangle(4, 6, "blue", false);
            Triangle triangle = new Triangle(3, 4, 5, "green", true);

            shapeList.add(circle);
            shapeList.add(rectangle);
            shapeList.add(triangle);

            System.out.println("Successfully created 3 valid shapes:\n");
            for (int i = 0; i < shapeList.size(); i++) {
                System.out.println("  " + shapeList.get(i));
            }
        } catch (InvalidShapeException e) {
            System.out.println("  [!] Error creating shape: " + e.getMessage());
        }

        // Demonstrate catching InvalidShapeException with an invalid triangle
        System.out.println("\n--------------------------------------------");
        System.out.println("  Attempting to create an INVALID triangle    ");
        System.out.println("  (sides 1, 2, 10 -- violates triangle rule)  ");
        System.out.println("--------------------------------------------");
        try {
            Triangle badTriangle = new Triangle(1, 2, 10);
            shapeList.add(badTriangle); // this line will never run
        } catch (InvalidShapeException e) {
            System.out.println("  [CAUGHT] " + e.getMessage());
        }

        // Convert to array for printAreas and largest methods
        Shape[] shapesArray = shapeList.toArray(new Shape[0]);

        System.out.println("\n============================================");
        System.out.println("       AREAS (via superclass reference)      ");
        System.out.println("============================================");
        printAreas(shapesArray);

        System.out.println("\n============================================");
        System.out.println("              LARGEST SHAPE                  ");
        System.out.println("============================================");
        Shape biggest = largest(shapesArray);
        System.out.println("  The largest shape is: " + biggest);

        // Demonstrate resize
        System.out.println("\n============================================");
        System.out.println("           RESIZE DEMONSTRATION              ");
        System.out.println("============================================");
        System.out.println("  Before resize: " + shapesArray[0]);
        shapesArray[0].resize(2);
        System.out.println("  After resize x2: " + shapesArray[0]);

        System.out.println("\n  Attempting resize with a non-positive factor (-1):");
        shapesArray[0].resize(-1);
    }

    /**
     * Prints the area of each shape using the superclass (Shape) reference.
     * Demonstrates dynamic binding: although declared as Shape, the actual
     * getArea() called depends on the real object type at runtime.
     */
    public static void printAreas(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("  %s Area = %.2f%n",
                    shapes[i].getClass().getSimpleName(), shapes[i].getArea());
        }
    }

    /**
     * Returns the shape with the largest area by comparing getArea() values.
     */
    public static Shape largest(Shape[] shapes) {
        if (shapes.length == 0) return null;

        Shape biggest = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > biggest.getArea()) {
                biggest = shapes[i];
            }
        }
        return biggest;
    }
    
}
