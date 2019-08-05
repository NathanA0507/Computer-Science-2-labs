

public class practice{
	public static void main(String args[]){
		boolean schedule[][] = new boolean[7][10];
		schedule[1][2] = schedule[2][3] = schedule[2][4] = schedule[2][5] = schedule[3][2] = schedule[3][3] = schedule[3][4] = schedule[3][5] = schedule[4][7] = schedule[4][8] = schedule[5][9] = true;
		
		
	}
	
	public static boolean isAvailable(boolean[][] schedule, int day, int timeSlot){
		return !schedule[day][timeSlot];
	}
	
	public static int busyHours(boolean[][] schedule, int day){
		int hoursBusy = 0;
		for (int i = 0; i < 10; i++){
			if (schedule[day][i])
				hoursBusy++;
		}
		return hoursBusy;
	}
	
	public static int busyDays(boolean[][] schedule, int timeSlot){
		int daysBusy = 0;
		for (int i = 0; i < 7; i++){
			if (schedule[i][timeSlot])
				daysBusy++;
		}
		return daysBusy;
	}
}