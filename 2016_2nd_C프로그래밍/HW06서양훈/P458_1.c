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
}
int main(void)
{
	Employee a;

	printf("�̸� : ");
	fgets(a.empname, 10, stdin);
	if (a.empname[strlen(a.empname) - 1] == '\n' )
		a.empname[strlen(a.empname) - 1] = 0;
	else
		clearBuffer();
	printf("�ֹε�Ϲ�ȣ: ");
	fgets(a.jumino, 20, stdin);
	if (a.jumino[strlen(a.jumino) - 1] == '\n')
		a.jumino[strlen(a.jumino) - 1] = 0;
	else
		clearBuffer();
	printf("�޿�: ");
	scanf("%d", &a.salary);


	print_emp_info(a);
	return 0;
}