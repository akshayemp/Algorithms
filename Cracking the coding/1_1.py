def unique_char(s):
    hash_map = {}
    for ch in s:
        if ch not in hash_map:
            hash_map[ch] = True
        else:
            return False
    return True

answer = unique_char("wwater")
print(answer)
