//03장 자바의 기초 - 자료형
/*
public class jumptojava_03 {
}

//03-01 숫자
/*
정수 : int, long / long 자료형 변수에 값을 대입할 때 접미사로 L 자를 붙여 주어야 한다!(컴파일 오류 가능성)
* int	-2147483648 ~ 2147483647
long	-9223372036854775808 ~ 9223372036854775807

실수 : float, double
기본값이 double이므로 float 변수에 값을 대입할 때에는 3.14F처럼 끝에 접미사로 F 자를 꼭 붙여 주어야 한다.
ex) float pi = 3.14F;

**8진수와 16진수는 int 자료형을 사용

증감연산자 핵심
i++ : 값을 참조한 후에 증가
++i : 값을 참조하기 전에 증가

* */

//03-02 불
/*
boolean isSuccess = true;
boolean isTest = false;

연산 자체를 대입할 수 있음 ex)boolean isTall = height > base;
 * */

//03-03 문자
/*
char 자료형 사용
ex)char a1 = 'a';
문자, 아스키코드, 유니코드로도 문자 자체를 표현 가능하다!(결과값이 문자로 동일함)
* */

//03-04 문자열
/*
String 자료형 사용
1) String a = "Happy Java"; // 리터럴 표기방식
2) String a = new String("Happy Java"); // 새로운 string 객체를 만드는 방식

**원시 자료형 : int, long, double, float, boolean, char 자료형. new로 값 생성 불가!
String은 리터럴 표기 방식을 사용할 수 있지만 원시 자료형에 포함되지 않는다


**String 자료형의 내장 메서드
-equals:문자열 2개가 같은지를 비교하여 결괏값을 리턴한다.
    ex)System.out.println(a.equals(b)); // a와 b의 값이 다르면 false 출력
    ==은 2개의 자료형이 같은 객체인지를 판별할 때 사용하는 연산자이므로 equals와 사용법이 다름
-indexOf:문자열에서 특정 문자열이 시작되는 위치(인덱스값)를 리턴한다
-contains: 문자열에서 특정 문자열이 포함되어 있는지 여부를 리턴 // bool값을 리턴
-charAt: 문자열에서 특정 위치의 문자를 리턴
    ex)String a = "Hello Java";
        System.out.println(a.charAt(6));  // "J" 출력
-replaceAll: 문자열에서 특정 문자열을 다른 문자열로 바꿀 때 사용
    ex)System.out.println(a.replaceAll("Java", "World"));  // Hello World 출력
-substring: 문자열에서 특정 문자열을 뽑아낼 때 사용
    ex)System.out.println(a.substring(0, 4));  // Hell 출력
-toUpperCase: 문자열을 모두 대문자로 변경할 때 사용
-split:문자열을 특정한 구분자로 나누어 문자열 배열로 리턴
    ex)String[] result = a.split(":"); // a:b:c:d라는 문자열을 :(콜론)으로 나누어 {"a", "b", "c", "d"} 문자열 배열로 만듬

**문자열 포맷팅 예시
System.out.println(String.format("I ate %d apples. so I was sick for %s days.", number, day));
%s 포맷 코드의 경우 어떤 형태의 값이든 변환해 넣을 수 있다.

System.out.println(String.format("I eat %d apples.", 3));
System.out.printf("I eat %d apples.", 3);  // "I eat 3 apples." 출력

=> 같은 문장 출력 but String.format은 문자열을 리턴하는 메서드이고, System.out.printf는 문자열을 출력하는 메서드
 */


//03-05 StringBuffer
/*
StringBuffer: 문자열을 추가하거나 변경할 때 주로 사용하는 자료형
**StringBuffer의 다양한 메서드
-append : 문자열을 계속해서 추가하는 메서드
-insert: 특정 위치에 원하는 문자열을 삽입
    ex)sb.insert(0, "hello "); // sb의 0번째 위치에 "hello  "삽입

-substring : String 자료형의 substring 메서드와 동일하게 동작
*/


//03-06 배열 : 자료형의 집합
/*
String[] weeks = new String[7]; //배열의 길이는 7(0~6번까지). 초기값없이 배열변수 만들때는 꼭! 길이 지정해줘야함
weeks[0] = "월"; //0번째 칸에 "월" 넣음

**배열오류 : ArrayIndexOutOfBoundsException // 없는 배열의 값을 출력하려고 할 때 발생하는 오류
*/

