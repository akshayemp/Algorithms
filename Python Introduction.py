"""
Introduces python programming to me
"""

#Python numbers
age = 26
pi = 3.14159

#Python String
string = "prerit anwekar"
tokens = string.split()

firstName = tokens[0]
lastName = tokens[1]

my_name = firstName + " " + lastName


#if else

if(string == my_name):
    print("Yes both are same!")
else:
    print("No both are not same!")

#Python list

students = ['Adnan', 'Zain', 'Aown']
students.append('All')

for student in students:
    print 'Hello!', student

#Python tuples Immutable
ages = (19,22,18)
uniqueAges = set(ages)
uniqueAges.add(18)
uniqueAges.remove(22)

for thisAge in uniqueAges:
    print thisAge

if 18 in uniqueAges:
    print 'There is a n 18-year old present!'

students.sort()
orderedUniqueAges = sorted(uniqueAges)
print orderedUniqueAges

#Dictionary
netWorth = {}
netWorth['Donal Trump'] = 300000000
netWorth['Bill Gates'] = 39999999999
netWorth['prerit'] = 20000000000000000
netWorth['gareeb'] = 200

for(person, worth) in netWorth.items():
    if worth < 10000:
        print 'hmm!', person, "is not a millionare"

if 'TOm cruise' not in netWorth:
    print "Show me the money"


