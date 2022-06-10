Select id,
       Case
           WHEN p_id Is Null THEN 'Root'
           WHEN id In (Select p_id From Tree) THEN 'Inner'
           Else 'Leaf'
           End As Type
From tree