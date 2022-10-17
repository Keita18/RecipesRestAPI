import java.util.Arrays;
import java.util.List;

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        // write your code here
        Arrays.stream(array).forEach(
                it -> {
                    if (it.getClass() == Shape.class) {
                        shapes.add(it);
                    }
                    if (it.getClass() == Polygon.class) {
                        polygons.add((Polygon) it);
                    }
                    if (it.getClass() == Square.class) {
                        squares.add((Square) it);
                    }
                    if (it.getClass() == Circle.class) {
                        circles.add((Circle) it);
                    }
                }
        );
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }