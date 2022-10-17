package library.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import library.returnItem.ReturnItemControl;
import library.returnItem.ReturnItemUI;

class LibraryTest {
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
		loan = library.issueLoan(item, patron);
		System.out.println("Loan before increment: \n" + library.listCurrentLoans());
		
		calendar.incrementDate(4);
		library.updateCurrentLoanStatus();
		System.out.println(simpleDateFormat.format(calendar.getDate()));
		System.out.println("Loan after increment: \n" + library.listCurrentLoans());
		
//				new ReturnItemUI(new ReturnItemControl()).run();
		control = new ReturnItemControl();
		uiMock = new ReturnItemUI(control);
//				control.setUi(uiMock);
		control.itemScanned(1);
		control.dischargeLoan(false);
		System.out.println("Fines owed: " + patron.finesOwed());
		
		// act
		System.out.println("Act: " + library.listCurrentLoans());
		System.out.println(library.listPatrons());
	}

}
