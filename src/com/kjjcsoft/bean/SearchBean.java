/**
 * 
 */
package com.kjjcsoft.bean;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author Seekraw
 *
 */
public class SearchBean {
	private String searchQuery;
	private String customerListSearch;
	public String getSearchQuery() {
		return searchQuery;
	}
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	
	public String getCustomerListSearch() {
		return customerListSearch;
	}
	public void setCustomerListSearch(String customerListSearch) {
		this.customerListSearch = customerListSearch;
	}
	public int validate(){
		int retVal;
		searchQuery = searchQuery.replaceAll("\\s+", " ").trim();
		searchQuery = WordUtils.capitalizeFully(searchQuery);
		if (searchQuery.matches("\\d+")) {
			retVal=1;
		} else if(searchQuery.matches("\\w*\\s.*")){
			retVal= 2;
		} else if(searchQuery.length()<1){
			retVal= 3;
		} else {
			retVal = 0;
		}
		return retVal;
	}
	public int validateListSearch(){
		int retVal;
		customerListSearch = customerListSearch.replaceAll("\\s+", " ");
		customerListSearch = WordUtils.capitalizeFully(customerListSearch);
		if (customerListSearch.matches("\\d+")) {
			retVal =1;
		} else if (customerListSearch.length()<1) {
			retVal = 2;
		} else{
			retVal = 0;
		}
		return retVal;
	}
}
