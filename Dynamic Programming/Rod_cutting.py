class Rod():
    def __init__(self,profits,lengths):
        self.profits = profits
        self.lengths = lengths

    def recursive_cut_rod(self,n):
        if n==0:
            return 0
        q = float('-inf')
        for i in range(0,n):
            q = max(q,self.profits[i]+self.recursive_cut_rod(n-i-1))
        return q

    def memoized_cut_rod(self,n):
        r = [-float('inf')]*(n+1)
        return self.memoized_cut_rod_aux(n,r)

    def memoized_cut_rod_aux(self,n,r):
        if r[n] >= 0:
            return r[n]
        if n == 0:
            q = 0
        else:
            q = -float('inf')
            for i in range(1,n):
                q = max(q,self.profits[i]+self.memoized_cut_rod_aux(n-i-1,r))
        r[n] = q
        return q

    def bottom_up_cut_rod(self,n):
        r = [None] * (n+1)
        r[0] = 0
        for i in range(1,n+1):
            q = -float('inf')
            for j in range(1,i):
                q = max(q,self.profits[j]+r[i-j-1])
            r[i] = q
        return r[n]

    
        
            
rod = Rod([1,5,8,9,10,17,17,20,24,30],[1,2,3,4,5,6,7,8,9,10])
ans = rod.bottom_up_cut_rod(3)
print(ans)
