# DiceGame
## 주사위 굴리기
BAEKJOON ONLINE JUDGE
14499번 문제


#### 문제
[https://www.acmicpc.net/problem/14499](https://www.acmicpc.net/problem/14499)

#### 풀이

주사위의 상태를 나타내는 `Dice`가 있다. `Dice`는 동서남북으로 이동하는 함수 `moveToEast`, `moveToWest`, `moveToSouth`, `moveToNorth`를 가진다.
주사위 굴리기 게임은 함수 `diceGame`에서 수행하며, 주사위 윗면 값을 담는 배열 `topValue`를 반환한다.

 1. 주사위를 명령에 따라 동서남북으로 이동시킨다.
 2. 주사위가 지도 밖을 벗어나는 경우 반환할 주사위 `topValue[i]` 값을 -1로 지정한다.
 3. 이동한 칸 내 값에 따라 값이 0이면 주사위 `bottom` 값을 복사한다.
 4. 0이 아니면 주사위 `bottom`에 값을 복사하고 해당 칸 값을 0으로 바꾼다.
 5. 반환된 `topValue` 배열 내 -1값이 있는 경우 출력하지 않는다.
