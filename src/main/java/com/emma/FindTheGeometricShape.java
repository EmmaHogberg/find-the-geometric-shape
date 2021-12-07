package com.emma;

import java.util.ArrayList;

public class FindTheGeometricShape {

    private Coordinate p1;
    private Coordinate p2;
    private Coordinate p3;
    private Coordinate p4;
    private Coordinate p5;
    private Coordinate p6;
    private Coordinate p7;
    private Coordinate p8;
    private ArrayList<Coordinate> coordinateList;

    private int distanceP1_P2;
    private int distanceP2_P3;
    private int distanceP3_P4;
    private int distanceP4_P1;
    private int distanceP5_P6;
    private int distanceP6_P7;
    private int distanceP7_P8;
    private int distanceP8_P5;
    private int distanceP1_P5;
    private int distanceP2_P6;
    private int distanceP3_P7;
    private int distanceP4_P8;

    public FindTheGeometricShape(ArrayList<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;

        switch (coordinateList.size()) {
            case 8:
                p8 = coordinateList.get(7);
            case 7:
                p7 = coordinateList.get(6);
            case 6:
                p6 = coordinateList.get(5);
            case 5:
                p5 = coordinateList.get(4);
            case 4:
                p4 = coordinateList.get(3);
            case 3:
                p3 = coordinateList.get(2);
            case 2:
                p2 = coordinateList.get(1);
            case 1:
                p1 = coordinateList.get(0);
        }

        switch (coordinateList.size()) {
            case 8:
                distanceP5_P6 = getSquaredDistance(p5, p6);
                distanceP6_P7 = getSquaredDistance(p6, p7);
                distanceP7_P8 = getSquaredDistance(p7, p8);
                distanceP8_P5 = getSquaredDistance(p8, p5);
                distanceP1_P5 = getSquaredDistance(p1, p5);
                distanceP2_P6 = getSquaredDistance(p2, p6);
                distanceP3_P7 = getSquaredDistance(p3, p7);
                distanceP4_P8 = getSquaredDistance(p4, p8);
            case 4:
                distanceP1_P2 = getSquaredDistance(p1, p2);
                distanceP2_P3 = getSquaredDistance(p2, p3);
                distanceP3_P4 = getSquaredDistance(p3, p4);
                distanceP4_P1 = getSquaredDistance(p4, p1);
        }
    }

    public String getNameOfTheShape() {

        String name = "";

        switch (coordinateList.size()) {
            case 0:
                name = "None";
                break;
            case 1:
                name = "Dot";
                break;
            case 2:
                name = "Line";
                break;
            case 3:
                name = "Triangle";
                break;
            case 4:
                if (isShapeSquare(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1)) {
                    name = "Square";
                } else if (isShapeRectangle(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1, p1, p2, p3, p4)) {
                    name = "Rectangle";
                } else if (isShapeParallelogram()) {
                    name = "Parallelogram";
                }
                break;
            case 5:
                if (isShapePyramid()) {
                    name = "Pyramid";
                }
                break;
            case 8:
                if (isShapeSquare(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1) && isShapeSquare(distanceP5_P6, distanceP6_P7, distanceP7_P8, distanceP8_P5)) {
                    if (distanceP1_P5 == (distanceP1_P2 + distanceP5_P6) / 2 && distanceP2_P6 == (distanceP1_P2 + distanceP5_P6) / 2 && distanceP3_P7 == (distanceP1_P2 + distanceP5_P6) / 2 && distanceP4_P8 == (distanceP1_P2 + distanceP5_P6) / 2) {
                        name = "Cube";
                    }
                }

                if (isShapeRectangle(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1, p1, p2, p3, p4) && isShapeRectangle(distanceP5_P6, distanceP6_P7, distanceP7_P8, distanceP8_P5, p5, p6, p7, p8) && distanceP1_P5 == distanceP2_P6 && distanceP2_P6 == distanceP3_P7 && distanceP3_P7 == distanceP4_P8 ||
                        isShapeSquare(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1) && isShapeSquare(distanceP5_P6, distanceP6_P7, distanceP7_P8, distanceP8_P5) && distanceP1_P5 == distanceP2_P6 && distanceP2_P6 == distanceP3_P7 && distanceP3_P7 == distanceP4_P8 && distanceP1_P5 != distanceP1_P2) {

                    name = "Rectangular Prism";
                }

        }

        if (name.isEmpty()) {
            int dimensions = getNumberOfDimensionsInShape();

            if (dimensions == 2) {
                name = "2D Shape";
            } else if (dimensions == 3) {
                name = "3D Shape";
            }
        }

        return name;
    }



