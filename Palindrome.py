import sys
sys.stdin = open("input.txt", 'r')
n = int(input())
for i in range(n):
    s=input()
    s=s.upper() #Make it upper case for easy comparison
    size=len(s)
    #or if s == s[::-1] -> reverse string without a loop
    for j in range(size//2): #check the first half and the last half
      if s[j] != s[-1-j]: 
        print("#%d False" %(i+1))
        break
    else:
      print("#%d True" %(i+1))
     
