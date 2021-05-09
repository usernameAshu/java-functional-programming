package innerClasses.Certification;

import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        boolean flag = o.equals("Ashutosh");
        System.out.println(flag);
    }
}

class HorseTest {
    public static void main(String[] args) {
        class Horse {
            String s;

            public Horse(String s) {
                this.s = s;
            }
        }
        Object horse = new Horse("Zippo");
        System.out.println();

    }
}

abstract class AbstractTest {
    int num = 9;

    public int getNum() {
        return num;
    }

}

abstract class AbstractTest2 {
    int num = 90;

    public int getNum() {
        return num;
    }
}

class Test3 {
    public static void main(String[] args) {
        AbstractTest test1 = new AbstractTest() {
            public int getNum() {
                return 57;
            }
        };
        AbstractTest2 test2 = new AbstractTest2() {
            @Override
            public int getNum() {
                return super.getNum();
            }
        };

        System.out.println(test1.getNum() + "   " + test2.getNum());


    }

    public void instanceMethod() {
        new MethodLocal().go();
        class MethodLocal {
            void go() {
                System.out.println("MethodLocal.go");
            }
        }
        new MethodLocal().go();
    }

    class MethodLocal {
        void go() {
            System.out.println("Inner class MethodLocal.go");
        }
    }

}

class Pockets {
    public static void main(String[] args) {
      //  Sorter sorter = new Sorter();  inner class are instance members of the class
    }
    class Sorter implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}


