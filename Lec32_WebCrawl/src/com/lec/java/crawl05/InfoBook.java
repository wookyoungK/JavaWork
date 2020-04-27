package com.lec.java.crawl05;

public class InfoBook {
	private String bookTitle; // 책제목
	private double price;// 책가격
	private String url; // 상세페이지 url
	private String imgurl; // 썸네일 url

	public InfoBook() {
		super();
	}

	public InfoBook(String bookTitle, double price, String url, String imgurl) {
		super();
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgurl = imgurl;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return bookTitle + ":" +price + "원, URL: "+url+", img: "+ imgurl;
	}
}
