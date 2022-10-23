# def is_leap_year(year):
#     if (year % 4 == 0 and year % 100 != 0 or year % 400==0):
#         return True
#     return False
# print(is_leap_year(1800))

# def sum(ar):
#     z=0
#     for i in range(0, count):
#         z=z+ ar[i]
#     return z
# print(sum(5))
def is_weird(n):
    if n % 2 == 1:
        print("Weird")
    elif n % 2 == 0 and 2 <= n <= 5:
        print("Not Weird")
    elif n % 2 == 0 and 6 <= n <= 20:
        print("Weird")
    else:
        print("Not Weird")
print(is_weird(4))