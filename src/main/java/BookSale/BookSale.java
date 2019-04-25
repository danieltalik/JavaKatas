package BookSale;

public class BookSale {
    short[] bookCart;
    double cost;

    public BookSale(short[] bookCart) {
        this.bookCart = bookCart;
        bookCart[0] = 0;
        bookCart[1] = 0;
        bookCart[2] = 0;
        bookCart[3] = 0;
        bookCart[4] = 0;
    }

    public double buyOneBook(int bookNumber) {
        cost = 8.00;
        bookCart[bookNumber - 1] += 1;
        return cost;
    }

    public double buyTwoBooks(int bookOne, int bookTwo) {
        cost = 8.00;
        bookCart[bookOne - 1] += 1;
        bookCart[bookTwo - 1] += 1;

        if (bookOne > bookTwo || bookOne < bookTwo) {
            double discount = (cost * 2) / 10;
            cost = (cost * 2) - discount;
        } else cost += cost;

        return cost;
    }

    public double buyThreeBooks() {
        cost = 8.00;
        return cost;
    }

    public double buyFourBooks() {
        cost = 8.00;
        return cost;
    }

    public double buyFiveBooks() {
        cost = 8.00;
        return cost;
    }
}
