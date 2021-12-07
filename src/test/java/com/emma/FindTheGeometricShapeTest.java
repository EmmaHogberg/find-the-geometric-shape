package com.emma;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FindTheGeometricShapeTest {

    private FindTheGeometricShape findTheGeometricShape;
    private ArrayList<Coordinate> coordinateList;

    @BeforeEach
    void setup() {
        coordinateList = new ArrayList<>();

    }

    @Test
    public void should_ReturnAnswerNone_when_EmptyListInput() {

        findTheGeometricShape = new FindTheGeometricShape(coordinateList);
        
        String expected = "None";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerDot_when_OneCoordinate() {

        coordinateList.add(new Coordinate(1, 0, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Dot";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerLine_when_TwoCoordinates() {

        coordinateList.add(new Coordinate(4, 3, 0));
        coordinateList.add(new Coordinate(9, 3, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Line";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerTriangle_when_ThreeCoordinates() {

        coordinateList.add(new Coordinate(5, 3, 0));
        coordinateList.add(new Coordinate(11, 3, 0));
        coordinateList.add(new Coordinate(9, 7, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Triangle";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerSquare_when_FourCoordinatesAndEquallyLongSides() {

        coordinateList.add(new Coordinate(7, 3, 0));
        coordinateList.add(new Coordinate(11, 3, 0));
        coordinateList.add(new Coordinate(11, 7, 0));
        coordinateList.add(new Coordinate(7, 7, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Square";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerRectangle_when_FourCoordinatesWithTwoEquallyLongSides() {

        coordinateList.add(new Coordinate(6, 4, 0));
        coordinateList.add(new Coordinate(13, 4, 0));
        coordinateList.add(new Coordinate(13, 7, 0));
        coordinateList.add(new Coordinate(6, 7, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Rectangle";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerRectangle_when_FourCoordinatesWithTwoEquallyLongSidesDifferentPlanes() {

        coordinateList.add(new Coordinate(6, 0, 4));
        coordinateList.add(new Coordinate(13, 0, 4));
        coordinateList.add(new Coordinate(13, 0, 7));
        coordinateList.add(new Coordinate(6, 0, 7));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Rectangle";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerParallelogram_when_FourCoordinatesWithTwoEquallyLongSidesDiagonally() {

        coordinateList.add(new Coordinate(3, 3, 0));
        coordinateList.add(new Coordinate(12, 3, 0));
        coordinateList.add(new Coordinate(13, 7, 0));
        coordinateList.add(new Coordinate(4, 7, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Parallelogram";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerParallelogram_when_FourCoordinatesWithTwoEquallyLongSidesDiagonallyDifferentPlanes() {

        coordinateList.add(new Coordinate(0, 3, 3));
        coordinateList.add(new Coordinate(0, 9, 3));
        coordinateList.add(new Coordinate(0, 11, 5));
        coordinateList.add(new Coordinate(0, 5, 5));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Parallelogram";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswer2DShape_when_FourCoordinatesOnSamePlaneWithNoOtherMatchingShape() {

        coordinateList.add(new Coordinate(3, 0,3));
        coordinateList.add(new Coordinate(9, 0, 3));
        coordinateList.add(new Coordinate(11, 0, 8));
        coordinateList.add(new Coordinate(5, 0, 5));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "2D Shape";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerPyramid_when_SquareFiveCoordinatesAndValueInZ() {

        coordinateList.add(new Coordinate(7, 3, 0));
        coordinateList.add(new Coordinate(11, 3, 0));
        coordinateList.add(new Coordinate(11, 7, 0));
        coordinateList.add(new Coordinate(7, 7, 0));
        coordinateList.add(new Coordinate(9, 5, 4));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Pyramid";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerPyramid_when_RectangleFiveCoordinatesAndValueInZ() {

        coordinateList.add(new Coordinate(6, 4, 0));
        coordinateList.add(new Coordinate(14, 4, 0));
        coordinateList.add(new Coordinate(14, 7, 0));
        coordinateList.add(new Coordinate(6, 7, 0));
        coordinateList.add(new Coordinate(10, 5, 6));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Pyramid";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_Return2dShape_when_RectangleFiveCoordinatesAndNoValueInThirdPlane() {

        coordinateList.add(new Coordinate(6, 3, 0));
        coordinateList.add(new Coordinate(14, 3, 0));
        coordinateList.add(new Coordinate(14, 7, 0));
        coordinateList.add(new Coordinate(6, 7, 0));
        coordinateList.add(new Coordinate(10, 5, 0));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "2D Shape";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerCube_when_EightCoordinatesAndSixEqualSquares() {

        coordinateList.add(new Coordinate(7, 3, 0));
        coordinateList.add(new Coordinate(11, 3, 0));
        coordinateList.add(new Coordinate(11, 7, 0));
        coordinateList.add(new Coordinate(7, 7, 0));
        coordinateList.add(new Coordinate(7, 3, 4));
        coordinateList.add(new Coordinate(11, 3, 4));
        coordinateList.add(new Coordinate(11, 7, 4));
        coordinateList.add(new Coordinate(7, 7, 4));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Cube";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerCube_when_EightCoordinatesAndSixEqualSquaresDifferentPlanes() {

        coordinateList.add(new Coordinate(7, 0, 3));
        coordinateList.add(new Coordinate(11, 0, 3));
        coordinateList.add(new Coordinate(11, 0, 7));
        coordinateList.add(new Coordinate(7, 0, 7));
        coordinateList.add(new Coordinate(7, 4, 3));
        coordinateList.add(new Coordinate(11, 4, 3));
        coordinateList.add(new Coordinate(11, 4, 7));
        coordinateList.add(new Coordinate(7, 4, 7));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Cube";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswerRectanglePrism_when_EightCoordinatesWithTwoEquallyLongSides() {

        coordinateList.add(new Coordinate(6, 4, 0));
        coordinateList.add(new Coordinate(13, 4, 0));
        coordinateList.add(new Coordinate(13, 7, 0));
        coordinateList.add(new Coordinate(6, 7, 0));
        coordinateList.add(new Coordinate(6, 4, 5));
        coordinateList.add(new Coordinate(13, 4, 5));
        coordinateList.add(new Coordinate(13, 7, 5));
        coordinateList.add(new Coordinate(6, 7, 5));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "Rectangular Prism";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnAnswer3dShape_when_EightCoordinatesAndNoMatchingForm() {

        coordinateList.add(new Coordinate(7, 0, 3));
        coordinateList.add(new Coordinate(11, 0, 3));
        coordinateList.add(new Coordinate(11, 1, 7));
        coordinateList.add(new Coordinate(7, 1, 7));
        coordinateList.add(new Coordinate(7, 2, 3));
        coordinateList.add(new Coordinate(11, 2, 3));
        coordinateList.add(new Coordinate(11, 4, 7));
        coordinateList.add(new Coordinate(7, 4, 7));
        findTheGeometricShape = new FindTheGeometricShape(coordinateList);

        String expected = "3D Shape";

        String actual = findTheGeometricShape.getNameOfTheShape();

        assertEquals(expected, actual);
    }
}
























