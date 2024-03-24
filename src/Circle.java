import javax.swing.*;
public class Circle {

	public static void main(String[] args) {
		double radius, area, circumference;
		int tryAgain;
		
		do {
			radius = getRadius();
			//System.out.println(radius); - testing purposes
			area = calculateArea(radius);
			circumference = calculateCircumference(radius);
			displayProperties(area, circumference);
			tryAgain = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?", "Confirm", JOptionPane.YES_NO_OPTION);
		}
		while (tryAgain != 0);	//Prevents the button "NO" AND the X Button from causing an error in the program.
	}//end of main method
	
	public static double getRadius() {
		double rad = -1;	//Default value of -1 to return value from special case of checking - in case there is NO corresponding catch block to deal with the exception in the try block.
		boolean exception = true;
		
		do {
			try {
				rad = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the radius:"));
				exception = false;
			}//end of try
			catch(NumberFormatException nf) {
				JOptionPane.showMessageDialog(null, "Invalid Input/No Input", "Error", JOptionPane.ERROR_MESSAGE);
			}//end of catch
			catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Invalid Input/No Input", "Error", JOptionPane.ERROR_MESSAGE);
			}//end of catch
		}//end of do-while loop
		while(exception);
		
		return rad;
	}//end of getRadius method
	
	public static double calculateArea (double radiusOne) {
		double areaCircle;
		areaCircle = Math.PI * Math.pow(radiusOne, 2);
		return areaCircle;
	}//end of calculateArea method
	
	public static double calculateCircumference (double radiusTwo) {
		double circumferenceCircle;
		circumferenceCircle = 2 * Math.PI * radiusTwo;
		return circumferenceCircle;
	}//end of calculateCircumference method
	
	public static void displayProperties (double displayArea, double displayCircumference) {
		String output;
		JTextArea myArea = new JTextArea();
		output = "Area:\t" + displayArea + "\nCircumference:\t" + displayCircumference;
		myArea.setText(output);
		JOptionPane.showMessageDialog(null, myArea, "Circle Properties", JOptionPane.PLAIN_MESSAGE);
	}//end of displayProperties method
}//end of class