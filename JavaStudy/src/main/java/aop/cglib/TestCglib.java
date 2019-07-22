package aop.cglib;

public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeNoImpl bookFacade = (BookFacadeNoImpl) cglib.getInstance(new BookFacadeNoImpl());
        bookFacade.addBook();
        bookFacade.deleteBook();
    }
}
