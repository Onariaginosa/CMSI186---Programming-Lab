public class Collatz {
	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *  the main method for the Collatz Sequence
	 *  @param  args  String array which contains command line arguments
	 *
	 **/

public static void main(String[] args) {

	System.out.println("\n\n\n\n\n WELCOME TO THE COLLATZ TEST \n\n\n\n\n Usage: Java Collatz <string of integer digits>");

		try {
			BrobInt newBrob = new BrobInt(args[0]);
			BrobInt countBrob = BrobInt.ZERO;
			while (newBrob.compareTo(BrobInt.ONE) != 0) {
				String newStr = newBrob.toString();
				if ((int)(newStr.charAt(newStr.length() - 1)) % 2 == 0) {
					newBrob = newBrob.divide(BrobInt.TWO).add(BrobInt.ONE);
				} else {
					newBrob = (BrobInt.THREE.multiply(newBrob)).add(BrobInt.ONE);
				}
				countBrob = countBrob.add(BrobInt.ONE);
				System.out.println(" NewBrob: " + newBrob + "\n Counter: " + countBrob +"\n\n\n\n");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong. Try again later.");
		}
	}
}
