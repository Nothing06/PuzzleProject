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
	printf("�̸� : %s\n", e.empname);
	printf("�ֹε�Ϲ�ȣ : %s\n", e.jumino);
	printf("�޿� : %d\n", e.salary);
	printf("============================\n");
}
int main(void)
{
	Employee e[3];
	int i = 0;

	for (i = 0; i < 3; i += 1)
	{

		printf("�̸� : ");
		fgets(e[i].empname, 10, stdin);
		if (e[i].empname[strlen(e[i].empname) - 1] == '\n')
			e[i].empname[strlen(e[i].empname) - 1] = 0;
		else
			clearBuffer();
		printf("�ֹε�Ϲ�ȣ: ");
		fgets(e[i].jumino, 20, stdin);
		if (e[i].jumino[strlen(e[i].jumino) - 1] == '\n')
			e[i].jumino[strlen(e[i].jumino) - 1] = 0;
		else
			clearBuffer();
		printf("�޿�: ");
		scanf("%d", &e[i].salary);
		getchar();
	}

	for (i = 0; i < 3; i += 1)
	{
		print_emp_info(e[i]);
	}
	return 0;
}