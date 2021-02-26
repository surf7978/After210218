package com.company.yedam.di;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV soundUp");
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV soundDown");
	}	
}
