#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct s
{
	char empname[10];
	char jumino[20];
	int salary;
}Employee;
void clearBuffer()
{
	while (getchar() != '\n');
}
void print_emp_info(Employee e)
{
	printf("============================\n");
	printf("이름 : %s\n", e.empname);
	printf("주민등록번호 : %s\n", e.jumino);
	printf("급여 : %d\n", e.salary);
	printf("============================\n");
}
int main(void)
{
	Employee e[3];
	int i = 0;

	for (i = 0; i < 3; i += 1)
	{

		printf("이름 : ");
		fgets(e[i].empname, 10, stdin);
		if (e[i].empname[strlen(e[i].empname) - 1] == '\n')
			e[i].empname[strlen(e[i].empname) - 1] = 0;
		else
			clearBuffer();
		printf("주민등록번호: ");
		fgets(e[i].jumino, 20, stdin);
		if (e[i].jumino[strlen(e[i].jumino) - 1] == '\n')
			e[i].jumino[strlen(e[i].jumino) - 1] = 0;
		else
			clearBuffer();
		printf("급여: ");
		scanf("%d", &e[i].salary);
		getchar();
	}

	for (i = 0; i < 3; i += 1)
	{
		print_emp_info(e[i]);
	}
	return 0;
}