package com.classes;

public class Book {
		private int bno;
		private String bname;
		private String author;
		private String language;
		private float price;
		
		public Book(int bno,String bname,String author,String lan,float price){
			this.bno = bno;
			this.bname = bname;
			this.author = author;
			this.language = lan;
			this.price = price;
		}
		public int getBno() {
			return bno;
		}
		public void setBno(int bno) {
			this.bno = bno;
		}
		public String getBname() {
			return bname;
		}
		public void setBname(String bname) {
			this.bname = bname;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
}
