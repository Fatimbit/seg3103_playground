package tic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {
	tic_java x=new tic_java();
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
		x.makeBoard(7, 4);
		assertEquals("X", x.placeX(1,1));
	}

}
