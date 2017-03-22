'''
This program finds the difference in increasing and decreasing subranges in house prices within a window.
'''

class Amne():
    # Initializes the constraints, house prices, number of
    # homes and window sizes.
    def __init__(self):
        contraints_variables,self.prices = self.read_input() # Reads the input.
        self.num_homes,self.window_size = contraints_variables # Un-wrapping the constraints.
        if self.window_size > self.num_homes: # Checking if the window size is in range.
            self.window_size = self.num_homes
        
    # Read input file from the folder input.
    def read_input(self):
        f = open("./input.txt","r") # Open the input file in read mode.
        try:
            lines = f.readlines() 
            data = []
            for line in lines:
                data.append(list(map(int,line.strip().split(" ")))) # make list of the values.
            return data
        finally:
            f.close()
    # Write output to output folder.
    def write_output(self,result):
        f = open("./output.txt","w")
        try:
            output_string = "\n".join([str(value) for value in result]) # Convert the result into string to write in file.
            f.write(output_string)
        finally:
            f.close()

    # This function finds the subranges and stores them in
    # a list. Once the list is formed the output is written
    # to output file.
    def find_subranges(self):
        table,aux,result = [],[],[] # table is the memoizing table,
                                    # aux   is the memoizing for any special range.
                                    # result stores final result.
        adder,extra = 0,0
        if self.window_size in [0,1]:
            self.write_output([0]*self.num_homes) # if in above range, we have a base cases.
        if not self.num_homes: # the list is empty, another base case.
            return 
        for idx in range(self.num_homes-1): 
            if self.prices[idx] < self.prices[idx+1]: # keep the counts of increasing and decreasing values.
                table.append(1)
                adder += 1
            elif self.prices[idx] > self.prices[idx+1]: 
                table.append(-1)
                adder += -1
            else:
                table.append(0) # if prices are same.
            if (len(table)>1) and (table[-1] ==  table[-2]): # append a 1 or -1 in aux depending on if there are consequetive increase or decrease.
                aux.append(table[-1])
                extra += table[-1]
            if len(table) == self.window_size -1:
                result.append(adder+extra) # add all the values and append to the result.
                if (len(aux)>0) and (table[0] == aux[-1]): # moving the window and keeping the values in the memoized tables accordingly.
                    extra -= aux.pop()
                adder -= table[0]
                table = table[1:] # Move the sliding window.
        self.write_output(result) # Write the results to output file
                
                                
amne = Amne()
amne.find_subranges()

