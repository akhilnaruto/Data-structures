package BinaryTrees;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {

	static Tree tree;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 LogHelper logHelper = new LogHelper(false);
		 tree = new Tree(logHelper);
		 tree.insertNode(1, 1);	 
	}

	
	@Test
	public void testInsert() {
		// insert nodes
		tree.insertNode(12, 12.0);
		tree.insertNode(7, 7.0);
		tree.insertNode(5, 5.0);
		
		// validate inserted nodes
		
		Node node = tree.findNode(5);
		assertEquals(node.iData, 5.0, 0);
		assertEquals(node.fData, 5.0, 0);
		
		// clear tree;
		tree.emptyTree();
	}
	
	@Test
	public void testFindInvalidNode(){
		tree.insertNode(12, 12.0);
		tree.insertNode(7, 7.0);
		tree.insertNode(5, 5.0);
		
		Node node = tree.findNode(15);
		assertNull(node);
	}
	
	@Test
	public void testFindNode(){
		//set logger
		 LogHelper logHelper = new LogHelper(true);
		 tree.setLogHelper(logHelper);
		tree.insertNode(12, 12.0);
		tree.insertNode(7, 7.0);
		tree.insertNode(5, 5.0);
		
		Node node = tree.findNode(7);
		assertEquals(node.fData, 7.0, 0);
	}

}
