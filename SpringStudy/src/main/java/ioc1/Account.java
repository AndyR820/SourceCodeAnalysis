package ioc1;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Account {

    private String name;
    private String pwd;
    private List<String> citys;
    private Set<String> friends;
    private Map<Integer,String> books;

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public List <String> getCitys() {
        return citys;
    }

    public Set <String> getFriends() {
        return friends;
    }

    public Map <Integer, String> getBooks() {
        return books;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setCitys(List<String> citys) {
        this.citys = citys;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public void setBooks(Map<Integer, String> books) {
        this.books = books;
    }
}
