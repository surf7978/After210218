package com.company.yedam.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV {
	
	@Autowired 
	//@Qualifier("sony") //@Qualifier쓰면 내가 원하는 @Component선택가능
	@Qualifier("appleSpeaker") //따로 대명사 지정안하면 앞글자 소문자로 디폴트값 되있음
	Speaker speaker;
	
	
	
	//@Autowired 해놓으면 이거 지워도 됨
//	public LgTV() {}
//	
//	public LgTV(Speaker speaker) {
//		this.speaker = speaker;
//	}
//	
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}

	
	
	
	

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
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
