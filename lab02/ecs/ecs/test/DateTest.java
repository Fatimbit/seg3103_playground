import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_sample() {
    Date d = new Date(2020,5,3);
    assertEquals(new Date(2020,5,4), d.nextDate());
  }

  @Test
  void nextDate_TC1() {
    Date d = new Date(1700,6,20);
    assertEquals(new Date(1700,6,21), d.nextDate());
  }

  @Test
  void nextDate_TC2() {
    Date d = new Date(2005,4,15);
    assertEquals(new Date(2005,4,16), d.nextDate());
  }
  @Test
  void nextDate_TC3() {
    Date d = new Date(1901,7,20);
    assertEquals(new Date(1901,7,21), d.nextDate());
  }
  @Test
  void nextDate_TC4() {
    Date d = new Date(3456,3,27);
    assertEquals(new Date(3456,3,28), d.nextDate());
  }
  @Test
  void nextDate_TC5() {
    Date d = new Date(1500,2,17);
    assertEquals(new Date(1500,2,18), d.nextDate());
  }

  @Test
  void nextDate_TC6() {
    Date d = new Date(1700,6,29);
    assertEquals(new Date(1700,6,30), d.nextDate());
  }
  @Test
  void nextDate_TC7() {
    Date d = new Date(1800,11,29);
    assertEquals(new Date(1800,11,30), d.nextDate());
  }
  @Test
  void nextDate_TC8() {
    Date d = new Date(3453,1,30);
    assertEquals(new Date(3453,1,31), d.nextDate());
  }
  @Test
  void nextDate_TC9() {
    Date d = new Date(444,2,29);
    assertEquals(new Date(444,3,1), d.nextDate());
  }
  @Test
  void nextDate_TC10() {
    Date d = new Date(2005,4,30);
    assertEquals(new Date(2005,5,1), d.nextDate());
  }
  @Test
  void nextDate_TC11() {
    Date d = new Date(3453,1,30);
    assertEquals(new Date(3453,1,31), d.nextDate());
  }
  @Test
  void nextDate_TC12() {
    Date d = new Date(3456,3,30);
    assertEquals(new Date(3456,3,31), d.nextDate());
  }
  @Test
  void nextDate_TC13() {
    Date d = new Date(1901,7,31);
    assertEquals(new Date(1901,8,1), d.nextDate());
  }
  @Test
  void nextDate_TC14() {
    Date d = new Date(3453,1,31);
    assertEquals(new Date(3453,2,1), d.nextDate());
  }
  @Test
  void nextDate_TC15() {
    Date d = new Date(3456,12,31);
    assertEquals(new Date(3457,1,1), d.nextDate());
  }
  @Test
  void nextDate_TC16() {
    Date d = new Date(1500,2,31);
    assertEquals(IllegalArgumentException.class, d.nextDate());
  }
  @Test
  void nextDate_TC17() {
    Date d = new Date(1500,2,29);
    assertEquals(IllegalArgumentException.class, d.nextDate());
  }
  @Test
  void nextDate_TC18() {
    Date d = new Date(-1,10,20);
    assertEquals(IllegalArgumentException.class, d.nextDate());
  }


}
