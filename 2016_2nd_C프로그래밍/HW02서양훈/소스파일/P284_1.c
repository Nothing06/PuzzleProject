/*
  num의 주소 : 0x12 라고 가정.
  num의 값 : 10 


  ptr1 : 0x12 (ptr1 = &num)
  ptr2 : 0x12 (ptr2 = ptr1; 으로 인해 ptr1에 저장된 주소값, 즉 num의 주소값이 ptr2에 저장됨.)

  ptr1 => num  <= ptr2 (ptr1과 ptr2가 num을 가리킨다.(==ptr1과 ptr2에 num의 주소값이 저장되어있다.)

  ptr1가 가리키는 int형 변수(num): num의 값 1만큼 후위증가
  ptr2가 가리키는 int형 변수(num): num의 값 1만큼 후위증가

  num의값은 2가 증가되어 (num = 12)
  12 출력.  
*/