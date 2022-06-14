Select Distinct a.num As ConsecutiveNums
From Logs a Cross Join Logs b Cross Join Logs c On a.id = b.id-1 And a.id = c.id-2
Where a.num = b.num And b.num = c.num