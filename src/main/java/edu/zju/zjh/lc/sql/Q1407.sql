Select name, Coalesce(travelled_distance, 0) As travelled_distance
From Users u Left Join (
    Select user_id As id, Sum(distance) As travelled_distance
    From Rides
    Group By user_id
) o On u.id = o.id
Order By travelled_distance DESC, name ASC