Select actor_id, director_id
From ActorDirector
Group By actor_id, director_id
Having Count(*) > 2
