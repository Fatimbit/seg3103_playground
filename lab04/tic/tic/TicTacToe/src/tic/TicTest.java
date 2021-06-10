package tic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {
	Tic x=new Tic();
	
	/*
	@Test
	void test_emptyboard() {
		/*
		 _ _ _
		 _ _ _
		 _ _ _
		 */     /*
	/*	assertEquals("_", x.emptyboard(1,1));
	} 
	*/
	
	@Test
	void test_xPlaced() {
		assertEquals("X", x.placeX(1,1));
	}

}
