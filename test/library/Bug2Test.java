package library;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import library.borrowitem.BorrowItemControl;
import library.borrowitem.BorrowItemUI;
import library.entities.Calendar;
import library.entities.Item;
import library.entities.ItemType;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Patron;
import library.returnItem.ReturnItemControl;
import library.returnItem.ReturnItemUI;

class Bug2Test {
	static Patron patron;
	static Item item;
	static Library library;
	static Loan loan;
	static Calendar calendar;
	static SimpleDateFormat simpleDateFormat;
	static ReturnItemControl control;

	@Mock ReturnItemUI uiMock;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		// assert
		calendar = Calendar.getInstance();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		library = Library.getInstance();
		
		System.out.println(simpleDateFormat.format(calendar.getDate()));
		
		patron = library.addPatron("j", "t", "jt", 1);
		item = library.addItem("a", "t", "1", ItemType.BOOK);
		item = library.addItem("d", "v", "2", ItemType.DVD);
		item = library.addItem("v", "h", "3", ItemType.VHS);
		item = library.addItem("c", "d", "4", ItemType.CD);
		item = library.addItem("a", "c", "5", ItemType.CASSETTE);
		
//		Main.main(null);
		new BorrowItemUI(new BorrowItemControl()).run();
		
		// act
		System.out.println("Item patron: " + library.listPatrons());
		System.out.println("Item list: " + library.listItems());
		
	}

}
