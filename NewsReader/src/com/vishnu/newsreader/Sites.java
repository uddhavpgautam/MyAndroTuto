package com.vishnu.newsreader;

public class Sites {
String siteName;
String siteUrl;
public Sites(String siteName, String siteUrl){
	this.siteName = siteName;
	this.siteUrl = siteUrl;
}

public String getSiteName() {
	return siteName;
}
public void setSiteName(String siteName) {
	this.siteName = siteName;
}
public String getSiteUrl() {
	return siteUrl;
}
public void setSiteUrl(String siteUrl) {
	this.siteUrl = siteUrl;
}

}
