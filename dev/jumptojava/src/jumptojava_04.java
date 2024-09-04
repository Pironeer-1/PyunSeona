public class jumptojava_04 {
}

//04장 제어문 이해하기
//04-01 if문
/*
* if (조건문) { //조건이 참일때 실행
    <수행할 문장1>;
    <수행할 문장2>;
    ...
} else { // 조건이 거짓일때 실행
    <수행할 문장A>;
    <수행할 문장B>;
    ...

//비교연산자 : true or false를 return
x < y : x가 y보다 작다
x > y : x가 y보다 크다
x == y : x와 y가 같다
x != y : x와 y가 같지 않다
x >= y : x가 y보다 크거나 같다
x <= y : x가 y보다 작거나 같다
*
*
//and, or, not 연산자
x && y : x와 y 모두 참이어야 참이다
x || y : x와 y 둘 중 적어도 하나가 참이면 참이다
!x : x가 거짓이면 참이다
*
//contains : List 자료형에 해당 아이템이 있는지 조사하는 역할. 만약 있으면 참(true) 출력

ex)
* if (pocket.contains("money")) { //만약 money가 포함되어있을 경우
    System.out.println("택시를 타고 가라");
}else if(hasCard) { //이전 조건문이 거짓일 경우.(만약 money가 포함되어있지 않을 경우)
    System.out.println("택시를 타고 가라");
}else { // 위 조건문이 거짓이면
    System.out.println("걸어가라");
}
* */

//04-02 switch/case 문
/*
* 형식
 switch(입력변수) { //case에 일치하는 값이 있을 경우 그 아래 있는 문을 실행
    case 입력값1: ...
         break;
    case 입력값2: ...
         break;
    ...
    default: ... //아무것도 해당되지 않을 경우 default: 문장이 수행
         break;
}
*
* switch/case 문은 if 문으로 변경이 가능하지만 if 문으로 작성된 모든 코드를 switch 문으로 변경할 수는 없다.
* */

//04-03 while 문
/* 형식
while (조건문) { //조건문이 참인 동안 while 문이 수행할 문장들을 반복하여 수행
    <수행할 문장1>;
    <수행할 문장2>;
    <수행할 문장3>;
    ...
}

**무한루프
while (true) {
    <수행할 문장1>;
    <수행할 문장2>;
    ...
}

**while 문을 강제로 멈춰야 할 때 : break 사용
**어떤 조건을 검사해서 참이 아닌 경우 while 문의 맨 처음, 즉 조건문으로 돌아가게 하고 싶을 때 : continue 사용
*/

//04-04 for 문
/*
* 형식
String[] numbers = {"one", "two", "three"};
for(int i=0; i<numbers.length; i++) { //for (초기치; 조건문; 증가치)
    System.out.println(numbers[i]);
}
* 이중 for 문도 사용 가능 ex)구구단
* */

//04-05 for each 문
/* for each 문은 J2SE 5.0부터 추가된 문법
* 형식
String[] numbers = {"one", "two", "three"};
for(String number: numbers) { //for (type 변수명: iterate)
    System.out.println(number);
}
**iterate에 사용할 수 있는 자료형은 루프를 돌릴 수 있는 자료형(배열이나 ArrayList 등)만 가능
**한 단계씩 순차적으로 반복할 때만 사용이 가능하다는 제약
* */