def solution(s):
    eng = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    for r in range(10):
        s = s.replace(eng[r], str(r))

    return int(s)
