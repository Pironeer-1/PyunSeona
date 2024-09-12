/*public class jumptojava_05 {
}
//05장 객체 지향 프로그래밍
//05-02 클래스
/*
* 객체와 인스턴스의 차이
Animal cat = new Animal()
‘cat은 객체’ / ‘cat은 Animal의 인스턴스’
*
class Animal {
    String name;
}

public class Sample {
    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.name   // 객체: cat, 객체변수: name
    }
}
* 메서드(method)는 클래스 내에 구현된 함수
*
ex)class Animal {
    String name;

    public void setName(String name) {
        this.name = name; // setName 메서드. cat.name = "boby";로 해석된다.
    }
}

public class Sample {
    public static void main(String[] args) {
        Animal cat = new Animal();
        System.out.println(cat.name);
    }
}
*
** 클래스에서 가장 중요한 부분은 객체 변수의 값이 독립적으로 유지된다
* */

//05-03 메서드 더 살펴보기
/*
**매개변수와 인수의 차이
* 매개변수 : 메서드에 전달된 입력값을 저장하는 변수
* 인수 : 메서드를 호출할 때 전달하는 입력값
*
public class Sample {
    int sum(int a, int b) {  // a, b 는 매개변수
        return a+b;
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        int c = sample.sum(3, 4);  // 3, 4는 인수

        System.out.println(c);
    }
}
** 메서드의 구조
리턴자료형 메서드명(입력자료형1 매개변수1, 입력자료형2 매개변수2, ...) {
    ...
    return 리턴값;  // 리턴자료형이 void 인 경우에는 return 문이 필요없다.
}
** 메서드의 종류 4가지
1. 입력값과 리턴값이 모두 있는 메서드 : ex)int result = sample.sum(3, 4); //리턴값_받을_변수 = 객체.메서드명(입력인수1, 입력인수2, ...)
2. 입력값이 없는 메서드 : 사용 방법 ex)String a = sample.say(); //리턴값_받을_변수 = 객체.메서드명()
3. 리턴값이 없는 메서드 :리턴값이 없는 메서드는 명시적으로 리턴 자료형 부분에 void라고 표기
    - System.out.println 문 : return값을 가지고 있지 않음. (리턴값은 오직 return 명령어로만 반환이 가능)
4. 입력값과 리턴값이 모두 없는 메서드 :객체.메서드명()으로 호출

** return의 또다른 쓰임
* public class Sample {
    void sayNick(String nick) {
        if ("바보".equals(nick)) {
            return; //메서드를 즉시 빠져나가는 역할(대신 리턴 자료형이 void인 자료만 가능!)
        }
        System.out.println("나의 별명은 "+nick+" 입니다.");
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.sayNick("야호");
        sample.sayNick("바보");  // 출력되지 않는다.
    }
}
** 메서드 내에서 선언된 변수의 효력 범위
* 메서드에서 쓰이는 매개 변수의 이름과 메서드 밖의 변수 이름이 같더라도 서로 전혀 영향을 주지 않는다.

* public class Sample {
    int varTest(int a) {
        a++;
        return a;
    }

    public static void main(String[] args) {
        int a = 1;
        Sample sample = new Sample();
        a = sample.varTest(a);
        System.out.println(a);
    }
}
//05-04 값에 의한 호출과 객체에 의한 호출
*메서드의 입력으로 객체를 전달하면 메서드가 입력받은 객체를 그대로 사용하기 때문에 메서드가 객체의 속성값을 변경하면 메서드 수행 후에도 객체의 변경된 속성값이 유지

//05-05 상속
*IS-A 관계란?
-자식 클래스의 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다. ex)Animal dog = new Dog();  // Dog is a Animal
-부모 클래스로 만들어진 객체를 자식 클래스의 자료형으로는 사용할 수 없다. Ex)Dog dog = new Animal();  // 컴파일 오류

*
* class Animal {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    void sleep() {
        System.out.println(this.name + " zzz");
    }
}

class HouseDog extends Dog {
    void sleep() {
        System.out.println(this.name + " zzz in house");
    }
}

public class Sample {
    public static void main(String[] args) {
        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        houseDog.sleep();  // happy zzz in house 출력
    }
}
* HouseDog 클래스에 Dog 클래스와 동일한 형태(즉, 입출력이 동일)의 sleep 메서드를 구현하면 HouseDog 클래스의 sleep 메서드가 Dog 클래스의 sleep 메서드보다 우선순위를 갖게 되어 HouseDog 클래스의 sleep 메서드가 호출되게 된다.
=> 메서드 오버라이딩 : 부모 클래스의 메서드를 자식 클래스가 동일한 형태로 또다시 구현하는 행위

* 메서드 오버로딩 : 입력 항목이 다른 경우 동일한 이름의 메서드를 만들 수 있다.
* 다중 상속 : 클래스가 동시에 하나 이상의 클래스를 상속받는 것
   - 자바에서는 다중 상속을 지원하지 않는다!
 */

