def power_of_n(n, p):
    if p == 1:
        return n
    elif p == 0:
        return 1
    elif p < 0:
        N = n * power_of_n(n,(p*-1)-1)
        return 1/N
        # return "Please enter a positive number habibi"
    else:
        N = n * power_of_n(n,p-1)
        return N

print(power_of_n(6,-1))