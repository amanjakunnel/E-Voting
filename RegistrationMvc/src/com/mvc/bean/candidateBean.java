package com.mvc.bean;

public class candidateBean {

	 private String fullName;
	 private String email;
	 private String candidateId;
	 private String password;
	 private String constituency;
	 public String party;
	 	 public String getCandidateId() {
		 return candidateId;
		 }
		 public void setCandidateId(String candidateId) {
		 this.candidateId = candidateId;
		 }
		 public String getPassword() {
		 return password;
		 }
		 public void setPassword(String password) {
		 this.password = password;
		 }
		 public void setFullName(String fullName) {
		 this.fullName = fullName;
		 }
		 public String getFullName() {
		 return fullName;
		 }
		 public void setEmail(String email) {
		 this.email = email;
		 }
		 public String getEmail() {
		 return email;
		 }
		 public String getConstituency() {
			 return constituency; 
		 }
		 public void setConstituency(String constituency)
		 {
			 this.constituency=constituency;
		 }
		 public String getParty() {
			 return party;
		 }
		 public void setParty(String party) {
			 this.party=party;
		 }
}
