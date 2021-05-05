package innerClasses;

public class Main {


    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.InnerClass innerClass = outer.new InnerClass();
        innerClass.seeOuter();
        outer.doStuff();
        outer.summation();
        Outer.StaticClass.staticMethod();
        Outer.StaticClass staticClass = new Outer.StaticClass();
        staticClass.nonStaticMethod();
    }


}

class Outer {

    private int x = 20;
    private static int aa = 22;

    /**
     * Nested Inner Class
     */
    class InnerClass {
        private int y = 10;
        private int x = 99;

        public void seeOuter() {
            System.out.println("Outer x: " + Outer.this.x + "\n" +
                    "Inner elements: " + y + "," + x);
        }
    }

    /**
     * Method Local Inner Class
     */
    public void doStuff() {
        int z = 10;
        class MethodInnerClass {
            private int p = 100;
            public void seeOuter() {
                System.out.println("Outer x: " + Outer.this.x + "\n" +
                        "method variables: " + z + " method inner class variables: "+ p);

                //z = 10; Illegal statement
            }
        }
        MethodInnerClass methodInnerClass = new MethodInnerClass();
        methodInnerClass.seeOuter();
    }

    /**
     * Static Inner class
     */
    static class StaticClass {
        private int s = 88;
        private static int ss = 11;

        public void nonStaticMethod() {
            System.out.println("Instance method of Static class");
            System.out.println("static class variable: " + s + "\n" +
                    "Outer class variables (static): " + aa);
        }

        public static void staticMethod() {
            System.out.println("Static method of Static class");
            System.out.println("static class variable: " + ss + "\n" +
                    "Outer class variables (static): " + aa);
        }
    }

    /**
     * Anonymous Inner class
     */
    Summable<Integer> summable = (t1, t2) -> t1 + t2;

    public void summation() {
        Integer sum = summable.sum(10, 20);
        System.out.println("Anonymous Inner class result:" + sum);
    }

}

@FunctionalInterface
interface Summable<T> {
    T sum(T t1, T t2);
}