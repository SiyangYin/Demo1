BOOK_TABLE:
book_id, book_name,
1, a
2, b
3, c

AUTHOR_TABLE:
author_id, author_name,
1, h
2, e

BOOK_AUTHOR_TABLE:
id, book_id, author_id,
1, 1, 1
2, 1, 2
3, 2, 2
4, 3, 1


select b.book_name, a.author_name
from BOOK_TABLE b inner join BOOK_AUTHOR_TABLE ba on b.book_id = ba.book_id
inner join AUTHOR_TABLE a on ba.author_id = a.author_id
where a.author_name = 'h';