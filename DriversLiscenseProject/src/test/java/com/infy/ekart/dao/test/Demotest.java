package com.infy.ekart.dao.test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class Demotest {
		String a;
		@BeforeClass
		public void init(){
			a = "one";
		}
		@Test
		public void test1(){
			Assert.assertEquals("one", a);
		}
	}