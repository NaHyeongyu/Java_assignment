package ch01;

import java.security.PublicKey;

public class MobileTest {
	public static void main(String[] args) {
		Mobile ltab = new Ltab("Ltab", 500, "ABC-01");
		Mobile otab = new Otab("Otab", 1000, "XYZ-20");
		
		printTitle();
		printMobile(ltab);
		printMobile(otab);
		
		ltab.charge(10);
		otab.charge(10);
		System.out.println("");
		System.out.println("[10분 충전]");
		printTitle();
		printMobile(ltab);
		printMobile(otab);
		
		ltab.operate(5);
		otab.operate(5);
		System.out.println("");
		System.out.println("[5분 통화]");
		printTitle();
		printMobile(ltab);
		printMobile(otab);
		
	}
	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.mobileName + "\t" + mobile.batterySize + "\t" + mobile.osType);

	}
	public static void printTitle() {
		System.out.println("Mobile" + "\t" + "Battery" + "\t" + "OS");
		System.out.println("----------------------");

	}
}

abstract class Mobile{
	 String mobileName;
	 int batterySize;
	 String osType;
	 
	Mobile() {

	}
	
	Mobile(String name, int size, String type){
		this.mobileName = name;
		this.batterySize = size;
		this.osType = type;
	}
	
	abstract void  operate(int time);
	
	abstract void  charge(int time);
	
}

class Ltab extends Mobile{

	Ltab(){
		
	}
	
	
	Ltab(String name, int size, String type){
		super(name, size, type);
	}
	@Override
	public void charge(int time) {
		batterySize += time*10;
	}
	@Override
	public void operate(int time) {
		batterySize -= time*10;
	}
	
}

class Otab extends Mobile{
	
	Otab(){
		
	}

	Otab(String name, int size, String type){
		super(name, size, type);
	}
	@Override
	public void charge(int time) {
		batterySize += time*8;
	}
	@Override
	public void operate(int time) {
		batterySize -= time*12;
	}
	
}