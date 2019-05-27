//Marilize Pires
// Assignment 4 BASIC: Histogram
//F17 CS F001A OBJ-ORIENTED JAVA FALL 2017

import becker.robots.*;

class HistogramRobot extends Robot {
	// CONSTRUCTOR FOR HistogramRobot
	HistogramRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void drawRow(int width) {

		for (int i = 0; i < width; ++i) {
			putThing();
			move();
		}
		turnLeft(2);
		for (int j = 0; j < width; ++j) {
			move();
		}
		turnLeft(1);
		move();
		turnLeft(1);
	}

	public void turnLeft(int turns) {
		int i = 1;
		while (i <= turns) {
			turnLeft();
			i++;
		}
	}
}

public class DrawHistogram extends Object {
	public static void main(String[] args) {
		City Edmonds = new City(12, 12);
		HistogramRobot drawingBot = new HistogramRobot(Edmonds, 0, 1, Direction.EAST, 1000); // drawingBot
																								// object
																								// created

		HistogramPrinter histPrinter = new HistogramPrinter(); // histPrinter
																// object
																// created to
																// use the
																// printHistogram()
																// method

		// This is the histogramData array with a length of 7 elements
		int[] histogramData = new int[7];

		histogramData[0] = 3; // The first element holds 3
		histogramData[1] = 5; // The second element holds 5
		histogramData[2] = 1; // The third element holds 1
		histogramData[3] = 0; // The fourth element holds 0
		histogramData[4] = 4; // The fifth element holds 4
		histogramData[5] = 2; // The sixth element holds 2
		histogramData[6] = 1; // The seventh element holds 1

		for (int i = 0; i < histogramData.length; ++i) {
			drawingBot.drawRow(histogramData[i]);
		}

		System.out.println(" ============  YOUR OUTPUT STARTS BELOW: ==============");

		histPrinter.printHistogram(histogramData);
	}
}
