술길따라 README

프로젝트 이름 : 술길따라
다양한 술과 양조장을 탐방하며 자신만의 술길을
따라가 새로운 맛과 문화를 발견하는 여정이라는 의미
프로젝트 목표
- 국내 양조장 정보와 주류 리뷰를 통합하여 제공하는 플랫폼 개발
- 기존 투어 예약 사이트와 차별화된, 주류와 양조장 정보에 특화된 사용자 친화적인 플랫폼을 제공

팀원구성

# 1. 개발환경<br>
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)<br>
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)<br>
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)<br>
![Trello](https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white)<br>
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)<br>
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)<br>
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)<br>
![ChatGPT](https://img.shields.io/badge/chatGPT-74aa9c?style=for-the-badge&logo=openai&logoColor=white)<br>
![Kakao](https://img.shields.io/badge/Kakao-FFCD00?style=for-the-badge&logo=Kakao&logoColor=black)
![Naver Maps](https://img.shields.io/badge/Naver%20Maps-03C75A?style=for-the-badge&logo=Naver&logoColor=white)






# 3. 채택한 개발기술과 브랜치 전략

# 4. 프로젝트 구조

# 5. 프로젝트 역할 분담
   ## 홍예은: 회원 정보 관리
      - 회원 가입, 로그인, 회원 정보 수정 등 사용자 관련 기능 개발
   ## 엄은지: 양조장 정보 관리
      - 국내 양조장 정보 조회 및 검색 기능 구현
   ## 김정욱: 주류 정보 관리
      - 다양한 주류 정보 제공 및 검색 기능 구현, 주류 정보 CRUD 구현, OpenAI API를 통한 주류 추천 서비스 개발
   ## 조홍빈: 투어 예약 및 결제 시스템
      - 양조장 투어 예약 및 결제 기능 개발
   ## 이충무: 주류 리뷰 게시판 및 댓글 관리
      - 주류 리뷰 작성 및 댓글 기능 구현

# 7. 개발 기간 및 작업 관리
   ![Development_period](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8_%EC%9D%BC%EC%A0%95.jpg?raw=true)<br>

# 8. 페이지별 기능(여기에다가 각자 기능 하면 될듯?)
 ## 1. 홍예은
 ## [로그인]
로그인은 일반 로그인과 소셜 로그인(카카오)를 구현하였습니다
- 일반 로그인
        ![image](https://github.com/user-attachments/assets/56158dbf-da17-47ad-8e28-c2a6855ce10b)
- 소셜 로그인(카카오)

  카카오 로그인 버튼을 누를 시 술길따라의 카카오 로그인 창으로 넘어가게 됩니다.

  동의하기 버튼을 눌러 가입 후에 술길따라의 서비스를 이용할 수 있습니다.
          ![image](https://github.com/user-attachments/assets/ff4d038e-bd13-443c-ba6f-c45c557ff02d)
- 로그인 시 네비게이션 드롭 바

  로그인 성공할 시 회원의 이름과 마이페이지, 로그아웃이 네비게이션 드롭다운 바로 나오도록 구현했습니다. 
 비회원일 경우에는 로그인 창으로 넘어가게 됩니다.
          ![image](https://github.com/user-attachments/assets/add8bb69-245b-429d-a016-a83bbc84de02)

## [회원가입]
+ 회원가입은 Spring boot의 Validation 어노테이션에서 @NotBlank을 사용하여 필수값 입력인 요소들을 입력하지 않으면 회원가입이 진행되지 않게 했습니다.
+ 또한 비밀번호에는 @Pattern 유효성을 주었고 이메일에는 @Email로 유효성을 주었습니다.
+ 그리고 비밀번호 동일 체크를 두어 비밀번호가 동일해야 회원가입이 가능하도록 하였습니다.
+ 또한 파일 첨부 기능을 두어 회원의 프로필을 설정하도록 하였습니다.

![술길따라 기능시연-02-회원정보](https://github.com/user-attachments/assets/bdcaf875-49b9-4d9c-93a2-6c8879380ca9)
## [마이페이지]
### 1. 회원정보수정
  - 일반 회원

      일반회원에서 아이디, 이름을 제외한 정보들을 수정할 수 있으며 프로필 사진 또한 수정이 가능하도록 구현하였습니다.
           ![image](https://github.com/user-attachments/assets/10f621fe-4ec6-4667-bdf4-f4d9d5d01d49)
  - 카카오 회원
    
    카카오 회원으로 마이페이지에 접속 할 시 본인의 카카오 프로필 사진과 정보들이 보입니다.
    
   ![image](https://github.com/user-attachments/assets/56c01896-f495-4b71-8abd-e05f186921bb)
### 2. 체험 예약 리스트
  회원은 본인이 예약한 체험 리스트를 조회할 수 있습니다.

예약번호, 투어이름, 투어비용, 예약날짜, 예약시간, 방문인원이 나타납니다.
![image](https://github.com/user-attachments/assets/8e8080c4-a195-41ca-a2f0-2a36e5771223)
### 3. 내가 쓴 리뷰

  회원은 본인이 작성한 리뷰를 조회할 수 있습니다.

게시글 번호, 제목, 상품명, 작성일, 조회수, 별점이 나타나고 제목을 누르면 게시글 상세로도 넘어갈 수 있습니다.
 ![image](https://github.com/user-attachments/assets/6035508b-d013-4be9-b280-88dd23260cbf)
### 4. 회원 탈퇴
 - 일반 회원

일반 회원으로 탈퇴 시에는 비밀번호가 일치해야 탈퇴가 가능하도록 구현하였습니다.

![술길따라 기능시연-02-회원정보 (2)](https://github.com/user-attachments/assets/5df8d78f-e11d-4e9f-8e73-014a211bfd93)
  - 카카오 회원

    카카오 회원으로 탈퇴 시에는 비밀번호 입력 없이도 탈퇴가 가능하도록 구현하였습니다.
         ![image](https://github.com/user-attachments/assets/4dd2f095-6ffc-4243-97c0-3df90d125b8f)
## [아이디 찾기]
회원은 본인의 이름과 이메일을 통해 아이디를 찾을 수 있도록 구현하였습니다.
![image](https://github.com/user-attachments/assets/6d77f1e6-e0f7-4655-b597-f71ec025b26d)
해당하는 아이디가 존재하면 아이디를 알려줍니다.
        ![image](https://github.com/user-attachments/assets/8daf2c3e-9760-4082-99bb-a5c10d943289)
## [비밀번호 찾기]
회원은 본인의 아이디와 이메일을 통해 비밀번호를 찾을 수 있도록 구현하였습니다.
 ![image](https://github.com/user-attachments/assets/bab0be04-5e08-479e-bb67-8a2f74b584e8)
구글 이메일 전송 API를 사용하여 해당 이메일로 임시비밀번호를 전송하도록 하였습니다.
         ![image](https://github.com/user-attachments/assets/d8efa3b2-9196-461c-b398-3bd3936284c9)
         ![image](https://github.com/user-attachments/assets/cb0556d0-06d0-4c3b-93e2-ab9c4ce15e5f)

만약 해당하는 정보가 없다면 다음과 같이 일치하는 정보가 없도록 뜨도록 하였습니다.
    ![image](https://github.com/user-attachments/assets/172fd8b3-2b8f-4fe9-b3b6-aeb7e300864c)
 ## 2. 엄은지
   1. 양조장 메인페이지
      ![image](https://github.com/user-attachments/assets/646b646d-4126-4acc-b61f-b9aa1e7998e4)
      수도권, 강원, 충청, 전국 등으로 지역을 분리한 간단한 지도 출력 / 처음 메인에 들어가면 전국이 기본으로 선택되어있음
      ![image](https://github.com/user-attachments/assets/6613e2e2-0247-48ea-9d5c-8370aab454e0)
      각 지역 클릭 시 지역에 해당하는 양조장 리스트가 오른쪽에 출력됨 리스트에는 양조장 이름, 주소, 연락처가 나옴
      ![image](https://github.com/user-attachments/assets/876e6640-3f87-45a9-878c-aefeacaef009)
      ![image](https://github.com/user-attachments/assets/62063ae5-f1d6-484c-8986-8de4cc946b02)
      메인페이지 하단에는 태그들이 새로고침할 때마다 랜덤으로 출력되고 기본적으로 첫번째 해시태그에 해당하는 리스트가 출력됨
      ![image](https://github.com/user-attachments/assets/52df0872-2816-4880-9a45-d0ab3f69141d)
      다른 해시태그 클릭 시 글자가 굵게 바뀌고 그 해시태그에 해당하는 리스트가 출력됨
   3. 양조장 리스트
      ![image](https://github.com/user-attachments/assets/ed82b17d-8b76-4c80-becc-2f0c2294f910)
      지역별 리스트에서 전체보기 클릭 시 클릭한 지역명이 출력되고 그 지역에 해당하는 전체 리스트가 출력됨
      양조장 사진, 주소, 주종, 해시태그가 출력되는데 양조장에 해당하는 주종이 여러개라 중복값을 제외하고 출력함
      해시태그는 모든 양조장이 #전국을 모두 포함하고 있어서 첫번째 값은 제외하고 출력함
      ![image](https://github.com/user-attachments/assets/e5672a32-edb9-44ec-a22e-705aa96d8eec)
      양조장명과 지역명으로 검색이 가능함
      ![image](https://github.com/user-attachments/assets/8fb83487-e186-43dc-9466-1615939d3cf9)
      지역을 누르면 선택 가능한 옵션들 출력, 지역 선택하면 해당하는 지역 리스트 출력됨
      ![image](https://github.com/user-attachments/assets/9b23e76b-a032-400c-a01c-ef2836b7e4f6)
      양조장명으로 검색하면 키워드가 포함된 양조장 리스트가 출력됨
      ![image](https://github.com/user-attachments/assets/4b278bbd-d604-437a-9c46-e4223e86c717)
      없는 키워드 검색하면 검색결과 없음 출력됨
   5. 양조장 상세 페이지
      ![image](https://github.com/user-attachments/assets/020f6a4f-5d6f-4d9b-8de5-b0c46034a7fa)
      메인페이지의 지역별 리스트나 하단 해시태그 리스트에서 양조장 클릭 시 해당 양조장 상세페이지로 이동됨
      해당 양조장의 사진, 지역, 투어가능여부, 양조장명, 주소, 전화번호, 영업시간, 주종, 홈페이지가 상단에 출력됨
      홈페이지 클릭 시 해당 양조장 홈페이지로 이동됨
      ![image](https://github.com/user-attachments/assets/2593bde0-bd5e-455c-af4c-086bfcdc70ef)
      해당 양조장이 생산하는 생산제품이 출력됨, 제품의 사진, 제품명, 도수, 가격이 출력됨
      ![image](https://github.com/user-attachments/assets/a5fc4ca5-9201-47ee-8180-e898329f2cce)
      해당 양조장에서 체험 가능한 체험프로그램이 출력됨, 프로그램명, 내용, 소요시간, 금액이 출력됨
      ![image](https://github.com/user-attachments/assets/cd87aabf-94fe-4721-93f0-b4cc22bbdb84)
      예약하기 클릭 시 바로 테험 프로그램 예약하기 사이트로 이동됨
      ![image](https://github.com/user-attachments/assets/1f446d4a-85e0-4dbf-bb71-52453b75b5c3)
      geocode API를 이용해서 해당 양조장에 입력된 주소를 위도와 경도로 변환한 뒤 네이버 지도 API를 사용해 위도와 경도값을 입력해서 지도를 출력하고 그 위치에 마커를 표시함
      ![Uploading image.png…]()
      해당 양조장의 편의시설, 키즈존 유무, 장애인 편의시설 유무가 출력됨
      편의시설 테이블을 따로 안만들고 여러개로 받아서 json배열로 입력된 데이터베이스의 값을 하나씩 받아오는게 힘들었음
      ["park","restroom"] 이런식으로 입력되어있는걸 대괄호를 삭제하고 ,를 기준으로 자르고 배열로 만든 뒤 하나씩 넣은 뒤
      한글로 변환하기 위해 하나씩 매핑하고 영어와 한글로 매핑되어있는걸 한글과 아이콘으로 매핑해서 하나씩 출력함
      키즈존이랑 장애인 편의시설은 yes와 no로 입력받은 뒤 타임리프로 if문을 걸어서 입장가능, 입장불가, 그에 해당하는 아이콘 바로 출력함
   7. 양조장 관리자 페이지
## 3. 조홍빈

### 체험 예약 리스트
   + 체험 프로그램에 관한 내용들이 <u>목록<u> 형태로 출력이 됩니다
   + 페이지 상단에서 체험 프로그램명 키워드를 통해 검색이 가능합니다.
    ![GOMCAM 20240913_1143530503](https://github.com/user-attachments/assets/5971d14a-8f51-4c55-8e20-deef603655c3)<br>
   
   
### 체험 예약

   + 양조장의 정보와 체험에 관한 정보를 상단에 표시 합니다.
   + 달력에서 원하는 날짜 클릭 시 해당 일자에 색깔로 표시 되며 달력 상단에 해당 날짜 달력이 표시 됩니다.
   + 예약자 정보 입력 칸에서는 모든 입력 칸이 필수 조건으로 하나라도 미입력시 입력하라는 알림이 표시됩니다.
   + 예약하기 버튼 클릭 시 결제 페이지로 이동합니다. <br>
   ![GOMCAM 20240913_1149480794 (1)](https://github.com/user-attachments/assets/195632eb-bfc1-4e18-9dc0-948d4d1190d2)

### 결제
     
   + 왼쪽영역 에서 결제 방식을 선택할 수 있습니다
   + 오른쪽 영역에서 결제 해야할 총 가격이 표시됩니다
   + 결제 하기 버튼을 통해 결제 사이트로 이동합니다
   + 결제 성공시 성공 페이지로 이동합니다
     ![GOMCAM 20240913_1154330870 (1)](https://github.com/user-attachments/assets/c34ea540-a9bf-44a8-85e3-b6f7fc78e414)<br>
   ![GOMCAM 20240913_1159200137](https://github.com/user-attachments/assets/a88aa43c-b463-4620-b344-9269c0e3bf17)<br>
   ![새로운 프로젝트 (2)](https://github.com/user-attachments/assets/6c213037-20a2-4b74-ba04-e2b00c3fffb8)




### 예약 조회

   + 결제 후 제공된 예약 번호를 입력하면 예약관련 정보를 조회할 수 있습니다.
     ![GOMCAM 20240913_1213580243](https://github.com/user-attachments/assets/ca110ea3-e0ae-4bd4-a5c0-fe9e379aa4ff)


### 예약관리자

   + 사용자의 모든 예약 내용을 조회 할 수 있습니다
   + 검색을 통해 특정 양조장 혹은 특정 사용자의 예약 내용에 대해 조회할 수 있습니다
     ![GOMCAM 20240913_1209100337](https://github.com/user-attachments/assets/1e86c2ac-44d9-45bf-b30a-922365fe4c7b)


 ##  4. 김정욱
      - 술도감 (상세검색 기능)
         - 검색조건 여러개를 중첩시킬 수 있습니다.
         - 검색결과는 한 페이지에 12개씩 페이징 처리 하였습니다.
         - 검색결과를 클릭하면 해당 주류의 상세페이지로 이동합니다.
         ![Liquor_search_01](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/liquor_search_01.gif?raw=true)<br>
         ![Liquor_detail](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/liquor_detail.gif?raw=true)<br>
      - AI 검색
         - 문장으로 입력된 질문에 대해 OpenAI API를 사용하여 DB의 내용 중 합당한 항목을 선택하여 주관적인 답변을 받습니다.
         - RestAPI를 통하여 OpenAI API로 post 요청을 보내고 결과를 받아 화면에 출력하도록 했습니다.
         ![Ai_search_01](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/ai-search_01.gif?raw=true)<br>
      - 주류정보 등록
         - 관리자 계정으로 접속 시 나오는 관리페이지에서 주류 정보 등록이 가능합니다.
         ![Liquor_add](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/liquor_add.gif?raw=true)<br>
      - 주류정보 수정 및 삭제
         - 주류정보 수정 및 삭제도 마찬가지로 관리페이지에서 수행 가능합니다.
         ![Liquor_update_delete](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/liquor_update_delete.gif?raw=true)<br>
 ##  5. 이충무
 ### 게시판 - 메인
 - 검색창을 이용한 검색, 태그 선택을 통한 간편검색 및 정렬기준 선택이 가능합니다.
 - 간편검색의 경우 태그를 하나 이상 선택시에 버튼이 활성화 됩니다.
 - 하단의 페이지네비를 통해 페이지 이동이 가능합니다.
 - 각 게시글에는 썸네일로 등록된 이미지와 내용 등이 간략히 보여집니다.
 - 각 게시글을 클릭 시 해당 게시글의 상세페이지로 이동합니다.
    
 ### 게시글 등록
 - 게시글 등록은 로그인 이후에 이용가능합니다.
 - 게시글 등록 시 입력 필수사항으로 리뷰를 쓸 상품, 별점, 제목, 내용, 썸네일 이미지가 있습니다. 
 - 상품의 경우 버튼을 눌러 띄워지는 모달창에서 조회하여 선택할 수 있습니다.
 - 태그는 하나 이상의 태그를 등록 가능합니다.
    
 ### 게시글 상세 및 댓글
 - 제목, 별점, 내용 등의 정보를 확인할 수 있습니다.
 - 해당 게시글이 갖는 태그를 클릭 시 태그를 가진 게시글 조회가 가능합니다.
 - 하단의 이전글, 다음글 버튼을 통해 게시글에 접근 가능합니다.
 - 게시글 내에서 댓글 작성이 가능합니다.
 - 댓글 등록은 페이지로딩없이 적용됩니다.
 - 자신의 댓글의 경우 수정 또는 삭제가 가능합니다.
    
 ### 게시글 수정 및 삭제
 - 자신의 게시글의 경우 수정 페이지 이동 및 수정, 삭제가 가능하다.
 - 수정 시에 필수입력란을 비우지못한다.
 - 수정 도중에 다른 페이지로의 이동은 알림창을 통하여 이동여부를 확인한다.
 - 
 10. 프로젝트 후기
