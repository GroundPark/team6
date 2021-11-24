공지
https://suzxc2468.tistory.com/174
 수업때 자바 클래스 파일에 UTF-8 설정을 안해서 하다보면 .java에서 주석한글이 깨지므로 관련 확장자들 전부 UTF-8 설정해주세요(.txt도)... 깃헙에서도 깨짐

파일없는 빈 폴더 깃허브에서 적용 제외 됨



///////////////////////////////////////


파일 명세서


challenge


funding


member


product : 미완 (마지막 수정자 : 박지상)
 상품 : 수업내용 끝나면 제대로 적용 / 분류별로 나눠야함
 
 - 프론트 : 목록(검색조건), 상세보기
 - 정보 : ProductInfo, PdtCata
 - 컨트롤러 : ProductCtrl - *.pdt
 - 목록(pdt_list.pdt) : PdtListAct, PdtListSvc, pdt_list.jsp
 - 상세(pdt_view.pdt) : PdtViewAct, PdtViewSvc, pdt_view.jsp
 - DB : ProductDao


service



//////////////////////////////////////////

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

 

메인(index) 페이지 파일 : mainPage.jsp
 
관리자 페이지 파일 : 


