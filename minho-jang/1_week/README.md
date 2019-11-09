## 1주차 스터디

### 완전탐색
Brute Force라고도 불리는 방법으로, 무식하게 가능한 모든 방법을 고려한다.
예를 들어, 숫자로만 비밀번호 4자리를 추측한다고 할 때, 0000부터 9999까지 모든 경우를 대입해보는 것은 의미한다.

----

### 정렬
- [Bubble Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/BubbleSort.java)
- [Insertion Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/InsertionSort.java)
- [Merge Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/MergeSort.java)
- [Quick Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/QuickSort.java)
- [Selection Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/SelectionSort.java)
- [Radix Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/RadixSort.java)
- [Counting Sort](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/sort/CountingSort.java)
- [Heap](https://github.com/minho-jang/Univ/blob/master/2019-summer/Algorithms/src/data_structure/Heap.java)
- etc

여러 정렬 알고리즘이 존재하지만 속도가 빠른 Quick, Merge에 대해서 비교한다. 오름차순 정렬이라고 가정한다.
- Quick Sort
1. 리스트 중 하나의 요소를 고른다.(pivot 선정)
2. pivot보다 작은 요소는 pivot 앞으로, pivot보다 큰 요소는 pivot 뒤로 오도록 리스트를 2개로 분할한다.
3. 분할된 2개의 리스트에 대해 재귀적으로 반복한다.

시간복잡도는 평균적으로 O(nlogn)이며 최악의 경우 O(n^2)이다.</br>
최악의 경우는 항상 한 쪽은 0개, 다른 쪽은 n-1개로 분할되는 경우를 말한다.</br>
최선의 경우는 항상 절반으로 분할되는 경우이다. 이는 Merge Sort와 같은 시간 복잡도를 가진다.</br>

- Merge Sort
1. 리스트를 더이상 쪼갤 수 없을 때까지 분할한다. (재귀호출)
2. 분할된 두 리스트의 첫 번째 요소를 비교하여 작은 수를 새로운 리스트에 넣고 해당 요소는 지운다.
3. 두 리스트의 요소가 모두 지워질 때까지 2번을 반복한다. 새로운 리스트는 두 리스트의 요소들이 정렬된 리스트가 된다.
4. 모든 분할된 리스트가 재귀호출에 의해 2,3번을 반복하면 오름차순 정렬이 된다.

시간복잡도는 O(nlogn)이다.

#### 왜 Quick Sort를 사용하는가?</br>
Merge Sort는 알고리즘을 수행하는데 새로운 리스트를 생성하는 시간때문에 Quick Sort보다 느리다.</br>
###### 참고: https://penpen.tistory.com/entry/Algorithm-Quick-Sort-Merge-Sort-%EB%B9%84%EA%B5%90%EC%B2%B4%ED%97%98)

#### 정렬 알고리즘 시간복잡도
|  <center>알고리즘</center> |  <center>최선</center> |  <center>평균</center> |  <center>최악</center> |
|:--------|:--------:|:--------:|:--------:|
| 삽입 정렬 | O(n) | O(n^2) | O(n^2) |
| 선택 정렬 | O(n^2) | O(n^2) | O(n^2) |
| 버블 정렬 | O(n^2) | O(n^2) | O(n^2) |
| 퀵 정렬 | O(nlogn) | O(nlogn) | O(n^2) |
| 힙 정렬 | O(nlogn) | O(nlogn) | O(nlogn) |
| 합병 정렬 | O(nlogn) | O(nlogn) | O(nlogn) |
| 기수 정렬 | O(dn) | O(dn) | O(dn) |

----

### 문자열
- `String`
- `StringBuiler`
- `StringBuffer`

`String`은 `new` 연산을 통해 생성되면 그 인스턴스의 메모리 공간을 절대 변하지 않는다.
그래서 `+` 연산이나 `concat()`을 이용해서 문자열에 변화를 줘도 메모리 공간이 변하는 것이 아니라
새로운 `String` 객체를 만들어서 새로운 메모리 공간을 만드는 것이다.

이렇게 새로운 문자열이 만들어지면 기존의 문자열은 가비지 콜렉터에 의해 제거되야 하는 단점이 있다.
또한 이러한 문자열 연산이 많아질 때, 계속해서 객체를 만드는 오버헤드가 발생하므로 성능이 떨어진다.
대신, `String` 클래스의 객체는 불변하기 때문에 단순한 조회연산은 빠르다.
불변하기 때문에 멀티쓰레드 환경에서 동기화를 신경쓸 필요가 없다.

`StringBuffer`와 `StringBuilder`는 `String`과 다르게 변경가능(mutable)하다.
즉, 문자열 연산에 있어서 클래스를 한 번만 만들고(`new`), 연산이 필요할 때 크기를 변경시켜서 문자열을 변경한다.
그러므로 문자열 연산이 자주 있을 때 사용하면 성능이 좋다.

`StringBuffer`와 `StringBuilder`의 차이는 무엇일까?
`StringBuffer`는 멀티쓰레드 환경에서 `synchronized` 키워드가 가능하므로 동기화가 가능하다.(thread-safe)
`StringBuilder`는 동기화를 지원하지 않기 때문에 멀티쓰레드 환경에서 적합하지 않다.
대신, `StringBuilder`는 동기화를 고려하지 않기 때문에 싱글쓰레드 환경에서 `StringBuffer`에 비해 연산처리가 빠르다.

###### 참고: https://jeong-pro.tistory.com/85

- `Scanner`
- `BufferedReader`

`Scanner`는 자바에서 입력을 처리하기 위해 흔히 사용되는 클래스이다.
하지만 입력을 많이 받아야 하는 경우 속도가 느리기 때문에 `BufferedReader`를 사용해야 한다.

100만개의 정수를 입력받는데 `Scanner`는 2441ms, `BufferedReader`는 452ms가 소요된다.</br>
###### 참고: https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220811824303&proxyReferer=https%3A%2F%2Fwww.google.com%2F
