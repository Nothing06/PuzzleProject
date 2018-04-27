#include<stdio.h>

int main(void)
{
	int n = 0;
	while (1)
	{
		printf("n : ");
		scanf("%d", &n);
		getchar();
		if (n < 0)
		{
			printf("PROGRAM Á¾·á.\n");
			break;
		}
		switch (n)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			printf("* Range of n : 0 <= n < 10\n");
			break;
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
			printf("* Range of n : 10 <= n < 20\n");
			break;
		case 20:
		case 21:
		case 22:
		case 23:
		case 24:
		case 25:
		case 26:
		case 27:
		case 28:
		case 29:
			printf("* Range of n : 20 <= n < 30\n");
			break;
		default:
			printf("* Range of n : n >= 30\n");
			break;
		}
		printf("\n");
	}
	return 0;
}