Select s.name
From SalesPerson s
Where sales_id Not In (
    Select sales_id
    From Company c, Orders o
    Where o.com_id = c.com_id And c.name = 'RED'
)
