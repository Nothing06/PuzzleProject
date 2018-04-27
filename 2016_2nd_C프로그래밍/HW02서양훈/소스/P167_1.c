#include<stdio.h>
#define GET_BIG_NUM(a,b) a>b ? a: b
#define GET_SML_NUM(a,b) a>b ? b: a
// 문제에 제시된  마지막줄 조건이 없다는 전제하에 품.(추가실험)
int main(void)
{
	int n1 = 0, n2 = 0;
	int big = 0;
	int small = 0;
	int i = 0;
	int sum = 0;

	printf("두 개의 정수 입력: ");
	scanf("%d %d", &n1, &n2);
	big = GET_BIG_NUM(n1, n2);
	small = GET_SML_NUM(n1, n2);

	for (i = small; i <= big; i += 1)
	{
		sum += i;
	}
	printf("sum : %d\n", sum);
	return 0;
}