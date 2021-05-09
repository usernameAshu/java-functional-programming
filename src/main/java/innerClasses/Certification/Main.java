package innerClasses.Certification;

public class Main {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.test();
    }
}

class Boo {
    String str = "Ashu";
    Boo() {

    }

    Boo(String s) {

    }

    public void zoo() {
        System.out.println("Boo.zoo");
    }

}

class Bar extends Boo {
    Bar() {
    }

    Bar(String s) {
        super(s);
    }
    public void zoo() {
        System.out.println("Bar.zoo");
    }

    public void test() {
        Boo f = new Bar() {
            String s = "Ashutosh";
            public void zoo() {
                System.out.println("Anonymous Bar.zoo");
            }
        };
        f.zoo();
    }

}

/*class foo {
    Boo f = new Bar() {
        String s = "Ashutosh";
        public void zoo() {
            System.out.println("Anonymous Bar.zoo");
        }
    };
    void test() {
        f.zoo();
    }
}*/
