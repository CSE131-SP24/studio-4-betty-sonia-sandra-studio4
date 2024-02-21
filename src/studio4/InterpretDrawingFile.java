package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String shapeType = in.next();
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		StdDraw.setPenColor(redComponent,greenComponent,blueComponent);
		boolean isFilled = in.nextBoolean();
		double parameterOne = in.nextDouble();
		double parameterTwo = in.nextDouble();
		double parameterThree = in.nextDouble();
		if(shapeType == "ellipse") {
			double parameterFour = in.nextDouble();
			if(isFilled)
				StdDraw.filledEllipse(parameterOne, parameterTwo, parameterThree, parameterFour);
			else
				StdDraw.ellipse(parameterOne, parameterTwo, parameterThree, parameterFour);
		}
		else if(shapeType == "rectangle") {
			double parameterFour = in.nextDouble();
			if(isFilled)
				StdDraw.filledRectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
			else
				StdDraw.rectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
		}
		else {
			double parameterFour = in.nextDouble();
			double parameterFive = in.nextDouble();
			double parameterSix = in.nextDouble();
			double[] x = {parameterOne, parameterThree, parameterFive};
			double[] y = {parameterTwo, parameterFour, parameterSix};
			if(isFilled) {
				StdDraw.filledPolygon(x, y);
			}
			else
				StdDraw.polygon(x, y);
		}
		
		
	}
}
