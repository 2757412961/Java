Select activity_date As 'day', Count(Distinct user_id) As active_users
From Activity
Where 0 <= DateDiff('2019-07-27', activity_date) And DateDiff('2019-07-27', activity_date) < 30
Group By activity_date
