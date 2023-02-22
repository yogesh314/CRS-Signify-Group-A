/**
 * 
 */
package com.signify.bean;

/**
 * @author HP
 *
 */
public class OnlinePayment {

public long getCardnum() {
	return cardnum;
}

public void setCardnum(long cardnum) {
	this.cardnum = cardnum;
}

public String getCardexp() {
	return cardexp;
}

public void setCardexp(String cardexp) {
	this.cardexp = cardexp;
}

public int getCvv() {
	return cvv;
}

public void setCvv(int cvv) {
	this.cvv = cvv;
}

public String getNameOnCard() {
	return NameOnCard;
}

public void setNameOnCard(String nameOnCard) {
	NameOnCard = nameOnCard;
}

public String getCardType() {
	return cardType;
}

public void setCardType(String cardType) {
	this.cardType = cardType;
}

private long cardnum;
private String cardexp;
private int cvv;
private String NameOnCard;
private String cardType;
private String BankName;
private int studentId;

public String getBankName() {
	return BankName;
}

public void setBankName(String bankName) {
	this.BankName = bankName;
}

public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}

}


