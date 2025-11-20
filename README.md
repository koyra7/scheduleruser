11.18 일정 CRUD , 유저 CRUD 작성
11.19 유저 field에 비밀번호 추가, 로그인 작성
11.20 이름과, 제목 글자수 제한, 비밀번호 암호화 작성

<img width="827" height="249" alt="image" src="https://github.com/user-attachments/assets/2b6b00a4-cb84-4a7b-826f-36a7f9bb5928" />
<img width="650" height="288" alt="image" src="https://github.com/user-attachments/assets/8af6e88b-6aff-4c08-99d9-89722925e37a" />
<img width="695" height="311" alt="image" src="https://github.com/user-attachments/assets/179800e2-0e01-4ea7-aa97-52b37dcf9b23" />

필수과제까지는 강의를 보고 어떻게든 했지만, 5단계부터는 구글링을 통해 찾아보앗다.
글자수 제한의 경우 Size or Length or culumn 사용하고 공백을 방지하기 위해 Notblank 사용 하는것을 알게되었는데, 어노테이션이 계속 작성이 안되었음.
어노테이션을 사용하려면, Gradle에 추가해야되다는것을 확인하였고 , 추가 및 작성 하였음. 제한조건을 다는것 자체는 쉬웠습니다.

위 문제 해결로 어노테이션 사용에는 Gradle에 추가해야된다는것을 알았다.**

암호화 단계에서 맨 처음에는 흠... 어떻게 할지 갑갑했는데.
우선 과제안내 페이지 내 클래스를 만들라는 것을 복사하여 생성하고. 매소드 명을 보고 대충 눈치를 챘고.

Service에서 적용 당연히 비밀번호를 암호화 할거니, 암호 생성 부분, 매칭은 로그인 파트에서 사용하여아한다는것을 눈치챘다.
해당 기능을 구현하며, 자신의 코드를 다시 뜯어 해석해보는 시간이 있어 유익한 시간이였고, 암호화 시켜 저장하고, 로그인 부분에서 if문으로 조건을 달아서
조건에 입력받은 비밀번호와 저장된 비밀번호가 동일치 않을시 if로 조건을 걸어 에러 메세지가 출력되도록 하였다.
