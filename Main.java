import java.util.Scanner;

public class Main {
	public static class Dice{
		int top;
		int bottom;
		int north;
		int south;
		int west;
		int east;
		
		public Dice(int top, int bottom, int north, int south, int west, int east) {
			this.top = top;
			this.bottom = bottom;
			this.north = north;
			this.south = south;
			this.west = west;
			this.east = east;
		}
		public Dice moveToSouth() {
			int tempTop = this.top;
			int tempBottom = this.bottom;
			
			this.top = this.north;
			this.bottom = this.south;
			
			this.south = tempTop;
			this.north = tempBottom;
			
			return this;
		}
		
		public Dice moveToNorth() {
			int tempTop = this.top;
			int tempBottom = this.bottom;
			
			this.top = this.south;
			this.bottom = this.north;
			
			this.north = tempTop;
			this.south = tempBottom;
			
			return this;
		}
		
		public Dice moveToWest() {
			int tempTop = this.top;
			int tempBottom = this.bottom;
			
			this.top = this.east;
			this.bottom = this.west;
			
			this.west = tempTop;
			this.east = tempBottom;
			
			return this;
		}
		
		public Dice moveToEast() {
			int tempTop = this.top;
			int tempBottom = this.bottom;
			
			this.top = this.west;
			this.bottom = this.east;
			
			this.east = tempTop;
			this.west = tempBottom;
			
			return this;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] map = new int[n][m];
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		int numOfCommand = scan.nextInt();
		int[] commandList = new int[numOfCommand];
		
		scan.nextLine();
		
		for(int i= 0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = scan.nextInt();
			}
			scan.nextLine();
		}
		
		for(int i = 0;i<numOfCommand;i++) {
			commandList[i] = scan.nextInt();
		}
		int[] result = diceGame(x, y, n, m, map, commandList);
		
		for(int i =0;i<commandList.length;i++) {
			if(result[i] != -1) System.out.println(result[i]);
		}
		
	}
	public static int[] diceGame(int x, int y, int n, int m, int[][] map, int[] commandList) {
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);
		int[] topValue = new int[commandList.length];
		
		int preX = x;
		int preY = y;
		int coordX = x;
		int coordY = y;
				
		for(int i=0;i<commandList.length;i++) {
			
			topValue[i] = -1;
			// Move Dice by Order
			switch(commandList[i]) {
			case 1: // Move to East
				if(coordY+1 < m) {
					dice = dice.moveToEast();
					coordY ++;
				}
				break;
			case 2: // Move to West
				if(coordY-1 >= 0) {
					dice = dice.moveToWest();
					coordY --;
				}
				break;
			case 3: // Move to North
				if(coordX-1 >= 0) {
					dice = dice.moveToNorth();
					coordX --;
				}
				break;
			case 4: // Move to South
				if(coordX+1 < n) {
					dice = dice.moveToSouth();
					coordX ++;
				}
				break;
			}
			
			// If coordination over Map Size, topValue[i] is -1 
			if(preX != coordX || preY != coordY) {
				
				if(map[coordX][coordY]== 0) {
					
					map[coordX][coordY] = dice.bottom;
				}else {

					dice.bottom = map[coordX][coordY];
					map[coordX][coordY] = 0;
				}
				topValue[i] = dice.top;
			}
			preX = coordX;
			preY = coordY;
					
		}
		return topValue;
	}

}
