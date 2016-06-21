def TowersOfHanoi(numberOfDisks, startPeg = 1, endPeg = 3):
    if numberOfDisks:
        TowersOfHanoi(numberOfDisks - 1, startPeg, 6-startPeg-endPeg)
        print("Move disk %d from peg %d to peg %d" %(numberOfDisks,startPeg,endPeg))
        TowersOfHanoi(numberOfDisks - 1, 6-startPeg-endPeg, endPeg)

TowersOfHanoi(numberOfDisks = 4)
