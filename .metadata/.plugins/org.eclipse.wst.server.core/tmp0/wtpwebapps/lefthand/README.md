공지

https://suzxc2468.tistory.com/174

- UTF-8 설정 필수!!

- 파일이 없는 빈 폴더는 깃허브에서 안보여요

- 다른 팀원이 한 영역을 건들고 싶을때 파일 업로드할때 맨아래 라디오버튼을 눌러 branch화 해서 올리고 담당자가 확인후 merge 하세요. 

동일이름이면 덮어씌워지니까 조심하고 서로 안다면 바로 업로드 하셔도 되요

- 프로젝트 한번에 받을때 동기화나 zip파일 통째로 받아서 적용하지말고... 필요한 파일만 넣는식으로 자기 환경에 맞춰서 작업하세요

환경 설정 파일 매번 바꿔줘야 하는데 그게 더 귀찮음

--------------------------------------------------------------------------------------------

기본 프로젝트 경로 

C:\team6\lefthand\WebContent


--------------------------------------------------------------------------------------------


깃허브 비어있는 폴더 생성법 : https://mac-user-guide.tistory.com/57

src의 package 안의 .java 파일이 이상하게 들어가 있을때 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=zzang9ha&logNo=221712872483

import 한뒤 javaServlet 에러 : https://blog.naver.com/PostView.nhn?blogId=bgpoilkj&logNo=221656227898&parentCategoryNo=&categoryNo=53&viewDate=&isShowPopularPosts=false&from=postView

classpath 충돌 : lefthand 폴더 .classpath 파일안에 

classpathentry kind="lib" path="F:/pjs/web/apache/lib/jsp-api.jar"			    <<--- 이부분을 자기걸로 수정
classpathentry kind="lib" path="F:/pjs/web/apache/lib/servlet-api.jar"   <<--- 이부분을 자기걸로 수정


--------------------------------------------------------------------------------------------



명세서


challenge
 댓글 신고 보류, 상세에서 댓글 update할때 ajax같은걸로 구현할지 그냥 새로고침 시킬건지 고민중


funding


member


product


service



--------------------------------------------------------------------------------------------


폴더 명세서


src (mvc 모델 서블릿, 클래스, vo 파일...등)
- 도전펀딩
- 펀딩
- 멤버
- 상품
- 서비스



WebContent

- admin : admin 관련 전부 (담당자 구조)
- css : 모든 css(단, 페이지내 style 줄수가 짧다면 굳이 안넣어도 됨)
- img : 사이트 공통 이미지
- include : include 할 페이지들(기본 : header, footer)
- js : 모든 js, jq 들 (단, 공통적으로 잘 안쓰는거면 페이지내 <script>로 해도됨)

 
 
page 
 
 - 도전펀딩 
 - 펀딩 
 - 멤버(마이페이지, 회원가입, 로그인, 장바구니 등.. 담당자 구조 따름) 
 - 상품(가위, 문구 , 주방, etc) 
 - 서비스(고객센터 등... 담당자 구조 따름)

각각의 폴더엔 각각의 페이지에서 주로 사용할 img 폴더가 있고, 도전 펀딩의 경우 유저가 올리는 이미지를 저장할 userimg 폴더가 따로 있음



