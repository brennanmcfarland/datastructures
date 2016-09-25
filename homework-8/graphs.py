import matplotlib.pyplot as plt
import math

x = [1000,10000,100000,1000000]

#SORTED
y = [424034,2415532,8619201,115832794] #heapsort
plt.scatter(x,y,color='b')
plt.plot(x,y,color = 'b')
y = [1259344,3142933,2763760,34260842] #quicksort
plt.scatter(x,y,color='r')
plt.plot(x,y,color='r')
y = [1158570,301946,5019850,58612672] #mergesort
plt.scatter(x,y,color='g')
plt.plot(x,y,color='g')

plt.xlabel("Array Size")
plt.ylabel("Running Time \(ns\)")
plt.show()

#REVERSE SORTED
y = [57267,680848,8660677,114811565] #heapsort
plt.scatter(x,y,color='b')
plt.plot(x,y,color = 'b')
y = [185240,2280115,2871455,33899842] #quicksort
plt.scatter(x,y,color='r')
plt.plot(x,y,color='r')
y = [924655,704638,5402852,63148096] #mergesort
plt.scatter(x,y,color='g')
plt.plot(x,y,color='g')

plt.xlabel("Array Size")
plt.ylabel("Running Time \(ns\)")
plt.show()

#RANDOM
y = [74582,967071,12868577,226602059] #heapsort
plt.scatter(x,y,color='b')
plt.plot(x,y,color = 'b')
y = [83209,1015219,12748436,151498923] #quicksort
plt.scatter(x,y,color='r')
plt.plot(x,y,color='r')
y = [73582,1060676,13428428,165626575] #mergesort
plt.scatter(x,y,color='g')
plt.plot(x,y,color='g')

plt.xlabel("Array Size")
plt.ylabel("Running Time \(ns\)")
plt.show()
