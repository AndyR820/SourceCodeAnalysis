package aop.cglib;

/**
 * 没有实现接口的实现类
 */
public class BookFacadeNoImpl {

    public void addBook() {
        System.out.println("增加图书的普通方法。。。");
    }

    public void deleteBook() {
        System.out.println("删除图书的普通方法。。。");
    }
}
