package bankmangementapp;

import java.util.Objects;

public class TranslationPOJO {
   private long accountNumber;
   private String timeDate;
   private String translation;
   private double amount;
   private double accountBalance;
public TranslationPOJO() {
	super();
}
public TranslationPOJO(long accountNumber, String timeDate, String translation, double amount, double accountBalance) {
	super();
	this.accountNumber = accountNumber;
	this.timeDate = timeDate;
	this.translation = translation;
	this.amount = amount;
	this.accountBalance = accountBalance;
}
public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getTimeDate() {
	return timeDate;
}
public void setTimeDate(String timeDate) {
	this.timeDate = timeDate;
}
public String getTranslation() {
	return translation;
}
public void setTranslation(String translation) {
	this.translation = translation;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}
@Override
public int hashCode() {
	return Objects.hash(accountBalance, accountNumber, amount, timeDate, translation);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TranslationPOJO other = (TranslationPOJO) obj;
	return Double.doubleToLongBits(accountBalance) == Double.doubleToLongBits(other.accountBalance)
			&& accountNumber == other.accountNumber
			&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
			&& Objects.equals(timeDate, other.timeDate) && Objects.equals(translation, other.translation);
}
@Override
public String toString() {
	return "TranslationPOJO [accountNumber=" + accountNumber + ", timeDate=" + timeDate + ", translation=" + translation
			+ ", amount=" + amount + ", accountBalance=" + accountBalance + "]";
}
   
}
