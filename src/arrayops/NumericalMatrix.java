package arrayops;

public class NumericalMatrix {
	
	private int[][] numbers;
	
	public NumericalMatrix(int[][] numbers) {
		this.numbers = numbers;
	}
	
	public NumericalMatrix add(NumericalMatrix other) {
				
		if(other == null) {
			return null;
		}
		
		if(numbers == null || other.numbers == null) {
			return null;
		}
		
		if(numbers.length != other.numbers.length || numbers[0].length != other.numbers[0].length) {
			return null;
		}
		
		int[][] sumArray = new int[numbers.length][numbers[0].length];

		
		for(int i = 0; i < numbers.length; i++) {
			for(int k = 0; k < numbers[0].length; k++) {
				sumArray[i][k] = numbers[i][k] + other.numbers[i][k];
			}
		}
		
		return new NumericalMatrix(sumArray);
	}
	
	public NumericalMatrix subtract(NumericalMatrix other) {
		
		if(other == null) {
			return null;
		}
		
		if(numbers == null || other.numbers == null) {
			return null;
		}
		
		if(numbers.length != other.numbers.length || numbers[0].length != other.numbers[0].length) {
			return null;
		}
		
		int[][] subtractArray = new int[numbers.length][numbers[0].length];

		
		for(int i = 0; i < numbers.length; i++) {
			for(int k = 0; k < numbers[0].length; k++) {
				subtractArray[i][k] = numbers[i][k] - other.numbers[i][k];
			}
		}
		
		return new NumericalMatrix(subtractArray);
	}
	
	public NumericalMatrix multiplyWise(NumericalMatrix other) {
		
		if(other == null) {
			return null;
		}
		
		if(numbers == null || other.numbers == null) {
			return null;
		}
		
		if(numbers.length != other.numbers.length || numbers[0].length != other.numbers[0].length) {
			return null;
		}
		
		int[][] multipleWiseArray = new int[numbers.length][numbers[0].length];

		
		for(int i = 0; i < numbers.length; i++) {
			for(int k = 0; k < numbers[0].length; k++) {
				multipleWiseArray[i][k] = numbers[i][k] * other.numbers[i][k];
			}
		}
		
		return new NumericalMatrix(multipleWiseArray);
	}
	
	public NumericalMatrix multiply(NumericalMatrix other) {
		
		if(other == null) {
			return null;
		}
		
		if(numbers == null || other.numbers == null) {
			return null;
		}
		
		if(numbers[0].length != other.numbers.length) {
			return null;
		}
		
		int[][] multiplyArray = new int[numbers.length][other.numbers[0].length];
		
		for (int i = 0; i < numbers.length; i++) { //rows of matrix 1
	        for (int j = 0; j < other.numbers[0].length; j++) { //columns of matrix 2
	            for (int k = 0; k < numbers[0].length; k++) { 
	            	
	            	multiplyArray[i][j] += numbers[i][k] * other.numbers[k][j];
	            }
	        }
		}
		
		return new NumericalMatrix(multiplyArray);
	}

	
	@Override
	public String toString() {
		String result = "";
		
		for(int i = 0; i < numbers.length; i++) {
			for(int k = 0; k < numbers[i].length; k++) {
				result += numbers[i][k] + " ";
			}
			result += "\n";
		}
		return result;
	}
}
