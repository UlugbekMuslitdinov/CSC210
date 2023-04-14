import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashMapTest {
	@Test
	public void testClear() {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		map.put(1, 2);
		map.clear();
		assertEquals(0, map.size());
	}

	@Test
	public void testContainsKey() {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		map.put(1, 2);
		assertTrue(map.containsKey(1));
		assertFalse(map.containsKey(2));
	}

	@Test
	public void testContainsValue() {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		map.put(1, 2);
		assertTrue(map.containsValue(2));
		assertFalse(map.containsValue(1));
	}

	@Test
	public void testGet() {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		map.put(1, 2);
		assertNull(map.get(3));
	}

	@Test
	public void testIsEmpty() {
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		assertTrue(map.isEmpty());
		map.put(1, 2);
		assertFalse(map.isEmpty());
	}
}
