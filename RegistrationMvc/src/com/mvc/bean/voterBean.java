package com.mvc.bean;
 
public class voterBean {
 
 private String fullName;
 private String email;
 private String voterId;
 private String password;
 private String constituency;
 public String getVoterId() {
 return voterId;
 }
 public void setVoterId(String voterId) {
 this.voterId = voterId;
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
}
