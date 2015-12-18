
public class Main {
	
	public static void main(String [] args){
		
		int[][] array = {{1,2,3}, {3,5,2}, {3,2,5}};
		
		average(array);
	}
	
	public static void average(int[][] numbers){
		int sum = 0;
		double average = 0;
		int count = 0;
		
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < numbers[i].length; j++){
				sum += numbers[i][j];
				count++;
			}
		}
		average = (double) sum / count;
		System.out.print(average);
	}

}
