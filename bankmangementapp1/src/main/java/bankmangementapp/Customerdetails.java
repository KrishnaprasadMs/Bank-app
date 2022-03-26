package bankmangementapp;

import java.util.Objects;

public class Customerdetails {
	private int customerId;
	private String customerName;
	private String password;
	private long phoneNumber;
	private String emailId;
	private String panNumber;
	private String address;
	private String nomineeName;
	private long aadhaar;
	private String dateOfBirth;
	private String accountStatus;
	private long accountNumber;
	private double accountBalance;
	private float interestRate;
	private String accountType;
	private float fdInterestRate;
	private float RdInterestRate;
	private double fdAmount;
	private double rdAmount;
	private String maturityDuration;
	private double fdInterestAdd;
	private double rdInterestAdd;
	private double mainInterestAdd;

	public Customerdetails() {
		super();
	}

	public Customerdetails(int customerId, String customerName, String password, long phoneNumber, String emailId,
			String panNumber, String address, String nomineeName, String accountType, long aadhaar, String dateOfBirth,
			String accountStatus) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.panNumber = panNumber;
		this.address = address;
		this.nomineeName = nomineeName;
		this.accountType = accountType;
		this.aadhaar = aadhaar;
		this.dateOfBirth = dateOfBirth;
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Customerdetails [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", panNumber=" + panNumber + ", address="
				+ address + ", nomineeName=" + nomineeName + ", aadhaar=" + aadhaar + ", dateOfBirth=" + dateOfBirth
				+ ", accountStatus=" + accountStatus + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", interestRate=" + interestRate + ", accountType=" + accountType
				+ ", fdInterestRate=" + fdInterestRate + ", RdInterestRate=" + RdInterestRate + ", fdAmount=" + fdAmount
				+ ", rdAmount=" + rdAmount + ", maturityDuration=" + maturityDuration + ", fdInterestAdd="
				+ fdInterestAdd + ", rdInterestAdd=" + rdInterestAdd + ", mainInterestAdd=" + mainInterestAdd + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(RdInterestRate, aadhaar, accountBalance, accountNumber, accountStatus, accountType, address,
				customerId, customerName, dateOfBirth, emailId, fdAmount, fdInterestAdd, fdInterestRate, interestRate,
				mainInterestAdd, maturityDuration, nomineeName, panNumber, password, phoneNumber, rdAmount,
				rdInterestAdd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customerdetails other = (Customerdetails) obj;
		return Float.floatToIntBits(RdInterestRate) == Float.floatToIntBits(other.RdInterestRate)
				&& aadhaar == other.aadhaar
				&& Double.doubleToLongBits(accountBalance) == Double.doubleToLongBits(other.accountBalance)
				&& accountNumber == other.accountNumber && Objects.equals(accountStatus, other.accountStatus)
				&& Objects.equals(accountType, other.accountType) && Objects.equals(address, other.address)
				&& customerId == other.customerId && Objects.equals(customerName, other.customerName)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailId, other.emailId)
				&& Double.doubleToLongBits(fdAmount) == Double.doubleToLongBits(other.fdAmount)
				&& Double.doubleToLongBits(fdInterestAdd) == Double.doubleToLongBits(other.fdInterestAdd)
				&& Float.floatToIntBits(fdInterestRate) == Float.floatToIntBits(other.fdInterestRate)
				&& Float.floatToIntBits(interestRate) == Float.floatToIntBits(other.interestRate)
				&& Double.doubleToLongBits(mainInterestAdd) == Double.doubleToLongBits(other.mainInterestAdd)
				&& Objects.equals(maturityDuration, other.maturityDuration)
				&& Objects.equals(nomineeName, other.nomineeName) && Objects.equals(panNumber, other.panNumber)
				&& Objects.equals(password, other.password) && phoneNumber == other.phoneNumber
				&& Double.doubleToLongBits(rdAmount) == Double.doubleToLongBits(other.rdAmount)
				&& Double.doubleToLongBits(rdInterestAdd) == Double.doubleToLongBits(other.rdInterestAdd);
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public long getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(long aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getFdInterestRate() {
		return fdInterestRate;
	}

	public void setFdInterestRate(float fdInterestRate) {
		this.fdInterestRate = fdInterestRate;
	}

	public float getRdInterestRate() {
		return RdInterestRate;
	}

	public void setRdInterestRate(float rdInterestRate) {
		RdInterestRate = rdInterestRate;
	}

	public double getFdAmount() {
		return fdAmount;
	}

	public void setFdAmount(double fdAmount) {
		this.fdAmount = fdAmount;
	}

	public double getRdAmount() {
		return rdAmount;
	}

	public void setRdAmount(double rdAmount) {
		this.rdAmount = rdAmount;
	}

	public String getMaturityDuration() {
		return maturityDuration;
	}

	public void setMaturityDuration(String maturityDuration) {
		this.maturityDuration = maturityDuration;
	}

	public double getFdInterestAdd() {
		return fdInterestAdd;
	}

	public void setFdInterestAdd(double fdInterestAdd) {
		this.fdInterestAdd = fdInterestAdd;
	}

	public double getRdInterestAdd() {
		return rdInterestAdd;
	}

	public void setRdInterestAdd(double rdInterestAdd) {
		this.rdInterestAdd = rdInterestAdd;
	}

	public double getMainInterestAdd() {
		return mainInterestAdd;
	}

	public void setMainInterestAdd(double mainInterestAdd) {
		this.mainInterestAdd = mainInterestAdd;
	}

	public Customerdetails(int customerId, String customerName, String password, long phoneNumber, String emailId,
			String panNumber, String address, String nomineeName, long aadhaar, String dateOfBirth,
			String accountStatus, long accountNumber, double accountBalance, float interestRate, String accountType,
			float fdInterestRate, float rdInterestRate, double fdAmount, double rdAmount, String maturityDuration,
			double fdInterestAdd, double rdInterestAdd, double mainInterestAdd) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.panNumber = panNumber;
		this.address = address;
		this.nomineeName = nomineeName;
		this.aadhaar = aadhaar;
		this.dateOfBirth = dateOfBirth;
		this.accountStatus = accountStatus;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.interestRate = interestRate;
		this.accountType = accountType;
		this.fdInterestRate = fdInterestRate;
		RdInterestRate = rdInterestRate;
		this.fdAmount = fdAmount;
		this.rdAmount = rdAmount;
		this.maturityDuration = maturityDuration;
		this.fdInterestAdd = fdInterestAdd;
		this.rdInterestAdd = rdInterestAdd;
		this.mainInterestAdd = mainInterestAdd;
	}

}
