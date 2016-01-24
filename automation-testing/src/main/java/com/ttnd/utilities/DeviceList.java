package com.ttnd.utilities;

import java.util.ArrayList;
import java.util.List;

public class DeviceList {

	List<String> deviceList;
	private static int i;
	private static DeviceList instance;

	private DeviceList() {
		deviceList = new ArrayList<>();
		deviceList.add("SM-G530H");
		//deviceList.add("SM-G7102");
	}

	public static synchronized DeviceList getInstance(){
		if(instance == null){
			instance = new DeviceList();
		}return instance;
	}

	public List<String> getDeviceList() {
		return deviceList;
	}

	public String getDevice() {
		System.out.println(deviceList.size());
		String strDevice = deviceList.get(0);
//		deviceList.remove(0);
		System.out.println(strDevice);
		return strDevice;
			
	}
}
