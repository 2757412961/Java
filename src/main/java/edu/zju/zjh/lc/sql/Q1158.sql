Select user_id As 'buyer_id', join_date, case When orders_in_2019 Is Null Then 0 Else orders_in_2019 End As orders_in_2019
From Users u Left Join (Select buyer_id, Count(buyer_id) As orders_in_2019
                        From Orders
                        Where Year(order_date) = 2019
                        Group By buyer_id) o On u.user_id = o.buyer_id