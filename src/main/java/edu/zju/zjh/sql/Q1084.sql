Select p.product_id, p.product_name
From Product p Left Join Sales s On p.product_id = s.product_id
Group By p.product_id
Having '2019-01-01' <= Min(sale_date) And Max(sale_date) <= '2019-03-31'
