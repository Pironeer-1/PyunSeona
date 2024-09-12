## 사전과제(사진첨부 완료)

## 1주차 과제 : 피로그래밍 코딩테스트 java로 구현하기
### 어려웠던 부분
1) 입력오류문제 : 자바 Scanner을 사용하여 입력받으려고 하였으나 nextInt( ) 사용 후 nextLine( ) 사용시 **스페이스바(공백) 입력이 안되는 오류 발생**
- nextInt() : 플레이어 인원 입력 용도  / nextLine( ) : hp, ad, ap 띄어쓰기로 입력 받은 후 split으로 분리하기 위해 사용했다
- https://allg.tistory.com/17 해당 글을 참고하여 변경해보았으나.. 실패(될때도 있고 안될때도 있었다..)
- intellij 내에 캐시 지워도 안됨
- 클론 받아와도 실행이 되지 않아 결국 BufferedReader로 최종 변경.

=> 왜 Scanner로 하면 입력 오류가 계속 나는지.. 어디서 문제가 발생하는지가 궁금합니다..

<img width="1265" alt="스크린샷 2024-09-13 오전 12 39 40" src="https://github.com/user-attachments/assets/b335f44d-09d7-4bcb-a958-e3ac45a63d03">

채점하실때 실행 안 될 수도 있을거 같아 실행하는 사진 첨부드립니다 ㅠㅠ