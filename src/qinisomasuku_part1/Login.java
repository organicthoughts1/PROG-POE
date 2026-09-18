/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qinisomasuku_part1;

/**
 *
 * @author Student
 */
public class Login {

// Variables for the registered user's details
private String registeredUsername;
private String registeredPassword;
private String registeredCellPhoneNumber;

// CHECK USERNAME
public static boolean checkUserName(String username) {
return username.contains("_")
&& username.length() <= 5;
}

// CHECK PASSWORD
public static boolean checkPasswordComplexity(String password) {
boolean hasCapital = false;
boolean hasNumber = false;
boolean hasSpecial = false;
for (int i = 0; i < password.length(); i++) {
char character = password.charAt(i);
if (Character.isUpperCase(character)) {
hasCapital = true;
}
if (Character.isDigit(character)) {
hasNumber = true;
}
if (!Character.isLetterOrDigit(character)) {
hasSpecial = true;
}
}
return password.length() >= 8
&& hasCapital
&& hasNumber
&& hasSpecial;
}
// CHECK CELLPHONE NUMBER
public static boolean checkCellPhoneNumber(String cellPhoneNumber) {
String regex = "^\\+27[0-9]{9}$";
return cellPhoneNumber.matches(regex);
}

// REGISTER USER
public String registerUser(String username,
String password,
String cellPhoneNumber) {
if (!checkUserName(username)) {
return "Username is not correctly formatted; "
+ "please ensure that your username contains an "
+ "underscore and is no more than five characters in length.";
}
if (!checkPasswordComplexity(password)) {
return "Password is not correctly formatted; "
+ "please ensure that the password contains at least "
+ "eight characters, a capital letter, a number, "
+ "and a special character.";
}
if (!checkCellPhoneNumber(cellPhoneNumber)) {
return "Cell phone number is incorrectly formatted "
+ "or does not contain international code.";
}
// Store the details after successful registration
registeredUsername = username;
registeredPassword = password;
registeredCellPhoneNumber = cellPhoneNumber;
return "Registration successful.";
}
// LOGIN USER
public boolean loginUser(String username, String password){
return username.equals(registeredUsername)
&& password.equals(registeredPassword);
}

// RETURN LOGIN STATUS
public String returnLoginStatus(boolean loginSuccessful,
String firstName,
String lastName) {
if (loginSuccessful) {
return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
} else {
return "Username or password incorrect, please try again.";
}
}
}

