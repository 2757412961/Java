Select a.id
From Weather a Left Join Weather b On DateDiff(a.recordDate, b.recordDate) = 1
Where a.temperature > b.temperaturea