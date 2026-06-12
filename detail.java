class J {
    String name = "veera";
    int id = 101;
    String dept = "aids";

    void mm() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + dept);
    }
}

public class detail {
    public static void main(String[] args) {
        J obj1 = new J();
        obj1.mm();
    }
}