//03-07 리스트: ArrayList, Vector, LinkedList
/*
**리스트와 배열의 가장 큰 차이점은, 배열은 크기가 정해져 있지만 리스트는 변한다는 데 있다
* 제일 많이 사용하는 ArrayList
* ex)import java.util.ArrayList;

public class Sample {
    public static void main(String[] args) {
        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");
        System.out.println(pitches.get(1)); //특정 index 값 추출 가능
        System.out.println(pitches.size()); //ArrayList의 요소의 개수를 리턴. 여기선 3 리턴\
        System.out.println(pitches.contains("142")); // 리스트 안에 해당 항목이 있는지 판별해 그 결과를 boolean으로 리턴.
            //여기선 142가 있으므로 true 리턴
    }
}
*
* remove 메서드에는 2가지 방식이 있음.
* remove(객체) : 리스트에서 객체에 해당하는 항목을 삭제한 뒤, boolean 값으로 리턴
* remove(인덱스) : 인덱스에 해당하는 항목을 삭제한 뒤, 그 항목을 리턴한다
*   ex)System.out.println(pitches.remove(0));  // pitches의 첫 번째 항목이 138이므로, 138을 삭제한 뒤 138을 리턴한다.
*
*
* 이미 문자열 배열이 있으면 ArrayList를 좀 더 편하게 생성할 수 있다.
ex)import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        String[] data = {"138", "129", "142"};  // 이미 투구수 데이터 배열이 있다.
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList(data));
        System.out.println(pitches);  // [138, 129, 142] 출력
    }
}
*
** String.join("구분자", 리스트 객체)를 사용해 리스트의 각 요소에 구분자를 넣어 하나의 문자열로 만들 수 있다.
*
ex) import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
        String result = String.join(",", pitches);
        pitches.sort(Comparator.naturalOrder());  // 오름차순으로 정렬
        pitches.sort(Comparator.reverseOrder());  // 내림차순으로 정렬
        System.out.println(result);  // 138,129,142 출력
    }
}
*/


//03-08 맵 : 키(key)와 값(value)을 한 쌍으로 갖는 자료형(HashMap, LinkedHashMap, TreeMap)
/*
**hashmap
ex)import java.util.HashMap;

public class Sample {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(); //key, value 모두 String 자료형. 이외의 자료형은 사용 불가.
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.get("people")); // key인 people에 대응하는 value인 사람이 출력
        System.out.println(map.getOrDefault("java", "자바"));  // "java"가 없을 경우 기본값인 "자바" 출력
        System.out.println(map.containsKey("people"));  // 맵에 해당 key가 있으므로 true 출력
        System.out.println(map.remove("people"));  // people에 해당되는 key와 value가 모두 삭제된 후 사람이 출력
        System.out.println(map.size());//맵 요소의 개수를 리턴하므로 1 출력
        System.out.println(map.keySet());  // 맵의 모든 key를 모아서 집합자료형으로 리턴하므로 [baseball, people] 출력
    }
}
*/

//03-09 집합(HashSet, TreeSet, LinkedHashSet)
/*
-중복을 허용하지 않는다.
-순서가 없다(unordered).

import java.util.HashSet;

public class Sample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Jump"); //add : 집합 자료형에 값을 추가할 때 사용.
        set.add("To");
        set.add("Java");
        set.addAll(Arrays.asList("To", "Java")); // addAll : 값을 한꺼번에 여러개 추가할 때 사용.
        set.remove("To"); // remove : 특정값 제거 시 사용
        System.out.println(set);  // [Java, Jump] 출력

    }
}
*/

//03-10 상수 집합(enum 자료형)
/*
-매직 넘버를 사용할 때보다 코드가 명확하다.
-잘못된 값을 사용해 생길 수 있는 오류를 막을 수 있다.
ex)public class Sample {
    enum CoffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    };

    public static void main(String[] args) {
        System.out.println(CoffeeType.AMERICANO);  // AMERICANO 출력
        System.out.println(CoffeeType.ICE_AMERICANO);  // ICE_AMERICANO 출력
        System.out.println(CoffeeType.CAFE_LATTE);  // CAFE_LATTE 출력
    }
}
*/

//03-11 형 변환과 final
/*
문자열 -> 정수
ex)int n = Integer.parseInt(num);

정수를 문자열로 바꾸는 가장 쉬운 방법: 정수 앞에 빈 문자열("")을 더해 주는 것이다.
int n = 123;
String num = "" + n;

or

int n = 123;
String num1 = String.valueOf(n);
String num2 = Integer.toString(n);

정수와 실수 사이의 형 변환도 가능
 double d1 = n1;  // 정수를 실수로 바꿀때에는 캐스팅이 필요없다.
 int n2 = (int) d2; // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅해 주어야 한다.

final : 자료형에 값을 단 한 번만 설정할 수 있게 강제하는 키워드
final int n = 123;  // final로 설정하면 값을 바꿀 수 없다.
n = 456;  // 컴파일 오류 발생

*/