    private int getSquaredDistance(Coordinate i, Coordinate j) {
        return (i.x - j.x) * (i.x - j.x) + (i.y - j.y) * (i.y - j.y) + (i.z - j.z) * (i.z - j.z);
    }



    private int getNumberOfDimensionsInShape() {

        int xPlane = 0;
        int yPlane = 0;
        int zPlane = 0;

        for (int i = 0; i < coordinateList.size()-1; i++) {
            for (int j = i+1; j < coordinateList.size(); j++) {

                if (coordinateList.get(i).x != 0 && coordinateList.get(j).x != 0 && coordinateList.get(i).x != coordinateList.get(j).x) {
                    xPlane = 1;
                }

                if (coordinateList.get(i).y != 0 && coordinateList.get(j).y != 0 && coordinateList.get(i).y != coordinateList.get(j).y) {
                    yPlane = 1;
                }

                if (coordinateList.get(i).z != 0 && coordinateList.get(j).z != 0 && coordinateList.get(i).z != coordinateList.get(j).z) {
                    zPlane = 1;
                }
            }
        }
        System.out.println("getNumberOfDimensionsInShape() " + xPlane +" "+ yPlane +" "+ zPlane);
        return xPlane + yPlane + zPlane;
    }


    private boolean isShapeSquare(int d1, int d2, int d3, int d4) {

        return d1 == d2 && d1 == d3 && d1 == d4;
    }


    private boolean isShapeRectangle(int d1, int d2, int d3, int d4, Coordinate... coordinates) {
        return hasTwoEquallyLongOppositeSides(d1, d2, d3, d4) && getPointsOnSamePlane(coordinates) == 4;
    }

    private boolean isShapeTwoRectangle(int d1, int d2, int d3, int d4, Coordinate... coordinates) {
        return hasTwoEquallyLongOppositeSides(d1, d2, d3, d4) && getPointsOnSamePlane(coordinates) == 4;
    }


    private boolean isShapeParallelogram() {
        return hasTwoEquallyLongOppositeSides(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1) && getPointsOnSamePlane() == 2;
    }


    private boolean isShapePyramid() {
        if (isShapeSquare(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1) || isShapeRectangle(distanceP1_P2, distanceP2_P3, distanceP3_P4, distanceP4_P1, p1, p2, p3, p4)) {
            return p5.z > p1.z || p5.z > p2.z || p5.z > p3.z || p5.z > p4.z;
        }
            return false;
    }


    private boolean hasTwoEquallyLongOppositeSides(int d1, int d2, int d3, int d4) {
        return d1 == d3 && d2 == d4;
    }


    private int getPointsOnSamePlane(Coordinate... coordinates) {

        int xPlane = 0;
        int yPlane = 0;
        int zPlane = 0;

        for (int i = 0; i < coordinateList.size()-1; i++) {
            for (int j = i+1; j < coordinateList.size(); j++) {

                if (coordinateList.get(i).x != 0 && coordinateList.get(j).x != 0 && coordinateList.get(i).x == coordinateList.get(j).x) {
                    xPlane += 1;
                } else if (coordinateList.get(i).y != 0 && coordinateList.get(j).y != 0 && coordinateList.get(i).y == coordinateList.get(j).y) {
                    yPlane += 1;
                } else if (coordinateList.get(i).z != 0 && coordinateList.get(j).z != 0 && coordinateList.get(i).z == coordinateList.get(j).z) {
                    zPlane += 1;
                }
            }
        }
        System.out.println("Plane " + " X " + xPlane + " Y " + yPlane + " Z " + zPlane);
        return xPlane + yPlane + zPlane;
    }

}
