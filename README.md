술길따라 README

프로젝트 이름 : 술길따라
다양한 술과 양조장을 탐방하며 자신만의 술길을
따라가 새로운 맛과 문화를 발견하는 여정이라는 의미
프로젝트 목표
- 국내 양조장 정보와 주류 리뷰를 통합하여 제공하는 플랫폼 개발
- 기존 투어 예약 사이트와 차별화된, 주류와 양조장 정보에 특화된 사용자 친화적인 플랫폼을 제공

팀원구성

1. 개발환경<br>
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)<br>
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)<br>
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)<br>
![Trello](https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white)<br>
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)<br>
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)<br>
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)<br>

3. 채택한 개발기술과 브랜치 전략

4. 프로젝트 구조

5. 역할 분담

6. 개발 기간 및 작업 관리
   ![Development_period](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8_%EC%9D%BC%EC%A0%95.jpg?raw=true)<br>

8. 페이지별 기능(여기에다가 각자 기능 하면 될듯?)
   1. 홍예은
   2. 엄은지
      2. 엄은지
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
   4. 조홍빈
        # [체험 예약 리스트]
   + 체험 프로그램에 관한 내용들이 목록 형태로 출력이 됩니다
   + 페이지 상단에서 체험 프로그램명 키워드를 통해 검색이 가능합니다.
   + ![GOMCAM 20240913_1143530503](https://github.com/user-attachments/assets/5971d14a-8f51-4c55-8e20-deef603655c3)<br>
   
   
      # [체험 예약]
   + 양조장의 정보와 체험에 관한 정보를 상단에 표시 합니다.
   + 달력에서 원하는 날짜 클릭 시 해당 일자에 색깔로 표시 되며 달력 상단에 해당 날짜 달력이 표시 됩니다.
   + 예약자 정보 입력 칸에서는 모든 입력 칸이 필수 조건으로 하나라도 미입력시 입력하라는 알림이 표시됩니다.
   + 예약하기 버튼 클릭 시 결제 페이지로 이동합니다.
   + ![GOMCAM 20240913_1149480794 (1)](https://github.com/user-attachments/assets/195632eb-bfc1-4e18-9dc0-948d4d1190d2)

      # [결제]
     
   + 왼쪽영역 에서 결제 방식을 선택할 수 있습니다
   + 오른쪽 영역에서 결제 해야할 총 가격이 표시됩니다
   + 결제 하기 버튼을 통해 결제 사이트로 이동합니다
   + 결제 성공시 성공 페이지로 이동합니다
   + ![GOMCAM 20240913_1143530503](https://github.com/user-attachments/assets/5971d14a-8f51-4c55-8e20-deef603655c3)<br>
   +![GOMCAM 20240913_1159200137](https://github.com/user-attachments/assets/e5a7ebdb-439f-414c-ad50-1eef0be0de0d)

   4. 김정욱
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
   5. 이충무

 10. 프로젝트 후기
