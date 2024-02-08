from collections.abc import Iterator
import re
from typing import Match

s = input()
r = re.compile(r'\D+')
res = r.finditer(s)

def do(iter:Iterator[Match[str]], string='',pend=0)->str:
    try:
        match = next(iter)
    except StopIteration:
        return string
    number = int(number) if (number:=match.string[pend:match.start()]) else 1
    string += match.string[match.start():match.end()]*number
    return do(iter, string, match.end())

print(do(res))
