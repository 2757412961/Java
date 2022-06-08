Select user_id, Max(time_stamp) As last_stamp
From Logins
Where EXTRACT(Year from time_stamp) = 2020
Group By user_id
