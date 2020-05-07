var str1, str2, str3;

str1 = "John"
str2 = new String("John"); //비추

console.log(str1)
console.log(str2.toString())


console.log(str1 == str2)
console.log(str1 === str2)

console.log(str1.length);

str2 = "Hello Java Web FrameWork";
console.log(str2);
//문자열 리터럴 중간을 끊어서 작성할 경우 ..
str2 = "Hello Java W\
eb FrameWork";
console.log(str2);


// indexOf(), lastIndexOf(), search() : 문자열 안에서 문자열 찾기
// 찾은 위치 인덱스 리턴, 못찾으면 -1 리턴
console.log("문자열 검색 \nindexOf(), lastIndexOf(), search()");
str1 = "Please locate where 'locate' occurs!";

console.log(str1.indexOf("locate"))  // 7번째 발견
console.log(str1.lastIndexOf("locate"))  // 21번째 발견

console.log(str1.indexOf("John"))  // 못 찾으면 -1 리턴
console.log(str1.indexOf("locate", 10))  // 10번재부터 검색시작
console.log(str1.indexOf("locate", 25))

// search() : 문자열 안에서 문자열 찾기
console.log(str1.search("locate"))  // 7

// search() vs indexOf() : 둘은 다르다!
// 	search() : 두번째 매개변수 없다
// 	indexOf() : regexp 사용 불가





//문자열 추출
//slice(start, end)
//substring(start, end)
//substr(start, length)
console.log("문자열 추출<br>slice(), substring(), substr()");
str = "Apple, Banana, Kiwi";






