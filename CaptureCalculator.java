/*Name: Samantha Garcia
 *Date: September 20, 2016
 *Description: This program is designed to help someone figure out if they are able to catch a monster in
 *Brokemon Go. It takes their inputed coordinates and player ID and spits out a probability that will determine
 *if the user should go and chase after the monster.
 *
 *This was a class project.
 */

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Scanner;
    
	public class CaptureCalculator {
        	
		public static void main(String[] args) {
			
			System.out.println("Hello and welcome to the Monster Capture Possibility Calculator. ");
			
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the latitude of the monster (1-10): ");
			double monsterLatitude = in.nextDouble();
			
			
			
			//The following If Statements are used to gather the information used for the Possibility Calculator
			if (monsterLatitude >= 1 && monsterLatitude <= 10 ) {
				System.out.println("Please enter the longitude of the monster (1-10): ");
			}
			double monsterLongitude = in.nextDouble();
			
			if (monsterLongitude >= 1 && monsterLongitude <= 10 ) {
				System.out.println("Please enter the time of the monster appear (1-1440): ");
			}
			int appearMonster = in.nextInt();
				
			if (appearMonster >= 1 && appearMonster <= 1440) {
				System.out.println("Please enter the possible time of the monster will exist (10-59): ");
			}
			int existMonster = in.nextInt();
			
			if (existMonster >= 10 && existMonster <= 59) {
				System.out.println("Please enter the player's ID (8 digits): ");
			}
			int playerID = in.nextInt();	
			
			System.out.println("Please enter the time of the player noticing the monster (1-1440 and greater than the time the monster appears): ");
			int noticeMonster = in.nextInt();
			
			if (noticeMonster >= 1 && noticeMonster <= 1440) {
				System.out.println("Please enter the latitude of the player (1-10): ");
			}
			double playerLatitude = in.nextDouble();
								
			if (playerLatitude >= 1 && playerLatitude <= 10 ) {
				System.out.println("Please enter the longitude of the player (1-10): ");
			}
			double playerLongitude = in.nextDouble();
								
			if (playerLongitude >= 1 && playerLongitude <= 10 ) {
					System.out.println("Please enter the player's walking speed (10-200): ");
			}
			int walkingSpeed = in.nextInt();					
			
			
			
			/*Here I split up finding the distance formula into different parts in order to increase 
			readability and decrease errors. */
			double averageX = (monsterLongitude - playerLongitude);
			double averageY = (monsterLatitude - playerLatitude);
			double squaredX = Math.pow(averageX, 2);
			double squaredY = Math.pow(averageY, 2);
			double distanceFormula = Math.sqrt(squaredX + squaredY);
			double distanceFormulaMeters = (distanceFormula * 1000);
			double timeArrival = (noticeMonster + (distanceFormulaMeters/walkingSpeed));
			double monsterDisappear = ((timeArrival - (appearMonster + existMonster)) / existMonster) * 100 ;
			double totalMonsterExist = (appearMonster + existMonster);

			
			
			/*Here is where the player is determined if they are "lucky" or not. I used the 
			 * module number in order to be able to pull out the last two numbers of their
			 * ID.*/
			String playerList = null;
			//This boolean is to use later in the if statements; if determines the possibility of encounter
			boolean luckyList;
			if (playerID % 100 >= 00 && playerID % 100 <= 49) {
				playerList = ("lucky ");
				luckyList = true;
			}
			else {
				playerList = ("normal ");
				luckyList = false;
			}
			

			
			String possibility = null;
			
			
			
			if (luckyList = true) {
				if ((timeArrival <= totalMonsterExist)) {
					possibility = "definitely";
				}
				else if (timeArrival > totalMonsterExist) {
					if (monsterDisappear >= 0 && monsterDisappear <= 10) {
						possibility = "highly likely";		
					}
					else if (monsterDisappear > 10 && monsterDisappear <= 30) {
						possibility = "likely";
					}
					else if (monsterDisappear > 30 && monsterDisappear <= 40 ) {
						possibility = "unsure";
					}
					else if (monsterDisappear > 40 && monsterDisappear <= 50 ) {
						possibility = "unlikely";
					}
					else if (monsterDisappear > 50 ) {
						possibility = "highly unlikely";
					}
				}
				
				
				
			if (luckyList = false) {
				if ((timeArrival <= totalMonsterExist)) {
					possibility = "definitely";
				}
			else {
					if (monsterDisappear >= 0 && monsterDisappear <= 05) {
						possibility = "highly likely";		
					}
					else if (monsterDisappear > 05 && monsterDisappear <= 20) {
						possibility = "likely";
					}
					else if (monsterDisappear > 20 && monsterDisappear <= 35) {
						possibility = "unsure";
					}
					else if (monsterDisappear > 35 && monsterDisappear <= 40) {
						possibility = "unlikely";
					}
					else if (monsterDisappear > 40 ) {
						possibility = "highly unlikely";
						
					}
				}
			
			}
			}
			
			
			//This DecimalFormat rounds a number to the tenth place
			DecimalFormat df = new DecimalFormat("0.0");
			
			
			System.out.println("Player " + playerID + " who is on the " + playerList + "list, ");
			System.out.println("noticed the monster at time " + noticeMonster + ",");
			System.out.println("is " + df.format(distanceFormulaMeters) + " m away from the monster, ");
			System.out.println("and will arrive at time " + df.format(timeArrival) + ". ");
			System.out.println("The monster's disappear time is about " + (appearMonster + existMonster) + ".");
			System.out.println("So the player will capture this monster with " + possibility + " possibility."); 
			
			
			//This function closes the Scanner to prevent leaks. 
			in.close();
			
		}
	}
	