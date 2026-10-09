public class Main {

    static class CollegeStudent extends Student {

        CollegeStudent() {
            super("Pradeep", 101);
        }

        void attendClass() {
            System.out.println(this.name + " is attending class");
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student();

        Student s2 = new Student("Rahul");

        Student s3 = new Student("Aman", 102);

        CollegeStudent s4 = new CollegeStudent();

        s4.study();
        s4.attendClass();
    }
}