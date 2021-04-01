def fibMemo():
    pad = {0:0, 1:1}
    def func(n):
        if n not in pad:
            pad[n] = func(n-1) + func(n-2)
        return pad[n]
    return func
 
fm = fibMemo()
for i in range(1,31):
    print (i),

import timeit
start_time = timeit.timeit()
print("--- %0.10f seconds ---" % (timeit.timeit() - start_time))
