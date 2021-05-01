# 202103-hayoong12-naver.com
윤하웅 - 서버 - hayoong12@naver.com

## 목차
- [Todo list kakaocoding application](#Todo-list-kakaocoding-application)
- [사용 프레임워크 및 기술 스펙](#사용-프레임워크-및-기술-스펙)
- [아키텍처](#아키텍처)
- [분석 내용](#분석-내용)
- [핵심문제 해결 전략](#핵심문제-해결-전략)
- [동작 방식](#동작-방식)
- [미구현사항](#미구현사항)
- [제약사항](#제약사항)
- [HTTP STATUS](#HTTP-STATUS)
- [Product Service api spec](#Product-Service-api-spec)
- [Invest Service api spec](#Invest-Service-api-spec)


Todo list kakaocoding application
=============
- UI를 제외한 간소화된 rest api 구현
- 간략한 부동산/신용투자 서비스 개발하는 방법입니다.

문제
=============
1. 사용자는 원하는 부동산/신용투자 상품 투자 할 수 있음
2. 투자상품이 오픈할 때, 다수의 고객이 동시에 투자를 함
3. 투자 후 투자상품의 누적 투자모집금액, 투자자 수가 증가됨
4. 상품의 총 투자모집금액 달성 시 투자는 마감되고 상품상태는 sold out이 됨

사용 프레임워크 및 기술 스펙
=============
- java
- spring boot
- JPA
- h2(데이터베이스)
- maven

빌드 및 실행 방법
===========
Intellij에서 각각의 프로젝트
```
 Run DemoApplication
```

아키텍처
=============
응용프로그램은 두가지 서비스로 구성됩니다.
1. 상품 서비스 : 상품 업데이트, 삭제, 조회를 위한 rest api를 구현
2. 투자 서비스 : 상품에 대한 투자를 위한 rest api를 구현

분석 내용 
=============
1. rest api을 이해하고 spring boot와 jpa를 사용할 수 있는지
2. 서버의 실시간성과 트래픽에 대해 유연한 대처를 할수 있는 설계인지
3. 대량의 트랜젝션에 대해 비동기 처리를 설계할 수 있는지

핵심문제 해결 전략 
=============
1. JPA를 활용하여 데이터베이스를 설계하지 않고 개발을 진행
2. 서버의 실시간성 트래픽에 유연한 대처를 할 수 있는 마이크로서비스로 나누어서 서비스단위로 오토스케일링에 적합하도록 설계
3. 다량의 트래픽에 대한 비동기 처리방식으로 데이터 처리하도록 설계


동작 방식 
=============
### 1. 전체 투자 상품 조회 api
- 상품서비스에서 제공
- Product 테이블에 저장된 데이터를 select 한다 
- productService는 테이블에 저장된 데이터를 select 하면서 오늘날짜기준으로 상품의 시작, 종료날짜와 비교한다.

### 2. 투자하기 api
- 투자서비스에서 제공
- 사용자 식별값, 상품id, 투자금액을 입력 받아 Invest테이블에 저장한다.
- 입력받은 값으로 상품서비스에서 http 통신으로 데이터를 조회를 한다.
- 조건에 맞게 Product테이블에 저장되어 있는 현재모집금액, 현재투자인원을 업데이트 한다.
- 결과값을 리턴받아서 투자상태(성공,실패)를 업데이트한다.

### 3. 나의투자상품조회 api
- 상품서비스에서 제공
- 사용자 식별값을 입력받는다 
- 입력받은 값으로 투자서비스에서 http통신으로 데이터를 조회를 한다.
- 조건에 맞는 Invest에 저장된 투자한 상품에 대한 data를 return한다.

미구현사항
=============
- logger 구현
- 테이블별 row 생성일, 생성자, 업데이트일, 업데이트자 컬럼 생성
- dto, entity class 에 대한 test code 작성은 꼭 필요한 경우를 빼고 제외한다
- 메세지큐(kafka)사용한 투자신청처리 

제약사항
=============
memory db 제약

HTTP STATUS
=============
#### Http status
- 200 (201?) "저장에 성공했습니다 >  x" 202 Accepted "요청이 정상적으로 들어왔습니다." 당신의 요청번호 : 1234
- 400 필수데이터 없음
- 400 투자금액 한도 초과(sold-out상태)
- 404 상품조회 실패
- 404 맴버id 없음
- 409 투자 실패  

Product Service api spec
=============
### 1. 전체 상품 조회(현재날짜 기준 상품 모집기간 내에 상품만 응답)

#### http request 
get http://${domain}/products/proudct_list

#### Header
|content-type|defalut|application/json;| charset=utf-8|
|-----|------|-----|------|


#### request body
parameter			type	defalut	description

#### example
http://${domain}/products/proudct_list

#### responsebody
productsList List
|parameter|type|defalut|description|
|-----|------|-----|------|
|id|Long|true|상품번호|
|title|boolean|true|투자명
|totalInvestingAmount|Long|true|총투자모집금액|
|status|Long|true|투자모집상태|
|startedAt|Date|true|상품시작일시|
|finishedAt|Date|true|상품종료일시|
|recruitmentAmount|Long|true|현재모집금액|
|investorCount|Long|true|현재투자인원|



### 2. 내가 투자한 상품 조회

#### http request 
get http://${domain}/products/my_invested_proudct_list

#### Header
|content-type|defalut| application/json;| charset=utf-8|
|-----|------|-----|------|
|X-USER-ID|true|

#### request body
parameter			type	defalut	description

#### example
http://${domain}/products/my_invested_proudct_list

#### responsebody
investList List
|parameter|type|defalut|description|
|-----|------|-----|------|
|sequenceId|Long	true	요청번호
|product|JSON	true	
|>productId|Long|true|상품번호|
|>title|string|true|투자명|
|totalInvestingAmount|Long|true|총투자모집금액|
|investmentCompleted|boolean|true|투자성공여부|
|investmentAmount|Long|true|나의투자금액|
|investmentTime|Long|true|투자일시|



### 3. 투자시 상품상태 체크 및 금액, 투자자 업데이트

#### http request 
post http://${domain}/products/invest

#### Header
|content-type|defalut| application/json;| charset=utf-8|
|-----|------|-----|------|


#### request body
|parameter|type|defalut|description|
|-----|------|-----|------|
|productId|Long|true|상품번호|
|investmentAmount|Long|true|나의투자금액|
|newMember|boolean|true|새로운투자자여부|


#### example
http://${domain}/products/invest


Invest Service api spec
=============

### 1. 고객이 투자하는 정보를 저장함

#### http request 
post http://${domain}/investment/invest

#### Header
|content-type|defalut| application/json;| charset=utf-8|
|-----|------|-----|------|
|X-USER-ID|true|

#### example
http://${domain}/investment/invest


#### request body
|parameter|type|defalut|description|
|-----|------|-----|------|
|productId|Long|true|상품번호|
|investmentAmount|Long|true|나의투자금액|


### 2. 내가 투자한 상품의 나의 투자금액, 투자일시를 반환함

#### http request 
get http://${domain}/investment/my_invest_list

#### Header
content-type true application/json; charset=utf-8
X-USER-ID 	 true

#### request body
|parameter|type|defalut|description|
|-----|------|-----|------|

#### example
http://${domain}/investment/my_invest_list

#### responsebody
investList List	
|parameter|type|defalut|description|
|-----|------|-----|------|
|sequenceId|Long|true|요청번호|
|productId|Long|true|상품번호|
|investmentCompleted|boolean|true|투자성공여부|
|investmentAmount|Long|true|나의투자금액|
|investmentTime|Long|true|투자일시|


