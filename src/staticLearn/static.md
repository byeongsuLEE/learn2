# static
- 모든 인스턴스가 공유되는 변수를 쓰고 싶을 때, 클래스의 특정 인스턴스와 관련 없는 기능을 제공할때 사용한다.
- 메서드 영역에 저장된다.

## static 명칭
- static이 붙은 함수나 변수는 클래스 또는 정적 변수 및 함수라고 부른다.

## static method import
- import static 클래스명.*(또는 특정 메서드 이름)
- 정적 변수, 메서드 둘 다 사용 가능

# URI, URN, URL

![[Pasted image 20250407212113.png]]
# URI , URL 뭔차이인데?
## URL (Uniform Resource Locator)
인터넷상에서 자원을 식별하는 문자열이다.

## URi(Uniform Resource Identifier)
인터넷에서 프로토컬을 포함한 자원의 위치를 나타내는 문자열임

![[Pasted image 20250912134323.png]]

## URN(Uniform Resource Name)
자원의 위치에 상관없이 자원의 이름을 식별하는 방식임
 자원의 위치가 변하더라도 동일한 식별자를 유지할 수 있게 합니다. 특정 스키마를 따르며, 자원에 대한 영구적인 식별자를 제공합니다. ex) `urn:isbn:0451450523` (특정 책의 ISBN 번호)
