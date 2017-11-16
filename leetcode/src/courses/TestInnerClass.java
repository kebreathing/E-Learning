package courses;

public class TestInnerClass {

    class InnerClass{
        public void hello(){
            System.out.println("InnerClass hello");
        }
    }

    public TestInnerClass(String s1,String s2){
        System.out.println("TestInnerClass");
    }



    public static void main(String[] args){
        InnerClass tic = new TestInnerClass("a","b").new InnerClass();
    }
}
