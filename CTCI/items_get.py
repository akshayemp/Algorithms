metro_data = [('Tokyo','JP',36.933,(35.689722,139.691667)) \
        ,('Delhi','IN',21.935,(28.613889,77.208889))]

from operator import itemgetter
for city in sorted(metro_data,key=itemgetter(1)):
    print(city)

cc_name = itemgetter(1,0)
for city in metro_data:
    print(cc_name(city))
