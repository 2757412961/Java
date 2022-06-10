Select (Select Distinct salary
        From employee
        Order By salary DESC
        Limit 1, 1) As 'SecondHighestSalary'
