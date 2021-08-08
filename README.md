<div align="center">
<h1>Url-Shortener</h1>
</div>

## 1.Subject 

URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service

    - URL 입력폼 제공 및 결과 출력
    - URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
    - 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
    - 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
    - Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
    - Database 사용은 필수 아님
    - Unit test 및 Integration test 작성.

 ## 2.Environment 

  - JDK 1.8
  - IntelliJ
  - Gradle 7.1.1
  - lombok 1.18.20
  - JPA / Hibernate
  - Spring boot 2.5.3
  - Junit5
  - H2 Database 
  - Mustache

 ## 3.Install 

  - JDK 1.8 Install
  
    - `$ yum install java-1.8.0-openjdk-devel.x86_64`
    
  - Git Install
    
    - `$ yum install git` 

  - Repository Clone

    - `$ git clone https://github.com/min103ju`

    

## 4.Usage

  - Build

    - `$ ./gradlew bootJar`

  - Execute

    - `$ java -jar ./build/libs/url-shortening-*.jar`

    

