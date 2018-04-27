#include<stdio.h>
#include<conio.h>

void print_Menu()
{
	printf("1. ¼·¾¾ => È­¾¾\n");
	printf("2. È­¾¾ => ¼·¾¾\n");
	printf(" Enter Number(1 OR 2): ");
}
double CelToFah()
{
	double Fah = 0;
	double cel = 0;
	
	printf("Cel : ");
	scanf("%lf", &cel);
	Fah = cel * 1.8 + 32;
	return Fah;
}
double FahToCel()
{
	double Cel = 0;
	double Fah = 0;
	printf("Fah : ");
	scanf("%lf", &Fah);
	Cel = 5.0 / 9 * (Fah - 32);
	return Cel;
}
int main(void)
{
	double Cel = 0;
	double Fah = 0;
	int c = 0;
	while (1)
	{
	//	system("cls");
		print_Menu();
		scanf("%d", &c);
		getchar();
		if (c != 1 && c != 2)
			break;
		c == 1 ? (Fah = CelToFah()) : (Cel = FahToCel());

		c == 1 ? printf("Fah : %lf\n", Fah) : printf("Cel : %lf\n", Cel);
		printf(" Complete.");
		getch();
		printf("\n\n");
	}
	return 0;
}