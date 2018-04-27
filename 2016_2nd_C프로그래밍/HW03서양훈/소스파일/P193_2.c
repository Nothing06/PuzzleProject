#include<stdio.h>
//  AiZ
//+ ZiA
//  909
//AiZ와 ZiA를 더해서 909가 되는 경우의 수
int main(void)
{
	int A = 0;
	int Z = 0;
	int i = 0;

	for (A = 0; A < 10; A += 1)
	{
		for (Z = 0; Z < 10; Z += 1)
		{
			if (10 * A + Z + 10 * Z + A == 99)
			{
				printf("A : %d  Z : %d\n", A, Z);
			}
		}
	}

	for (A = 0; A < 10; A += 1)
	{
		for (i = 0; i < 9; i += 1)
		{
			for (Z = 0; Z < 10; Z += 1)
			{
				if (100 * A + 10*i + Z + 100 * Z + 10*i + A == 909)
				{
					printf("A : %d  i: %d  Z : %d\n", A,i,Z);
				}
			}
		}
	}
	return 0;
}