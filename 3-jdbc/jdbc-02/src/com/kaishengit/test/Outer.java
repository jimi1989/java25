package com.kaishengit.test;

public class Outer {

	private String name = "o_o";
	
	public void sayOuter() {
		
		class Inner {
			private String name = "^_^";
			
			public void sayInner() {
				System.out.println("inner...");
			}
			
		}
		
		Inner in = new Inner();
		in.sayInner();
		
		System.out.println("outer...");
	}

	public void sayHi(){
		
	}
	
}
