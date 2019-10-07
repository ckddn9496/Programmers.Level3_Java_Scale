# Programmers.Level3_Java_Scale

## 프로그래머스 > 탐욕법(Greedy) > 저울

### 1. 문제설명

문제: https://programmers.co.kr/learn/courses/30/lessons/42886

input으로 저울추의 무게를 담은 `int[] weight`이 들어온다. 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값을 return하는 문제.

### 2. 풀이

#### 1) DFS를 이용한 방법

DFS를 이용하여 모든 추에 대하여 사용할지, 하지않을지 검사하고 완성된 추의 합을 `HashSet`에 저장하여 만들어 질 수 있는 모든 무게의 경우를 계산하는 방법을 이용하였다. 생각하기 쉬운 방법이며 DFS를 이용하여 쉽게 구현가능하지만 O(N!)의 복잡도를 가지므로 비효율적인 방법이며 결과적으로 시간초과가 일어났다.

```java
void dfs(int totalWeight, int step) {
	if (n == step) {
		weightSet.add(totalWeight);
		return;
	}

	dfs(totalWeight + mWeight[step], step + 1);
	dfs(totalWeight, step + 1);
}
```

#### 2) Greedy

모든 추의 무게에 대하여 오름차순으로 `weights`를 정렬하였다. 이후 앞에서 부터 추를 이용하여 만들어 질 수 있는 무게를 생각하였다. 첫번째로 무게가 `1`인 추가 존재하지 않는다면 `1`을 return한다. 무게가 `1`인 추가 존재한다면, 무게가 작은 추들을 차례로 탐색한다. `i`번째로 무거운 추를 사용하기 위해서는 첫번째 추 부터 `i-1`번째의 추들로 `weight[i]-1`까지의 무게를 측정할 수 있어야만 한다. 그렇지 않다면 `1 ~ i-1`까지의 추로 만들수 있는 최대 무게에 1을 더한 무게를 return하면 된다.

```java
public int solution(int[] weight) {
  Arrays.sort(weight);
  int sum = 0;
  for (int i = 0; i < weight.length; i++) {
    if (sum+1 >= weight[i]) {
      sum += weight[i];				
    } else {
      return sum+1;
    }
  }

  return sum+1;
}
```
