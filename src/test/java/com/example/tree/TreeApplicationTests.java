package com.example.tree;

import com.example.tree.Model.TreeNode;
import com.example.tree.Service.TreeService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeApplicationTests {

	@Test
	void testInsertAndBuildTree() {
		TreeService service = new TreeService();
		int[] nums = {5, 3, 7};
		TreeNode root = service.buildTree(nums);
		assertNotNull(root);
		assertEquals(5, root.val);
		assertEquals(3, root.left.val);
		assertEquals(7, root.right.val);
	}

	@Test
	void testJsonSerialization() throws Exception {
		TreeService service = new TreeService();
		TreeNode root = service.buildTree(new int[]{1, 2});
		String json = service.toJson(root);
		assertTrue(json.contains("1"));
		assertTrue(json.contains("2"));
	}

	@Test
	void testEmptyTree() throws Exception {
		TreeService service = new TreeService();
		TreeNode root = service.buildTree(new int[]{});
		assertNull(root);
	}

}
