Select stock_name, Sum(Case operation When 'Buy' Then -price Else price End) As capital_gain_loss
From Stocks
Group By stock_nameac