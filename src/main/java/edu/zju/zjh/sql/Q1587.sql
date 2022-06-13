Select name, Sum(amount) As balance
From Users u, Transactions t
Where u.account = t.account
Group By u.account
Having Sum(t.amount) > 10000
