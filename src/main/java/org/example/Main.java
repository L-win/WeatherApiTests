package org.example;

import org.testng.annotations.Test;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
	}

	@Test(priority=1)
	public static void testOne(){ }

}