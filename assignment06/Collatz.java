import java.math.BigInteger;
public class Collatz {
	public static void main(String[] args) {
		try {
			BrobInt newBrob = new BrobInt(args[0]);
			BrobInt countBrob = BrobInt.ZERO.duplicate();
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
			System.out.println("Something went wrong");
		}
	}
}
