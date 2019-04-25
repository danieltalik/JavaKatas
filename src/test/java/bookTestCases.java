import org.junit.Test;
import junit.framework.Assert;
import BookSale.BookSale;
import java.math.BigDecimal;


public class bookTestCases {
    short[]bookCart = new short[5];
    BookSale sale = new BookSale(bookCart);
    double cost;

    @Test
    public void oneBook(){
        int bookNumber = 1;
        cost = sale.buyOneBook(bookNumber);
        Assert.assertEquals(8.0,cost);
    }

    @Test
    public void twoBooks(){
        int bookOne = 1;
        int bookTwo = 1;
        cost = sale.buyTwoBooks(bookOne,bookTwo);
        Assert.assertEquals(16.0,cost);
        bookTwo = 3;
        cost = sale.buyTwoBooks(bookOne,bookTwo);
        Assert.assertEquals(14.4,cost);
    }

    @Test
    public void threeBooks(){
        cost = sale.buyThreeBooks();
    }

    @Test
    public void fourBooks(){
        cost = sale.buyFourBooks();
    }
    @Test
    public void fiveBooks(){
        cost = sale.buyFiveBooks();
    }
}
