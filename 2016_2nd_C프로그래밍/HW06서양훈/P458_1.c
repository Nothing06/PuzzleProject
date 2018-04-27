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
}
int main(void)
{
	Employee a;

	printf("이름 : ");
	fgets(a.empname, 10, stdin);
	if (a.empname[strlen(a.empname) - 1] == '\n' )
		a.empname[strlen(a.empname) - 1] = 0;
	else
		clearBuffer();
	printf("주민등록번호: ");
	fgets(a.jumino, 20, stdin);
	if (a.jumino[strlen(a.jumino) - 1] == '\n')
		a.jumino[strlen(a.jumino) - 1] = 0;
	else
		clearBuffer();
	printf("급여: ");
	scanf("%d", &a.salary);


	print_emp_info(a);
	return 0;
}