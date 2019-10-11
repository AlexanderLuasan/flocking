package boid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vector.Vector;

class BoidJunitTest {

	@Test
	void test() {
		Bird a = new Bird(10,10,new Vector(1,1));
	}

}
