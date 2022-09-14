x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

x[1][0] = 15
print(x)

students[0]['last_name'] = 'Bryant'
print(students)

sports_directory['soccer'][0] = 'Andres'
print(sports_directory)

z[0]['y'] = 30
print(z)

print("#"*100)


students = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]

def iterateDictionary():
        for i in students:
            print("first_name", "-", i['first_name'],", ", 'last_name', "=",i['last_name'])
iterateDictionary()

print("#"*100)

def iterateDictionary2(key_name, some_list):
    for i in some_list:
        print(i[key_name])
        
iterateDictionary2('first_name', students)
iterateDictionary2('last_name', students)
    
print("#"*100)

dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(some_dictionary):
    for i in some_dictionary:
        print(len(some_dictionary[i]), i.upper())
        for j in some_dictionary[i]:
            print(j)
printInfo(dojo)

