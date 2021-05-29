# yumyumgood_subgroup3
> subgroup3 식당 이용자 리뷰 작성 및 리뷰 평점 계산 기능 
</br>

### 기능 설명
![logo (1)](https://user-images.githubusercontent.com/69567269/120076519-dbeece00-c0e0-11eb-8517-0f244a3ecdc1.png)       
**주문 내역 뷰** : 식당 이용자의 주문 내역을 시간 순으로 정렬하여 보여준다. 주문 내역은 학식당, 주문한 메뉴, 결제 금액, 경과일을 포함한다.     
각 내역 별 3개의 버튼, 1.리뷰 작성 2.주문 상세 3.식당 보기 가 존재한다. 리뷰 작성 버튼은 *Domain Model 의 concept "카운터"* 가 작용한다.      
주문한지 3일이 지나면 버튼이 비활성화되어 리뷰를 작성할 수 없고 작성 기간을 경과하였음을 알린다.           
![주문내역](https://user-images.githubusercontent.com/69567269/120077520-b617f800-c0e5-11eb-95b4-64eb26dad28d.png)

**리뷰 작성 뷰** : 식당 이용자는 주문한 각 메뉴에 대하여 추천 여부를 버튼을 통해 남기고, 메뉴와 식당 시설에 대한 전반적인 리뷰를 최소 5자 최대 300자 내로 남길 수 있다. *Domain Model 의 concept "리뷰 당위성 확인"* 이 모든 메뉴에 대한 추천 여부를 선택하였는지와 글자수 조건을 만족하였는지 확인하여 리뷰 제출을 가능하게 해준다. 글자수는 changeListener를 이용하여 실시간으로 반영된다.     
조건을 만족하지 못하면 case 1. 추천 여부 미선택 시 dialog 안내, case 2. 최소 5자 이상 작성하지 않았을 시 dialog 안내, case 3. 300자 초과 시 입력 불가로 조건 만족을 유도한다.    
![리뷰작성진입](https://user-images.githubusercontent.com/69567269/120077531-c4feaa80-c0e5-11eb-9021-62b0f95f1214.png)![추천안함](https://user-images.githubusercontent.com/69567269/120077561-e8c1f080-c0e5-11eb-930e-6ba2fc170150.png)        
![5자미만](https://user-images.githubusercontent.com/69567269/120077559-e495d300-c0e5-11eb-9f27-896c2afeb301.png)
![제출가능](https://user-images.githubusercontent.com/69567269/120077573-ff684780-c0e5-11eb-9792-47d6f26efcf0.png)

**식당 보기 뷰** : 식당 이용자는 다른 이용자들이 해당 학식당에 남긴 리뷰들과 그로부터 계산된 총점을 한눈에 확인할 수 있다. 리뷰 평점 계산은 ~~~~~ 주연이 파트 ~~~~~      
![식당보기](https://user-images.githubusercontent.com/69567269/120077647-60901b00-c0e6-11eb-8e7e-cced2aadcfa3.png)    

### 실행 방식 
