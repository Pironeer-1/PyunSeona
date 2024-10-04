# 📝 나만의 템플릿 코드

## 1. 컨벤션 기록 & 이유 설명
![image](https://github.com/user-attachments/assets/6f2b478d-97ca-4b45-98c5-fd2bbdfe82c4)

- global 패키지
  -
  - 전역으로 사용하는 설정들을 담고있는 패키지
  - config, exception, jwt, service의 기능을 가지고 있다.(설정 및 예외처리 일관화)

- board(게시판), member(회원관리) 패키지 : 
  - 
  - 기능별로 도메인을 분리해서 각각 패키지를 만들었다.
  - controller, dto, entity, repository, service 계층을 나누어(계층적 구조) 설계하였다.
  

    - Controller: 클라이언트 요청 처리 및 응답 반환
    - DTO (Data Transfer Object) : 데이터 전송 객체 (클라이언트-서버 간 데이터 교환).
    - Entity: 데이터 구조 정의 (데이터베이스와 매핑)
    - Repository: CRUD 작업 구현 (데이터베이스와 상호작용)
    - Service: 비즈니스 로직 구현 / Repository와 DTO가 정의된 후 구현하며 컨트롤러에서 호출된다

### 📍 도메인형 계층 구조의 장점
1. 책임분리 
각 계층별로 담당하는 역할이 따로 있다.
예를 들어 board(게시판)의 로직 변경 시 board 패키지 폴더 안의 로직을 담당하는 SERVICE만 수정하면 되므로 유지보수에 용이하다.
2. 테스트시 용이
각 계층이 독립적이므로 계층 별 단위 테스트 시 용이하다.

### 📍 다양한 패턴 구조
- 모놀리식 아키텍처
- MSA ..
- 
  [참고자료](https://assu10.github.io/dev/2023/05/06/springboot-intro/)
# 2. 커밋별 기록
- [x] 도메인형 패키지 구조 생성(global/member/board)
- [x] yml 파일 초기 세팅
- [x] board 도메인 , global 도메인(일부) 작성

    - global의 경우 exception과 jwt 제외하고 작성.
    - 데이터가 존재하지 않을 경우 `null`을 반환하도록 boardService 코드 작성
    - 아직 global>dto >exception 처리를 안했기 때문
- [x] member 도메인 구현

    - ++ 예외처리, jwt 토큰은 구현 전. / swagger에서 실행테스트 완료
- [x] global > exception 패키지 구현 및 적용 완료
    
    - board > service > BoardService
    - member > service > MemberService
    - exception 처리 구현 완료.
- [x] jwt 패키지 구현 및 적용완료

  - global > dto > reponse > JwtTokenSet 생성
  - global > config > WebConfig 생성
  - global > jwt > JwtUtil, JwtInterceptor 생성 
  - global > service > AuthService 생성 
  - member 패키지의 controller와 service에 AuthService와 JwtTokenSet import 및 적용