//05-06 생성자
/*
생성자 : 메서드명이 클래스명과 동일하고 리턴 자료형을 정의하지 않는 메서드
**생성자 규칙
-클래스명과 메서드명이 같다.
-리턴 타입을 정의하지 않는다(void도 사용하지 않는다.).
ex)class HouseDog extends Dog {
    HouseDog(String name) { //HouseDog 생성자
        this.setName(name);
    }

** 만약 입력을 받아야하는 생성자일 경우 호출 시 문자열을 전달해야 한다.
ex)HouseDog(String name) {
    this.setName(name);
}
HouseDog dog = new HouseDog("happy"); // O, 맞는 문법.
HouseDog dog = new HouseDog(); // 컴파일 오류

**디폴트 생성자(default constructor) : 생성자의 입력 항목이 없고 생성자 내부에 아무 내용이 없는 생성자
class Dog extends Animal {
    Dog() {
    }
}
**생성자가 하나도 없다면 컴파일러는 자동으로 이와 같은 디폴트 생성자를 추가한다.
**사용자가 작성한 생성자가 하나라도 구현되어 있다면 컴파일러는 디폴트 생성자를 추가하지 않는다.

**생성자 오버로딩 : 입력 항목이 다른 생성자를 여러 개 만들 수 있는 것.
class HouseDog extends Dog {
    HouseDog(String name) { //HouseDog happy = new HouseDog("happy"); 이때 호출됨
        this.setName(name);
    }

    HouseDog(int type) { //HouseDog yorkshire = new HouseDog(1); 이때 호출됨
        if (type == 1) {
            this.setName("yorkshire");
        } else if (type == 2) {
            this.setName("bulldog");
        }
    }
}
* */

//
/*
인터페이스가 왜 필요한가?
-클래스가 추가될 때마다 메서드를 추가해야해야하므로 이때 사용하면 유용
-클래스와 마찬가지로 Predator.java와 같은 단독 파일로 저장하는 것이 일반적

ex)interface Predator {
}
class Tiger extends Animal implements Predator {
}

class Lion extends Animal implements Predator {
}

class ZooKeeper {
    void feed(Predator predator) { //tiger, lion이 Predator에 속해있으니 가능한 일
        System.out.println("feed apple");
    }
}

tiger: Tiger 클래스의 객체이자 Predator 인터페이스의 객체
lion: Lion 클래스의 객체이자 Predator 인터페이스의 객체


** 동물별로 문자열 출력 다르게 하는 법
-인터페이스는 인터페이스의 메서드를 반드시 구현해야 하는 강제성을 갖는다는 점이 중요!
interface Predator {
    String getFood(); //인터페이스를 implements한 클래스들이 강제적으로 구현해야 하는 규칙이므로 Tiger, Lion 클래스에 getFood 메서드를 구현해야 함.
}
class Tiger extends Animal implements Predator {
    public String getFood() {
        return "apple";
    }
}

class Lion extends Animal implements Predator {
    public String getFood() {
        return "banana";
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed "+predator.getFood());
    }
}

**디폴트 메서드
-메서드명 가장 앞에 default라고 표기
-오버라이딩이 가능
interface Predator {
    String getFood();

    default void printFood() { // 디폴트 메서드,실제 클래스에 printFood 메서드를 구현하지 않아도 사용가능!
        System.out.printf("my food is %s\n", getFood());
    }
}
* */

//05-08 다형성(polymorphism)
/*
-instanceof : 어떤 객체가 특정 클래스의 객체인지를 조사할 때 사용되는 자바의 내장 명령어
class Bouncer {
    void barkAnimal(Animal animal) {
        if (animal instanceof Tiger) { //animal 객체는 Tiger 클래스로 만들어진 객체인가?
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        }
    }
}

=> 동물 클래스가 추가될 때마다 코드를 추가해야하므로 불편.

interface Predator {
    (... 생략 ...)
}

interface Barkable {
    void bark();
}
class Tiger extends Animal implements Predator, Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}
class Lion extends Animal implements Predator, Barkable {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}
class Bouncer {
    void barkAnimal(Barkable animal) {  // Animal 대신 Barkable을 사용
        animal.bark();
    }
}

=> 코드가 더욱 깔끔해짐 .하나의 객체가 여러 개의 자료형 타입을 가질 수 있는 것을 객체 지향 세계에서는 다형성이라고 함.
-Predator로 선언된 predator 객체와 Barkable로 선언된 barkable 객체는 사용할 수 있는 메서드가 서로 다르다
 */

//05-09 추상 클래스(abstract class)
/*
-class, 메서드 앞에 abstract를 표기
-단독으로 객체를 생성할 수 없다. 반드시 추상 클래스를 상속한 실제 클래스를 통해서만 객체를 생성할 수 있다.
-인터페이스의 디폴트 메서드는 더 이상 사용할 수 없으므로 default 키워드를 삭제하여 일반 메서드로 변경
* */
