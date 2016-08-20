package com.chinaway.tms.basic.model;

import java.io.Serializable;

import com.chinaway.tms.utils.json.JsonUtil;

public class Car implements Serializable {
	
	
	private String vehicleModelName="Q5062.6T4MRCA";//    车型名称  车系名称+年代款+排量+变速箱类型/驱动方式+型号名称
	
	public String getVehicleModelName() {
		return vehicleModelName;
	}
	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}
	
	public static void main(String[] args){
		Car car = new Car();
		System.out.println(JsonUtil.obj2JsonStr(car));
	}
}