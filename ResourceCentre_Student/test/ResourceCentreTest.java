import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {
		//fail("Not yet implemented");
		
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
		
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
		
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
				
		
	}
	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		assertNotNull("Test is there is valid Chromebook arraylist to add to", chromebookList);
		
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		
		assertEquals("Check that ViewAllChromebookList", testOutput, allChromebook);
		
	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
//		assertNull("Test if there is no valid Camcorder arraylist to add to", camcorderList);
		
//		assertTrue(camcorderList.isEmpty());
		
//		assertFalse(camcorderList.isEmpty());
		ResourceCentre.addCamcorder(camcorderList, cc1);
//		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if the Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		ResourceCentre.doLoanCamcorder(camcorderList, cc1.getAssetTag(), cc1.getDueDate());
		camcorderList.remove(cc1);
		assertEquals("Test if the Camcorder arraylist is reduce by 1?", 0, camcorderList.size());
		
		assertFalse(cc1.getIsAvailable());
		
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
//		assertNull("Test if there is no valid Chromebook arraylist to add to", chromebookList);
		
//		assertTrue(chromebookList.isEmpty());
		
//		assertFalse(chromebookList.isEmpty());
		ResourceCentre.addChromebook(chromebookList, cb1);
//		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if the Chromebook arraylist size is 1?", 1, chromebookList.size());
		
		ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), cb1.getDueDate());
		chromebookList.remove(cb1);
		assertEquals("Test if the Chromebook arraylist is reduce by 1?", 0, chromebookList.size());
		
		assertFalse(cb1.getIsAvailable());
		
		
	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
//		assertNull("Test if there is no valid Camcorder arraylist to add to", camcorderList);
		
//		assertTrue(camcorderList.isEmpty());
		
//		assertFalse(camcorderList.isEmpty());
//		ResourceCentre.addCamcorder(camcorderList, cc1);
//		assertEquals("Test if the Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		ResourceCentre.doReturnCamcorder(camcorderList, cc1.getAssetTag());
		camcorderList.add(cc1);
		assertEquals("Test if the Camcorder arraylist is add by 1?", 1, camcorderList.size());
		
		assertTrue(cc1.getIsAvailable());
		
		
	}
	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
//		assertNull("Test if there is no valid Chromebook arraylist to add to", chromebookList);
		
//		assertTrue(chromebookList.isEmpty());
		
//		assertFalse(chromebookList.isEmpty());
//		ResourceCentre.addChromebook(chromebookList, cb1);
//		assertEquals("Test if the Chromebook arraylist size is 1?", 1, chromebookList.size());
		
		ResourceCentre.doReturnChromebook(chromebookList, cb1.getAssetTag());
		chromebookList.add(cb1);
		assertEquals("Test if the Chromebook arraylist is add by 1?", 1, chromebookList.size());
		
		assertTrue(cb1.getIsAvailable());
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
