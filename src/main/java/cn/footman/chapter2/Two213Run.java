package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-11 17:21
 */
public class Two213Run {
    public static void main(String[] args) {
        Two213PublicClass two213PublicClass = new Two213PublicClass();
        two213PublicClass.setUsername("usernameValue");
        two213PublicClass.setPassword("passwordValue");
        System.out.println(two213PublicClass.getUsername() + " " + two213PublicClass.getPassword());
        Two213PublicClass.PrivateClass privateClass = two213PublicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}
