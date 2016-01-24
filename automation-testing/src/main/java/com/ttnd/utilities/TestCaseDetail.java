package com.ttnd.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCaseDetail{

	private String testcaseName;
//	private TestData gTestData;
	private Map<String, List<String>> testData;
	
	private List<String> getTestDataKeys() {
		 return (List<String>) testData.keySet();
	}
	
	public String getTestcaseName() {
		return testcaseName;
	}


	public void setTestcaseName(String testcaseName) {
		this.testcaseName = testcaseName;
	}

	public Map<String, List<String>> getTestData() {
		return testData;
	}


	public void setTestData(Map<String, List<String>> testData) {
		this.testData = testData;
	}


	public void put(String testCaseName2, Map<String, List<String>> testData2) {
		this.testcaseName = testCaseName2;
		this.testData = testData2;
	}

	public Set<String> getKeys() {
		return testData.keySet();
	}
	public Collection<List<String>> getValues() {
		return testData.values();
	}
	
	public int getTestDataSize() {
		//Implement
		if(testData.isEmpty()){
			return 0;
		}
		ArrayList<Integer> dataSize = new ArrayList<Integer>();
		List<List<String>> l = new ArrayList<>(testData.values());
		
		for(List<String> a : l){
			int size = 0;
			Iterator<String> iter1 = a.iterator();

			while(iter1.hasNext()){
//				System.out.println(a.get(size));
				size++;
				iter1.next();
			}dataSize.add(size-1);
		}
		
		return Collections.max(dataSize);
//		Alternatively
//		Collections.sort(arrayList); // Sort the arraylist
//		arrayList.get(arrayList.size() - 1); //gets the last item, largest for an ascending sort
	}
	
	
	public Map<String, String> getTestDataFirst(){
		Map<String,String> newMap =new HashMap<String,String>();
		
		List<List<String>> l = new ArrayList<>(testData.values());
		
		for (Map.Entry<String, List<String>> entry : testData.entrySet()) {
		       try{
		            newMap.put(entry.getKey(), (String) entry.getValue().toArray()[0]);
		          }catch(ClassCastException cce){
		          }
		 }
		return newMap;
	}
	
	public Map<String, String> getTestDataAll(){
		Map<String,String> newMap =new HashMap<String,String>();
		
		List<List<String>> l = new ArrayList<>(testData.values());
		
		for (Map.Entry<String, List<String>> entry : testData.entrySet()) {
		       try{
		            newMap.put(entry.getKey(), (String) entry.getValue().toArray()[0]);
		          }catch(ClassCastException cce){
		           // TODO: handle exception
		          }
		 }
		return newMap;
	}
	
}
