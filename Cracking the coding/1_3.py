def remove_dup(s):
    split_string = list(s)
    answer = []
    for v in split_string:
        if v in answer:
            continue
        else:
            answer.append(v)
    return ''.join(answer)


ans = remove_dup("abababababa")
print(ans)
