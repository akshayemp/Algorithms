from collections import namedtuple
metro_data = [('Tokyo','JP',36.933,(35.689722,139.691667)) \
        ,('Delhi','IN',21.935,(28.613889,77.208889))]

LatLong = namedtuple('LatLong','lat long')

Metropolis = namedtuple('Metropolis','name cc pop coord')
metro_areas = [Metropolis(name,cc,pop,LatLong(lat,long))\
        for name,cc,pop,(lat,long) in metro_data]

print(metro_areas[0])

metro_areas[0].coord.lat

from operator import attrgetter
name_lat = attrgetter('name','coord.lat')

for city in sorted(metro_areas,key=attrgetter('coord.lat')):
    print(name_lat(city))

print(metro_areas[0])
print(metro_areas[0].coord.lat)

from operator import attrgetter


name_lat = attrgetter('name','coord.lat')

for city in sorted(metro_areas,key=attrgetter('coord.lat')):
    print(name_lat(city))

