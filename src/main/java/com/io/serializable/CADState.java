package com.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 17:44
 */
public class CADState {
    public static void main(String[] args) throws Exception {
        Vector shapeTypes, shapes;
        if (args.length != 0) {
            shapeTypes = new Vector();
            shapes = new Vector();
            // Add handles to the class objects:
            shapeTypes.addElement(Circle.class);
            shapeTypes.addElement(Square.class);
            shapeTypes.addElement(Line.class);
            // Make some shapes:
            for (int i = 0; i < 10; i++) {
                shapes.addElement(Shape.randomFactory());
            }
            // Set all the static colors to GREEN:
            for (int i = 0; i < 10; i++) {
                ((Shape) shapes.elementAt(i))
                        .setColor(Shape.GREEN);
            }
            // Save the state vector:
            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("CADState.out"));
            out.writeObject(shapeTypes);
            Line.serializeStaticState(out);
            out.writeObject(shapes);
        } else { // There's a command-line argument
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("CADState.out"));
            // Read in the same order they were written:
            shapeTypes = (Vector) in.readObject();
            Line.deserializeStaticState(in);
            shapes = (Vector) in.readObject();
        }
        // Display the shapes:
        System.out.println(shapes);
    }
}
