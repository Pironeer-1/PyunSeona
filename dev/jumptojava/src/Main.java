//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Person{
    public String name;
    public int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void greet(){
        System.out.println("저는, " + this.name + "이고" + "!");
    }
}

class Student extends Person{
    public Student(String name, int age, String school){
        super(name, age); // person에서 받아옴
        this.school = school;
    }
    public void school() {
        System.out.println("제가 다니는 학교는 " + this.school + "입니다.");
    }
    @Override
    public void greet() {
        System.out.println("안녕하세요 학생입니다.");
    }
}

class Worker extends Person{
    public String company;

    public Worker(String name, int age, String company){
        super(name, age);
        this.company = company;
    }

    public void company(){
        System.out.println("제가 일하는 회사는 " + this.company + "입니다.");
    }
    @Override
    public void greet() {
        System.out.println("안녕하세요 직장인입니다.");
    }
}

class WorkingStudent extends Student,Worker{
    public WorkingStudent(String name, int age, String school, String company) {
        // 어느 생성자를 사용해야 되는지 모호함
        super(name, age, school); ??
        super(name, age, company); ??
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person("jg", 20);
        System.out.println(person.name);
    }
}