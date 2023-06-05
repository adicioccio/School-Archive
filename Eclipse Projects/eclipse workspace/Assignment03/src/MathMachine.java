// Adam Di Cioccio

public class MathMachine {
	//Declare variables
	private double leftOperand = 0;
	private double rightOperand = 0;
	
	//Non-parameterized constructor
	public MathMachine() {
		
	}
	
	//Parameterized constructor
	public MathMachine(double leftOperand, double rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	//getter for left operand
	public double getLeftOperand() {
		return leftOperand;
	}
	
	//setter for left operand
	public void setLeftOperand(double leftOperand) {
		this.leftOperand = leftOperand;
	}
	
	//getter for right operand
	public double getRightOperand() {
		return rightOperand;
	}
	
	//setter for right operand
	public void setRightOperand(double rightOperatnd) {
		this.rightOperand = rightOperatnd;
	}
	
	//add method
	public double add() {
		return leftOperand + rightOperand;
	}
	
	//subtract method
	public double subtract() {
		return leftOperand - rightOperand;
	}
	
	//multiply method
	public double multiply() {
		return leftOperand * rightOperand;
	}
	
	//division method
	public double divide() {
		return leftOperand / rightOperand;
	}
	
	//remainder method
	public double remainder() {
		return leftOperand % rightOperand;
	}
	
	//report status method
	public String reportStatus() {
		return String.format("Left Operand: %f, Right Operand: %f", leftOperand, rightOperand);
	}

}
