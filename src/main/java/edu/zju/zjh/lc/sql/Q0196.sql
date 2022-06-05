# a. 从表p1取出3条记录；
# b. 拿着第1条记录去表p2查找满足WHERE的记录，代入该条件p1.Email = p2.Email AND p1.Id > p2.Id后，发现没有满足的，所以不用删掉记录1；
# c. 记录2同理；
# d. 拿着第3条记录去表p2查找满足WHERE的记录，发现有一条记录满足，所以要从p1删掉记录3；
# e. 3条记录遍历完，删掉了1条记录，这个DELETE也就结束了。

# SELECT p1.id, p1.email
# FROM person p1, person p2
# WHERE p1.email = p2.email AND p1.id > p2.id

DELETE p1
FROM person p1, person p2
WHERE p1.email = p2.email AND p1.id > p2.id