Select customer_id, Count(customer_id) As count_no_trans
From Visits v Left Join Transactions t On v.visit_id = t.visit_id
Where transaction_id Is Null
Group By customer_id