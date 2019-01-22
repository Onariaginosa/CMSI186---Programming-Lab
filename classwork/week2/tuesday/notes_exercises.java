/**
 *  File name     :  whatIsItDoing.java
 *  Purpose       :  Practice interpreting Java code
 *  Author        :  A. Volosin
 *  Date          :  2019-01-22
 *  Description   :  An excercise lovingly adapted from Head First Java
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2019-01-22  A. Volosin     Initial writing and release
 */

//
//
//
//
// Beginning of First Excercise


int size = 10;                      //declare an integer variable, call it 'size' and assign it a value of 10
String name = "Tinker";             //declare a string variable, call it name and assign it a value of "Tinker"
Dog myDog = new Dog(name, size);    //declare a dog variable/object, call it myDog and assigning it a value of a dog object with agruments name and size
x = size - 5;                       //reassigning variable x the value of size - 5
if (x < 15) myDog.bark(5);          //an if statement saying that if the variable x is less than 15, then the method bark of myDog will be called with the argument 5

while (x > 3) {                     //a while statement saying that as long as the variable x is greater than 3, then
  myDog.play();                     //it will execute the method play of myDog
}                                   //end of the while loop

int[] numList = {2,4,6,8};          //declare an array of integer variable, call it "numList" and assign it the value of {2,4,6,8}
System.out.print("Howdy");          //printing to the console "Howdy"
System.out.print("Dog: " + name);   //printing to the console in the same line with no space "Dog: Tinker"
String num = "8";                   //declare a string variable called num with the value "8"
int z = Integer.parseInt(num);      //declare an integer variable called "z" with the value Integer.parseInt(num)

try {                               //attempt to do something
  readTheFile("myFile.txt");        //read file with the name "myFile.txt"
}                                   // end of the try method/function?
catch(FileNotFoundException ex) {   //if there is no file "myFile.tx"
  System.out.print("File not found.");  //print in the console "File not found." in the same line
}                                   // end of the catch method/function
// End of First Excercise
//
//
//
// Beginning of Second Excercise
public class helloWorld{
    public static void main (String[] args) {
        int x = 1;
        while (x < 3 ) {
            System.out.print(“Hello”);
            System.out.print(“World”);
            x = x + 1;
        }
        if (x == 3 ) {
            System.out.print(“Howdy”);
        }
    }
}
