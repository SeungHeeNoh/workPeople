# 프로젝트 Description
- workPeople
- 현재 우리의 관심 1순위 바로 '취업'입니다.
  이와 관련하여 평소 이용하는 취업사이트 안에는 어떠한 기능들이 있고 어떻게 이용하는 게 가장 좋은지 알면 좋지 않을까 하여 시작하게 되었고,
  생각보다 복잡했던 기존 사이트를 좀 더 직관적이고 편리하게 만들어보면 어떨까하는 생각을 가지고, 
  직관성과 편리함을 기준으로 하여 '구인구직 사이트'를 만들기로 하였습니다.
  
# 프로젝트 정보
- Development Tool : STS 4.4.12.1
- [페이지 메인 링크] : http://localhost:8800/main
- 로그인 정보 
  1. 개인회원 대표 로그인 정보 : 아이디 user08 비밀번호 user08!!   (개인회원 user01~11 총 11개 이용가능.비밀번호는 아이디 뒤에 !! 붙여줌)
  2. 기업회원 대표 로그인 정보 : 아이디 cuser11 비밀번호 cuser11!!  (기업회원 cuser01~11 총 11개 이용가능.비밀번호는 아이디 뒤에 !! 붙여줌)
  3. 관리자 : 아이디 master 비밀번호 master
             
- 기업회원으로 로그인 후 마이페이지 > 인재맞춤추천 / 기업정보 / 유료서비스 탭 
- 기업회원 로고 이미지 파일 보여지도록 하려면 application.yml 에서 file config 링크 본인이 다운받은 프로젝트 경로 작성해줘야함. 
  링크에서 C:/Users/82106/eclipse-workspace/Framework/3. spring work/workPeople/ 이부분 본인 경로로 수정
```  
#file config    
custom:
  path:
    upload-images: 'C:/Users/82106/eclipse-workspace/Framework/3. spring work/workPeople/src/main/resources/'
```
