Select firstName, lastName, city, a.state As 'state'
From person p Left Join address a On p.personId = a.personId